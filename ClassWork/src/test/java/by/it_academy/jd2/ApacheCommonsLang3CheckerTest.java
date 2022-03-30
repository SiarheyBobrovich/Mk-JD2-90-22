package by.it_academy.jd2;

import by.it_academy.jd2.dto.ApacheCommonsLang3Checker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ApacheCommonsLang3CheckerTest {

    @ParameterizedTest(name = "{index} - Проверяемый текст = {0}")
    @DisplayName("Проверка текста на присутствие маленьких символов")
    @MethodSource("nameProvider")
    void isAllLowerCase(String text, boolean result) {
        Assertions.assertEquals(result, ApacheCommonsLang3Checker.isAllLowerCase(text));
    }

    @Test
    void isAllLowerCase1() {
        ApacheCommonsLang3Checker checker = new ApacheCommonsLang3Checker();
    }

    public static Stream<Arguments> nameProvider() {
        return Stream.of(
                Arguments.arguments("Ivan", false),
                Arguments.arguments("Anton", false),
                Arguments.arguments("AllPeople", false),
                Arguments.arguments("irina", true)
        );
    }
}