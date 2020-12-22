package com.horia.reminderapi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private Date dueDate;

    private String receiverPhoneNumber;

    public Reminder() {

    }

    public Reminder(Long id, String name, String description, Date dueDate, String receiverPhoneNumber) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.receiverPhoneNumber = receiverPhoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public void setReceiverPhoneNumber(String receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber;
    }
}