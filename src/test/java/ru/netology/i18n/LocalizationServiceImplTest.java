package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @Test
    void localeRuTest() {
        String expected = "Добро пожаловать";
        Assertions.assertEquals(expected, new LocalizationServiceImpl().locale(Country.RUSSIA));
    }

    @Test
    void localeUSTest() {
        String expected = "Welcome";
        Assertions.assertEquals(expected, new LocalizationServiceImpl().locale(Country.USA));
    }

}