package com.galvanize.FlightEndpoints;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.*;

@ConfigurationProperties("wordCount")
public class WordCounter {
    private Words words;
    private List<String> input;
    private boolean caseSensitive = false;

    public List<String> getInput() {
        return input;
    }

    public void setInput(String input) {
        if(this.caseSensitive){
            this.input = Arrays.asList(input.toLowerCase(Locale.ROOT).split(" "));
        }
        else {
            this.input=Arrays.asList(input.split(" "));
            this.input.removeAll(words.getSkip());
        }
    }

    public boolean isCaseSensitive() {
        return caseSensitive;
    }

    public void setCaseSensitive(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    public static class Words{
        private List<String> skip;



        public List<String> getSkip() {
            return skip;
        }

        public void setSkip(List<String> skip) {
            this.skip = skip;
        }
    }

    public Map<String, String> count(){
        Map<String, String> wordCount = new HashMap<>();
        if (input != null) {
            for (String str: input) {
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
