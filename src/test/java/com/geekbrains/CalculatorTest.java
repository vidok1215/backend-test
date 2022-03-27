package com.geekbrains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest extends BaseTest {

    public static Stream<Arguments> sumParams() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(5, 5, 10),
                Arguments.of(10, 2, 12)
        );
    }

    @Test
    @DisplayName("Test sum of two digits")
    void sum() {
        Calculator calculator = new Calculator();
        int expected = 3;
        int actually = calculator.sum(1, 2);
        assertEquals(expected, actually);
    }

    @ParameterizedTest(name = "Test {index}. {0} + {1} = {2}")
    @MethodSource("sumParams")
    void testSumParametrized(int x, int y, int expected) {
        Calculator calculator = new Calculator();
        int actually = calculator.sum(x, y);
        assertEquals(expected, actually);
    }

    @Test
    @DisplayName("Data from file")
    void testSumDataFromFile() throws IOException {
        String data = getResourceAsString("calculator_data.txt");
        Scanner in = new Scanner(data);
        Calculator calculator = new Calculator();
        while (in.hasNextLine()) {
            String[] line = in.nextLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int expected = Integer.parseInt(line[2]);
            assertEquals(expected, calculator.sum(x, y));
        }
    }
}