package com.galvanize.FlightEndpoints;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/lessons")
public class LessonController {
    private final LessonRepository repository;
    public LessonController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.repository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Lesson> find(@PathVariable Long id){
        return this.repository.findById(id);
    }

    @PatchMapping("/{id}")
    public Optional<Lesson> patch(
            @PathVariable Long id,
            @RequestBody Lesson lesson){
        Optional<Lesson> patchedLesson = this.repository.findById(id);
        patchedLesson.ifPresent(value -> {
            value.setTitle(lesson.getTitle());
            value.setDeliveredOn(lesson.getDeliveredOn());
            this.repository.save(value);
        });
        return patchedLesson;
    }

}
