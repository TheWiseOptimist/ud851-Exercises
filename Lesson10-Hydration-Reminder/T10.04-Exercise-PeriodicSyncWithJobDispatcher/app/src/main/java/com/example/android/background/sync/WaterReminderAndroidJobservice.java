package com.example.android.background.sync;

import android.app.job.JobParameters;
import android.app.job.JobService;

public class WaterReminderAndroidJobservice extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
// TODO (4) Override onStartJob
// TODO (5) By default, jobs are executed on the main thread, so make an anonymous class extending
//  AsyncTask called mBackgroundTask.
// TODO (6) Override doInBackground
// TODO (7) Use ReminderTasks to execute the new charging reminder task you made, use
// this service as the context (WaterReminderFirebaseJobService.this) and return null
// when finished.
// TODO (8) Override onPostExecute and called jobFinished. Pass the job parameters
// and false to jobFinished. This will inform the JobManager that your job is done
// and that you do not want to reschedule the job.

// TODO (9) Execute the AsyncTask
// TODO (10) Return true

// TODO (11) Override onStopJob
// TODO (12) If mBackgroundTask is valid, cancel it
// TODO (13) Return true to signify the job should be retried
