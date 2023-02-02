package dev.skosarev.springcourse;

import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music {
    @Override
    public String getSong() {
        return "Canon and Gigue in D Major";
    }
}
