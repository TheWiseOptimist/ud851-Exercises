package com.example.android.background.utilities;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.VibrationEffect;


import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;


import com.example.android.background.MainActivity;
import com.example.android.background.R;

/**
 * Utility class for creating hydration notifications
 */
public class NotificationUtils {

    public static final int CONTENT_INTENT_ID = 1958;
    public static final String NOTIFICATION_CHANNEL_ID = "Hydration_Channel";
    public static final int NOTIFICATION_ID = 2525;

    // TODO completed (7) Create a method called remindUserBecauseCharging which takes a Context.
    // This method will create a notification for charging. It might be helpful
    // to take a look at this guide to see an example of what the code in this method will look like:
    // https://developer.android.com/training/notify-user/build-notification.html
    public static void remindUserBecauseCharging(Context context) {

        // TODO completed (8) Get the NotificationManager using context.getSystemService
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
        NotificationManager notificationManager = // class solution
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        // TODO completed (9) Create a notification channel for Android O devices
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {  // class solution
            NotificationChannel channel = new NotificationChannel(
                    NOTIFICATION_CHANNEL_ID,
                    context.getString(R.string.hydration_notification),
                    NotificationManager.IMPORTANCE_HIGH);

            notificationManager.createNotificationChannel(channel);
        }

        // TODO completed (10) In the remindUser method use NotificationCompat.Builder to create a notification
        // that:
        // - has a color of R.colorPrimary - use ContextCompat.getColor to get a compatible color
        // - has ic_drink_notification as the small icon
        // - uses icon returned by the largeIcon helper method as the large icon
        // - sets the title to the charging_reminder_notification_title String resource
        // - sets the text to the charging_reminder_notification_body String resource
        // - sets the style to NotificationCompat.BigTextStyle().bigText(text)
        // - sets the notification defaults to vibrate
        // - uses the content intent returned by the contentIntent helper method for the contentIntent
        // - automatically cancels the notification when the notification is clicked

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
                .setColor(ContextCompat.getColor(context, R.color.colorPrimary))
                .setSmallIcon(R.drawable.ic_drink_notification)
                .setLargeIcon(largeIcon(context))
                .setContentTitle(context.getText(R.string.charging_reminder_notification_title))
                .setContentText(context.getText(R.string.charging_reminder_notification_body))
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(context.getText(R.string.charging_reminder_notification_body)))
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setContentIntent(contentIntent(context))
                .setAutoCancel(true);
        // TODO completed (11) If the build version is greater than JELLY_BEAN and lower than OREO,
        // set the notification's priority to PRIORITY_HIGH.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN &&
                Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
//            mBuilder.setPriority(NotificationManager.IMPORTANCE_HIGH);
            mBuilder.setPriority(NotificationCompat.PRIORITY_HIGH);  // class solution
        }

        // TODO completed (12) Trigger the notification by calling notify on the NotificationManager.
        // Pass in a unique ID of your choosing for the notification and notificationBuilder.build()
//        NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, mBuilder.build());
        notificationManager.notify(NOTIFICATION_ID, mBuilder.build());  // class solution
    }

    // TODO completed (1) Create a helper method called contentIntent with a single parameter for a Context. It
    // should return a PendingIntent. This method will create the pending intent which will trigger when
    // the notification is pressed. This pending intent should open up the MainActivity.
//    private PendingIntent contentIntent(Context context) {
    private static PendingIntent contentIntent(Context context) {  // class solution

        // TODO completed (2) Create an intent that opens up the MainActivity
        Intent intent = new Intent(context, MainActivity.class);
        // TODO completed (3) Create a PendingIntent using getActivity that:
        // - Take the context passed in as a parameter
        // - Takes an unique integer ID for the pending intent (you can create a constant for
        //   this integer above
        // - Takes the intent to open the MainActivity you just created; this is what is triggered
        //   when the notification is triggered
        // - Has the flag FLAG_UPDATE_CURRENT, so that if the intent is created again, keep the
        // intent but update the data
        PendingIntent pendingIntent = PendingIntent.getActivity(
                context,
                CONTENT_INTENT_ID,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        return pendingIntent;
    }

    // TODO completed (4) Create a helper method called largeIcon which takes in a Context as a parameter and
    // returns a Bitmap. This method is necessary to decode a bitmap needed for the notification.
//    private Bitmap largeIcon(Context context) {
    private static Bitmap largeIcon(Context context) {

        // TODO completed (5) Get a Resources object from the context.
        Resources resources = context.getResources();
        // TODO completed (6) Create and return a bitmap using BitmapFactory.decodeResource, passing in the
        // resources object and R.drawable.ic_local_drink_black_24px
        return BitmapFactory.decodeResource(resources, R.drawable.ic_local_drink_black_24px);
    }
}
