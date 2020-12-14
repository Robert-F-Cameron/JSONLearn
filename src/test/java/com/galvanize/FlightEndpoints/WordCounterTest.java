package com.galvanize.FlightEndpoints;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class WordCounterTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void canCountWords(){
        WordCounter counter = new WordCounter();
        counter.setInput("THIS is a rAnDoM StRing");
        Map<String, String> result = counter.count();
        Map<String,String> expected = Map.of("a", "1","random", "1","string", "1","This", "1","is", "1");
        assertEquals(expected, result);

    }

    @Test
    public void testWordCounter() throws Exception {
        MockHttpServletRequestBuilder post = post("/words/count")
                .contentType(MediaType.APPLICATION_JSON)
                .content("this is robert");
        this.mvc.perform(post)
                .andExpect(content().string("{\"robert\":\"1\",\"this\":\"1\",\"is\":\"1\"}"));

    }

}
