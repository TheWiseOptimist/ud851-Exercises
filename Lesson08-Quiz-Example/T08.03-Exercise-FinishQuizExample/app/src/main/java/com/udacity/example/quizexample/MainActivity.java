/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.udacity.example.quizexample;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.udacity.example.droidtermsprovider.DroidTermsExampleContract;

/**
 * Gets the data from the ContentProvider and shows a series of flash cards.
 */

public class MainActivity extends AppCompatActivity {

    private static final String CURRENT_WORD = "current_word";
    private static final String CURRENT_DEFINITION = "current_definition";
    private static final String CURRENT_POSITION = "current_position";
    private static final String CURRENT_STATE = "current_state";
    private static final String BUTTON_TEXT = "button_text";
    // The data from the DroidTermsExample content provider
    private Cursor mData;

    // The current state of the app
    private int mCurrentState;

    private Button mButton;
    private TextView mTextViewWord;
    private TextView mTextViewDefinition;
    private String mCurrentWord;
    private String mCurrentDefinition;
    int mWordCol;
    private int mDefCol;
    private int mCurrentPosition = -1;

    // This state is when the word definition is hidden and clicking the button will therefore
    // show the definition
    private final int STATE_HIDDEN = 0;

    // This state is when the word definition is shown and clicking the button will therefore
    // advance the app to the next word
    private final int STATE_SHOWN = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the views
        // TODO completed (1) You'll probably want more than just the Button
        mButton = findViewById(R.id.button_next);
        mTextViewDefinition = findViewById(R.id.text_view_definition);
        mTextViewWord = findViewById(R.id.text_view_word);

        //Run the database operation to get the cursor off of the main thread

        if (savedInstanceState != null) {

            mButton.setText(savedInstanceState.getString(BUTTON_TEXT));

            mCurrentWord = savedInstanceState.getString(CURRENT_WORD);
            mTextViewWord.setText(mCurrentWord);

            mCurrentState = savedInstanceState.getInt(CURRENT_STATE);
            mCurrentDefinition = savedInstanceState.getString(CURRENT_DEFINITION);
            if (mCurrentState == STATE_HIDDEN) {
                mTextViewDefinition.setText(R.string.think_definition);
            } else {
                mTextViewDefinition.setText(mCurrentDefinition);
            }

            mCurrentPosition = savedInstanceState.getInt(CURRENT_POSITION);

        } else {
            new WordFetchTask().execute();
        }

    }

    /**
     * This is called from the layout when the button is clicked and switches between the
     * two app states.
     *
     * @param view The view that was clicked
     */
    public void onButtonClick(View view) {

        // Either show the definition of the current word, or if the definition is currently
        // showing, move to the next word.
        switch (mCurrentState) {
            case STATE_HIDDEN:
                showDefinition();
                break;
            case STATE_SHOWN:
                nextWord();
                break;
        }
    }

    public void nextWord() {

        // Change button text
        mButton.setText(getString(R.string.show_definition));

        // TODO completed (3) Go to the next word in the Cursor, show the next word and hide the definition
        // Note that you shouldn't try to do this if the cursor hasn't been set yet.
        // If you reach the end of the list of words, you should start at the beginning again.
        mCurrentState = STATE_HIDDEN;

        if (mData == null) {
            new WordFetchTask().execute();

        } else {
            if (!mData.moveToNext()) {
                mData.moveToFirst();
            }

            mCurrentWord = mData.getString(mWordCol);
            mCurrentDefinition = mData.getString(mDefCol);
            mTextViewWord.setText(mCurrentWord);
            mTextViewDefinition.setText(R.string.think_definition);
        }
    }

    public void showDefinition() {

        // Change button text
        mButton.setText(getString(R.string.next_word));

        // TODO completed (4) Show the definition
        mCurrentState = STATE_SHOWN;
        mTextViewDefinition.setText(mCurrentDefinition);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // TODO completed (5) Remember to close your cursor!
        if (mData != null)
            mData.close();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(BUTTON_TEXT, mButton.getText().toString());
        outState.putString(CURRENT_WORD, mCurrentWord);
        outState.putInt(CURRENT_STATE, mCurrentState);
        outState.putString(CURRENT_DEFINITION, mCurrentDefinition);

        if (mData != null) {
            outState.putInt(CURRENT_POSITION, mData.getPosition());
        } else {
            outState.putInt(CURRENT_POSITION, mCurrentPosition);
        }
    }

    // Use an async task to do the data fetch off of the main thread.
    public class WordFetchTask extends AsyncTask<Void, Void, Cursor> {

        // Invoked on a background thread
        @Override
        protected Cursor doInBackground(Void... params) {
            // Make the query to get the data

            // Get the content resolver
            ContentResolver resolver = getContentResolver();

            // Call the query method on the resolver with the correct Uri from the contract class
            Cursor cursor = resolver.query(DroidTermsExampleContract.CONTENT_URI,
                    null, null, null, null);
            return cursor;
        }


        // Invoked on UI thread
        @Override
        protected void onPostExecute(Cursor cursor) {
            super.onPostExecute(cursor);

            // Set the data for MainActivity
            mData = cursor;
            mWordCol = mData.getColumnIndex(DroidTermsExampleContract.COLUMN_WORD);
            mDefCol = mData.getColumnIndex(DroidTermsExampleContract.COLUMN_DEFINITION);

            // TODO completed (2) Initialize anything that you need the cursor for, such as setting up
            // the screen with the first word and setting any other instance variables

            mData.moveToPosition(mCurrentPosition);
            nextWord();
        }
    }

}
