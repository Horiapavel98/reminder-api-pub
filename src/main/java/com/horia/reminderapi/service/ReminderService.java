package com.horia.reminderapi.service;

import com.horia.reminderapi.model.Reminder;
import com.horia.reminderapi.model.ApiResponse;

public interface ReminderService {

    ApiResponse<?> createReminder(Reminder reminder);

}
