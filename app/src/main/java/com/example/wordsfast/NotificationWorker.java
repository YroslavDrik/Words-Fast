package com.example.wordsfast;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class NotificationWorker extends Worker {

    public NotificationWorker(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {
        Context context = getApplicationContext();
        NotificationHelper.sendNotification(context, "WordsFast Reminder", "You haven't learned words in a long time, it seems it's time.");
        return Result.success();
    }
}
