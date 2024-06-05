package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
public class TimeController {

    private final TimeRepository timeRepository;

    public TimeController(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/time")
    public TimeEntry getTime() throws UnknownHostException {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Australia/Sydney"));
        String hostname = InetAddress.getLocalHost().getHostName();
        TimeEntry timeEntry = new TimeEntry(now, hostname);
        timeRepository.save(timeEntry);
        return timeEntry;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/history")
    public List<TimeEntry> getHistory() {
        return timeRepository.findTop100ByOrderByIdDesc();
    }
}