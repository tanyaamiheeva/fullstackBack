package com.fullstack.back.dao.repository;

import com.fullstack.back.dao.entity.DeadlinesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeadlinesRepository extends JpaRepository<DeadlinesEntity, Long> {
    public List<DeadlinesEntity> getAllByUserid(Long userId);
}
