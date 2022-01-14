package com.fullstack.back.dao.controllers;

import com.fullstack.back.dao.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("com.fullstack.back.dao.controllers.ScheduleController")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @PostMapping("/schedule")
    @ResponseBody
    public String buildSchedule(@RequestParam("userid") Long userId,
                                @RequestParam("day") String day,
                                @RequestParam("first") String first,
                                @RequestParam("second") String second,
                                @RequestParam("third") String third,
                                @RequestParam("fourth") String fourth,
                                @RequestParam("fifth") String fifth,
                                @RequestParam("sixth") String sixth,
                                @RequestParam("seventh") String seventh) {
        return scheduleService.create(userId, day, first, second, third, fourth, fifth, sixth, seventh);
    }

    @GetMapping("/schedule")
    public String getCurrentDay(@RequestParam("userid") Long userId,
                                @RequestParam("day") String day) {
        return scheduleService.getCurrentDay(userId, day);
    }

    @PostMapping("/schedule/change")
    @ResponseBody
    public String changeScheduleByDay(@RequestParam("userid") Long userId,
                                      @RequestParam("day") String day,
                                      @RequestParam("first") String newFirst,
                                      @RequestParam("second") String newSecond,
                                      @RequestParam("third") String newThird,
                                      @RequestParam("fourth") String newFourth,
                                      @RequestParam("fifth") String newFifth,
                                      @RequestParam("sixth") String newSixth,
                                      @RequestParam("seventh") String newSeventh) {
        return scheduleService.changeByDay(userId, day, newFirst, newSecond, newThird,
                                           newFourth, newFifth, newSixth, newSeventh);
    }
}
