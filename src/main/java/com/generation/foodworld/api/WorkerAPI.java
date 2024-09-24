package com.generation.foodworld.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.generation.foodworld.model.entities.Worker;
import com.generation.foodworld.model.repository.WorkerRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/workers")
public class WorkerAPI {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> getWorkerById(@PathVariable Long id) {
        Optional<Worker> worker = workerRepository.findById(id);
        return worker.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Worker createWorker(@RequestBody Worker worker) {
        return workerRepository.save(worker);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Worker> updateWorker(@PathVariable Long id, @RequestBody Worker workerDetails) {
        Optional<Worker> workerOptional = workerRepository.findById(id);
        if (workerOptional.isPresent()) {
            Worker worker = workerOptional.get();
            worker.setName(workerDetails.getName());
            worker.setSurname(workerDetails.getSurname());
            worker.setDateOfBirth(workerDetails.getDateOfBirth());
            worker.setGender(workerDetails.getGender());
            worker.setProfession(workerDetails.getProfession());
            worker.setSalary(workerDetails.getSalary());
            worker.setBio(workerDetails.getBio());

            return ResponseEntity.ok(workerRepository.save(worker));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorker(@PathVariable Long id) {
        workerRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

