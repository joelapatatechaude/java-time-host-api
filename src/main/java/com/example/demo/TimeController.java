package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
public class TimeController {

    @Autowired
    private TimeRepository timeRepository;

    @GetMapping("/time")
    public TimeEntry getTime() throws UnknownHostException {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Australia/Sydney"));
        String hostname = InetAddress.getLocalHost().getHostName();
        TimeEntry timeEntry = new TimeEntry(now, hostname);
        timeRepository.save(timeEntry);
        return timeEntry;
    }

    @GetMapping("/history")
    public List<TimeEntry> getHistory() {
        return timeRepository.findTop100ByOrderByIdDesc();
    }
}
