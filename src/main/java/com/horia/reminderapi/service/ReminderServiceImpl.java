package com.horia.reminderapi.service;

import com.horia.reminderapi.model.Reminder;
import com.horia.reminderapi.model.ApiResponse;
import com.horia.reminderapi.sms.SleepingReminder;
import com.horia.reminderapi.time.FutureTimeManager;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ReminderServiceImpl implements ReminderService {

    @Override
    public ApiResponse<?> createReminder(Reminder reminder) {
        if (reminder.getDueDate() == null) {
            reminder.setDueDate(FutureTimeManager.getFutureIncrementedBySeconds(5));
        }

        SleepingReminder sleepingReminder = new SleepingReminder(reminder);

        new Thread(sleepingReminder).start();

        return new ApiResponse<>(reminder, true,
                "Reminder created successfully", HttpStatus.OK);
    }
}
