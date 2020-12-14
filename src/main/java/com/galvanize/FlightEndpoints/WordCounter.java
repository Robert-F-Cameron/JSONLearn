package com.galvanize.FlightEndpoints;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    public Map<String, String> count(String input){
        Map<String, String> wordCount = new HashMap<>();
        if (input != null) {
            String[] separatedWords = input.split(" ");
            for (String str: separatedWords) {
                if (wordCount.containsKey(str)) {
                    int count = Integer.parseInt(wordCount.get(str));
                    wordCount.put(str, String.valueOf(count + 1));
                } else {
                    wordCount.put(str, "1");
                }
            }
        }
        return wordCount;
    }
}
