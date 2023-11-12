package com.example.lettercounter;

import com.example.lettercounter.controller.LetterCounterController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@SpringBootTest
class LetterCounterApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testLetterCounter() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('a', 5);
        expected.put('c', 4);
        expected.put('b', 1);
        LetterCounterController controller = new LetterCounterController();
        assert Objects.equals(controller.countLetters("aaaaabcccc"), new ResponseEntity<>(expected, HttpStatus.OK));
    }

}
