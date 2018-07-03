package com.example.android.background.sync;
//
//import android.app.Application;
//import android.os.AsyncTask;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//
//import com.evernote.android.job.JobCreator;
//import com.evernote.android.job.JobManager;
//import com.evernote.android.job.JobRequest;
//
//public class ReminderJobApp extends Application {
//    private static final int REMINDER_INTERVAL_SECONDS = 90;
//    private static final int SYNC_FLEXTIME_SECONDS = REMINDER_INTERVAL_SECONDS;
//    private static final String REMINDER_JOB_TAG = "hydration_reminder_tag";
//    private static boolean sInitialized = false;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        if (sInitialized) return;
//        JobManager.create(this).addJobCreator(new ReminderJobCreator());
//    }
//
//    private class ReminderJobCreator implements JobCreator {
//        @Nullable
//        @Override
//        public Job create(@NonNull String tag) {
//            return new ReminderJob();
//        }
//    }
//
//    public class ReminderJob extends Job {
//        private static final String TAG = "job_reminder_tag";
//
//        @NonNull
//        @Override
//        protected Result onRunJob(@NonNull Params params) {
//            // TODO: 7/3/18 run job here
//            scheduleReminderJob();
//            return Result.SUCCESS;
//        }
//
//        public void scheduleReminderJob() {
//            int jobID = new JobRequest.Builder(ReminderJob.TAG)
//                    .setRequiresCharging(true)
//                    .setUpdateCurrent(false)
//                    .setExecutionWindow(REMINDER_INTERVAL_SECONDS,
//                            REMINDER_INTERVAL_SECONDS + SYNC_FLEXTIME_SECONDS)
//                    .setRequirementsEnforced(true)
//                    .build()
//                    .schedule();
//            sInitialized = true;
//        }
//
//    }
//}
