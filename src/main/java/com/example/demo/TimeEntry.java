package com.example.demo;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "time")
public class TimeEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ZonedDateTime dateTime;

    private String hostname;

    public TimeEntry() {
    }

    public TimeEntry(ZonedDateTime dateTime, String hostname) {
        this.dateTime = dateTime;
        this.hostname = hostname;
    }

    public Long getId() {
        return id;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public String getHostname() {
        return hostname;
    }
}
