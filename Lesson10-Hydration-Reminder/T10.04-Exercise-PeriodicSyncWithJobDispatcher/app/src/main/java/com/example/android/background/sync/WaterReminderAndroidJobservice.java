package com.example.android.background.sync;
//
//import android.app.job.JobParameters;
//import android.app.job.JobService;
//import android.os.AsyncTask;
//
//public class WaterReminderAndroidJobservice extends JobService {
//
//    private AsyncTask mBackgroundTask;
//
//    // TODO (4) Override onStartJob
//    @Override
//    public boolean onStartJob(final JobParameters params) {
//
//        // TODO completed (5) By default, jobs are executed on the main thread, so make an anonymous class extending
//        //  AsyncTask called mBackgroundTask.
//        // TODO completed (6) Override doInBackground
//        mBackgroundTask = new AsyncTask() {
//            // TODO completed (7) Use ReminderTasks to execute the new charging reminder task you made, use
//            // this service as the context (WaterReminderFirebaseJobService.this) and return null
//            // when finished.
//            @Override
//            protected Object doInBackground(Object[] objects) {
//                ReminderTasks.executeTask(WaterReminderAndroidJobservice.this,
//                        ReminderTasks.ACTION_CHARGING_REMINDER_NOTIFICATION);
//                return null;
//            }
//
//            // TODO completed (8) Override onPostExecute and called jobFinished. Pass the job parameters
//            // and false to jobFinished. This will inform the JobManager that your job is done
//            // and that you do not want to reschedule the job.
//
//            @Override
//            protected void onPostExecute(Object o) {
//                jobFinished(params, false);
//            }
//        };
//        // TODO completed (9) Execute the AsyncTask
//        mBackgroundTask.execute();
//        // TODO completed (10) Return true
//        return true;
//    }
//
//    // TODO completed (11) Override onStopJob
//    @Override
//    public boolean onStopJob(JobParameters params) {
//        // TODO completed (12) If mBackgroundTask is valid, cancel it
//        if (mBackgroundTask != null) mBackgroundTask.cancel(true);
//        // TODO completed (13) Return true to signify the job should be retried
//        return true;
//    }
//}

