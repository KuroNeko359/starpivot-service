package org.kuroneko.starpivot.repository;

import org.kuroneko.starpivot.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComponentRepository extends JpaRepository<Component, Long> {
    Optional<Component> findByName(String name);
}
