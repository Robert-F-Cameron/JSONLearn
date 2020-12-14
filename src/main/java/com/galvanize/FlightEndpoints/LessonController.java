package com.galvanize.FlightEndpoints;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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

    @GetMapping("/find/{title}")
    public Lesson findByTitle(@PathVariable String title){
        return this.repository.findByTitle(title);
    }
    @GetMapping("/between")

    public List<Lesson> findByDates(@Param("date1") String date1, @Param("date2") String date2) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date1p = formatter.parse(date1);
        Date date2p = formatter.parse(date2);
        return this.repository.findByDates(date1p, date2p);
    }


}
