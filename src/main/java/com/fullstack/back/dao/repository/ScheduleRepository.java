package com.fullstack.back.dao.repository;

import com.fullstack.back.dao.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {
    public ScheduleEntity getByUseridAndWeekday(Long id, String day);
}
