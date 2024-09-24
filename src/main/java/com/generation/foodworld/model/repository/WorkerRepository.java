package com.generation.foodworld.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.foodworld.model.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
    // Non è necessario aggiungere nulla, ma puoi definire query personalizzate qui se necessario
}
