package com.ozalp.organization.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ozalp.organization.models.entities.Gym;

@Repository
public interface GymRepository extends JpaRepository<Gym, Integer> {
}
