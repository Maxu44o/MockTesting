package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MessageSenderImplTest {

    @Test
    void MessageSenderImplRussian() {

        String ip = "172.";
        Map<String, String> input = new HashMap<String, String>();
        input.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);

        String expected = "Добро пожаловать";

        GeoService geoService = Mockito.spy(GeoServiceImpl.class);
        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);
        MessageSenderImpl messageSender = Mockito.spy(new MessageSenderImpl(geoService, localizationService));

        String actual = messageSender.send(input);

        Assertions.assertEquals(expected, actual);

        Mockito.verify(localizationService, Mockito.times(2)).locale(Country.RUSSIA);
        Mockito.verify(geoService, Mockito.times(1)).byIp(ip);
        Mockito.verify(geoService, Mockito.never()).byCoordinates(Mockito.anyDouble(), Mockito.anyDouble());
        Mockito.verify(messageSender, Mockito.times(1)).send(input);

    }


    @Test
    void MessageSenderImplEnglish() {

        String ip = "96.";
        Map<String, String> input = new HashMap<String, String>();
        input.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);

        String expected = "Welcome";

        GeoService geoService = Mockito.spy(GeoServiceImpl.class);
        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);
        MessageSenderImpl messageSender = Mockito.spy(new MessageSenderImpl(geoService, localizationService));

        String actual = messageSender.send(input);

        Assertions.assertEquals(expected, actual);

        Mockito.verify(localizationService, Mockito.times(2)).locale(Country.USA);
        Mockito.verify(geoService, Mockito.times(1)).byIp(ip);
        Mockito.verify(geoService, Mockito.never()).byCoordinates(Mockito.anyDouble(), Mockito.anyDouble());
        Mockito.verify(messageSender, Mockito.times(1)).send(input);

    }


    @Test
    void MessageSenderImplOther() {

        String ip = ".";
        Map<String, String> input = new HashMap<String, String>();
        input.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);

        String expected = null;

        GeoService geoService = Mockito.spy(GeoServiceImpl.class);
        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);
        MessageSenderImpl messageSender = Mockito.spy(new MessageSenderImpl(geoService, localizationService));

        NullPointerException actual = Assertions.assertThrows(NullPointerException.class, () -> messageSender.send(input));

        Assertions.assertEquals(expected, actual.getMessage());

        Mockito.verify(localizationService, Mockito.never()).locale(Mockito.any());
        Mockito.verify(geoService, Mockito.times(1)).byIp(ip);
        Mockito.verify(geoService, Mockito.never()).byCoordinates(Mockito.anyDouble(), Mockito.anyDouble());
       Mockito.verify(messageSender, Mockito.times(1)).send(input);

    }

    @Test
    void MessageSenderImplLockalHost() {

        String ip = "127.0.0.1";
        Map<String, String> input = new HashMap<String, String>();
        input.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);

        String expected = null;

        GeoService geoService = Mockito.spy(GeoServiceImpl.class);
        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);
        MessageSenderImpl messageSender = Mockito.spy(new MessageSenderImpl(geoService, localizationService));

        NullPointerException actual = Assertions.assertThrows(NullPointerException.class, () -> messageSender.send(input));

        Assertions.assertEquals(expected, actual.getMessage());

        Mockito.verify(localizationService, Mockito.times(1)).locale(Mockito.any());
        Mockito.verify(geoService, Mockito.times(1)).byIp(ip);
        Mockito.verify(geoService, Mockito.never()).byCoordinates(Mockito.anyDouble(), Mockito.anyDouble());
        Mockito.verify(messageSender, Mockito.times(1)).send(input);

    }
}