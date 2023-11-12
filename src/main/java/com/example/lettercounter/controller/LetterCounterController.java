package com.example.lettercounter.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class LetterCounterController {

    /**
     * Counts amount of letter occurrences in some input word.
     *
     * @param inputString word
     * @return map (or JSON) with counted letters in descending order
     */
    @GetMapping(value = "/count-letters/{inputString}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<Character, Integer>> countLetters(@PathVariable String inputString) {
        Map<Character, Integer> result = new HashMap<>();

        for (Character letter : inputString.toCharArray()) {
            result.put(letter, result.getOrDefault(letter, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(result.entrySet());
        entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        Map<Character, Integer> descending = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : entryList) {
            descending.put(entry.getKey(), entry.getValue());
        }

        return new ResponseEntity<>(descending, HttpStatus.OK);
    }
}
