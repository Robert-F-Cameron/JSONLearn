package com.galvanize.FlightEndpoints;

import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.Optional;

public interface LessonRepository extends CrudRepository<Lesson, Long> {
    Lesson findByTitle(String title);

}
