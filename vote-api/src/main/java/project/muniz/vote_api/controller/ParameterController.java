package project.muniz.vote_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.muniz.vote_api.model.ParameterModel;
import project.muniz.vote_api.repository.ParameterRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/parameters")
public class ParameterController {

    private final ParameterRepository repository;

    public ParameterController(ParameterRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/save")
    public ResponseEntity<ParameterModel> save(@RequestBody ParameterModel parameter) {
        ParameterModel entity = repository.save(parameter);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/check")
    public ResponseEntity<ParameterModel> check(@RequestParam String key) {
        Optional<ParameterModel> entity = repository.findById(key);
        if (entity.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entity.get());
    }
}
