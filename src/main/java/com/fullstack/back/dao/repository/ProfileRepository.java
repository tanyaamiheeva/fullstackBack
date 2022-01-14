package com.fullstack.back.dao.repository;

import com.fullstack.back.dao.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
    public ProfileEntity findByLogin(String login);
    public Optional<ProfileEntity> findById(Long id);
}
