package com.horia.reminderapi.sms;

import com.horia.reminderapi.model.Reminder;

public class SleepingReminder implements Runnable {

    private Reminder reminder;

    private SmsMessageSender messageSender;

    public SleepingReminder(Reminder reminder) {
        this.reminder = reminder;
        messageSender = new SmsMessageSender();
    }

    private void release() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Title: ");
        stringBuilder.append(reminder.getName());
        stringBuilder.append(". Description: ");
        stringBuilder.append(reminder.getDescription());

        messageSender.sendMessage(reminder.getReceiverPhoneNumber(), stringBuilder.toString());
    }

    private long getReminderDueTime() {
        return reminder.getDueDate().getTime();
    }

    @Override
    public void run() {
        long dueTime = getReminderDueTime();
        try {
            Thread.sleep(dueTime - System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        release();
        System.out.println("Thread from " + this.getClass() + " exited successfully: reminder.name=" + reminder.getName());
    }
}
