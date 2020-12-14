package com.galvanize.FlightEndpoints;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class LessonControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    LessonRepository repository;


    @Test
    @Transactional
    public void testCreate() throws Exception{
        MockHttpServletRequestBuilder request = post("/lessons")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"SQL\"}");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", instanceOf(Number.class) ))
                .andExpect(jsonPath("$.title", is("SQL") ));
    }
    @Test
    @Transactional
    public void testGetById() throws Exception{
        MockHttpServletRequestBuilder request = post("/lessons")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"SQL\"}");
        this.mvc.perform(request);
        this.mvc.perform(
                get("/lessons/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)));

    }
    @Test
    @Transactional
    public void testGetByTitle() throws Exception {
        MockHttpServletRequestBuilder post = post("/lessons")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"SQL\"}");
        this.mvc.perform(post);
        this.mvc.perform(
                get("/lessons/find/SQL")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title", is("SQL")));
    }
    @Test
    @Transactional
    public void testGetByDates() throws Exception {
        MockHttpServletRequestBuilder post = post("/lessons")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":2,\"title\":\"Spring Docs\",\"deliveredOn\":\"2018-04-12\"}");
        this.mvc.perform(post);
        this.mvc.perform(
                get("/lessons/between?date1=2018-03-17&date2=2018-12-17")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("[{\"id\":2,\"title\":\"Spring Docs\",\"deliveredOn\":\"2018-04-12\"}]"));
    }
}
