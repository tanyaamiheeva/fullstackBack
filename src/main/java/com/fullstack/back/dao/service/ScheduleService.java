package com.fullstack.back.dao.service;

import com.fullstack.back.dao.entity.ScheduleEntity;
import com.fullstack.back.dao.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    public String create(Long userId, String day, String first, String second, String third,
                         String fourth, String fifth, String sixth, String seventh) {
        ScheduleEntity scheduleElement = ScheduleEntity.builder()
                .userid(userId)
                .weekday(day)
                .first(first)
                .second(second)
                .third(third)
                .fourth(fourth)
                .fifth(fifth)
                .sixth(sixth)
                .seventh(seventh)
                .build();

        scheduleRepository.save(scheduleElement);
        return scheduleElement.getId().toString();
    }

    public String getCurrentDay(Long userId, String day) {
        ScheduleEntity neededScheduleElement = scheduleRepository.getByUseridAndWeekday(userId, day);
        return neededScheduleElement.getFirst() + "$" + neededScheduleElement.getSecond() + "$" +
                neededScheduleElement.getThird() + "$" + neededScheduleElement.getFourth() + "$" +
                neededScheduleElement.getFifth() + "$" + neededScheduleElement.getSixth() + "$" +
                neededScheduleElement.getSeventh();
    }

    public String changeByDay(Long userId, String day, String newFirst, String newSecond, String newThird,
                              String newFourth, String newFifth, String newSixth, String newSeventh) {
        try {
            ScheduleEntity neededScheduleElement = scheduleRepository.getByUseridAndWeekday(userId, day);
            scheduleRepository.delete(neededScheduleElement);
            neededScheduleElement.setFirst(newFirst);
            neededScheduleElement.setSecond(newSecond);
            neededScheduleElement.setThird(newThird);
            neededScheduleElement.setFourth(newFourth);
            neededScheduleElement.setFifth(newFifth);
            neededScheduleElement.setSixth(newSixth);
            neededScheduleElement.setSeventh(newSeventh);
            scheduleRepository.save(neededScheduleElement);
        } catch (Exception e) {
            return "ERROR";
        }

        return "OK";
    }
}
