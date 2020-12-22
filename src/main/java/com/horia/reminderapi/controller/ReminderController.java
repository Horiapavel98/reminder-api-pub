package com.horia.reminderapi.controller;

import com.horia.reminderapi.model.Reminder;
import com.horia.reminderapi.model.ApiResponse;
import com.horia.reminderapi.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    @PostMapping("/reminders")
    public ResponseEntity<ApiResponse> createReminder(@RequestBody Reminder reminder) {
        return ResponseEntity.ok().body(this.reminderService.createReminder(reminder));
    }

}
