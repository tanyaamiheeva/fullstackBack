package com.fullstack.back.dao.controllers;

import com.fullstack.back.dao.service.DeadlinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController("com.fullstack.back.dao.controllers.DeadlinesController")
public class DeadlinesController {
    @Autowired
    DeadlinesService deadlinesService;

    @PostMapping("/deadlines")
    @ResponseBody
    public String addDeadline(@RequestParam("userid") Long userId,
                              @RequestParam("date") LocalDate date,
                              @RequestParam("deadline") String deadline) {
        return deadlinesService.create(userId, date, deadline);
    }

    @GetMapping("/deadlines")
    public String getDeadlinesByUser(@RequestParam("userid") Long userId) {
        return deadlinesService.getDeadlines(userId);
    }

    @PostMapping("/deadlines/update")
    @ResponseBody
    public String update(@RequestParam("id") Long id,
                         @RequestParam("date") LocalDate newDate,
                         @RequestParam("deadline") String newDeadline) {
        return deadlinesService.updateDeadline(id, newDate, newDeadline);
    }

    @PostMapping("/deadlines/delete")
    @ResponseBody
    public String delete(@RequestParam("id") Long id) {
        return deadlinesService.delete(id);
    }
}
