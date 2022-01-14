package com.fullstack.back.dao.service;

import com.fullstack.back.dao.entity.DeadlinesEntity;
import com.fullstack.back.dao.repository.DeadlinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DeadlinesService {
    @Autowired
    DeadlinesRepository deadlinesRepository;

    public String create(Long userId, LocalDate date, String deadline) {
        DeadlinesEntity newDeadline = DeadlinesEntity.builder()
                .userid(userId)
                .date(date)
                .deadline(deadline)
                .build();

        deadlinesRepository.save(newDeadline);
        return newDeadline.getId().toString();
    }

    public String getDeadlines(Long userId) {
        List<DeadlinesEntity> deadlines = deadlinesRepository.getAllByUserid(userId);
        StringBuilder result = new StringBuilder();
        for (var deadline : deadlines) {
            result.append(deadline.getDeadline());
            result.append("$");
        }

        return result.toString();
    }

    public String updateDeadline(Long id, LocalDate newDate, String newDeadline) {
        try {
            DeadlinesEntity neededDeadline = deadlinesRepository.getById(id);
            deadlinesRepository.delete(neededDeadline);
            neededDeadline.setDate(newDate);
            neededDeadline.setDeadline(newDeadline);
            deadlinesRepository.save(neededDeadline);
        } catch (Exception e) {
            return "ERROR";
        }

        return "OK";
    }

    public String delete(Long id) {
        try {
            deadlinesRepository.deleteById(id);
        } catch (Exception e) {
            return "ERROR";
        }

        return "OK";
    }
}
