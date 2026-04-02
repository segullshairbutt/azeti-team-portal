package com.teamportal.repository;

import com.teamportal.model.Activity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByUserId(Long userId);

    Optional<Activity> findFirstByUserIdOrderByTimestampDesc(Long userId);

    @EntityGraph(attributePaths = "user")
    @Query("SELECT a FROM Activity a")
    List<Activity> findAllWithUser();
}
