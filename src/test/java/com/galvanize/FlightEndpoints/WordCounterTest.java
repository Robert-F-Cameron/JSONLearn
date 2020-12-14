package com.galvanize.FlightEndpoints;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {
    @Test
    public void canCountWords(){
        WordCounter counter = new WordCounter();
        Map<String, String> result = counter.count("This is a random string");
        Map<String,String> expected = Map.of("a", "1","random", "1","string", "1","This", "1","is", "1");
        assertEquals(expected, result);

    }
}
