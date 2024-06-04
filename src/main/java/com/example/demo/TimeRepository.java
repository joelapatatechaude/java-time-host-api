package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TimeRepository extends JpaRepository<TimeEntry, Long> {
    List<TimeEntry> findTop100ByOrderByIdDesc();
}
