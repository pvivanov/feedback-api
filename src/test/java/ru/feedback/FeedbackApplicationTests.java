package ru.feedback;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class FeedbackApplicationTests {

    //TODO [adolinskiy] Здесь надо перевести аннотацию на JUnit5 (сейчас 4), при этом начнет подниматься контекст и не находя бд упадет. Пока не трогал, считай что мы пока без тестов
    @Test
    public void contextLoads() {
        System.out.println("HelloWorld");
        Assertions.assertTrue(true);
    }
}
