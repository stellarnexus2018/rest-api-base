package ru.master.restapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class RestApiBaseApplicationTests {

	@Test
	void contextLoads() {
	}

	/**
	 * Проверка вывода тестовой метки времени
	 */
	@Test
	void testLocalDateTime() {
		System.out.println("Проверка: " + LocalDateTime.now());
	}

	/**
	 * Проверка вывода тестовой метки времени
	 */
	@Test
	void testLocalDateTimeNew() {
		System.out.println("Проверка: " + LocalDateTime.now());
		System.out.println("Ну и ещё одна проверка!");
	}
}