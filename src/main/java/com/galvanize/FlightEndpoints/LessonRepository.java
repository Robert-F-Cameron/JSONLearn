package com.galvanize.FlightEndpoints;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface LessonRepository extends CrudRepository<Lesson, Long> {
    Lesson findByTitle(String title);
    @Query(value = "SELECT l FROM Lesson l WHERE deliveredOn BETWEEN ?1 AND ?2")
    List<Lesson> findByDates(Date date1 , Date date2);
//    List<Lesson> findByDeliveredOnBetween(String date1, String date2);

}
