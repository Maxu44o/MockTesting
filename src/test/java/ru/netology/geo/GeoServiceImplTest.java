package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;


class GeoServiceImplTest {
    Location locHost =new Location(null, null, null, 0);
    Location locMsk = new Location("Moscow",Country.RUSSIA, "Lenina", 15);
    Location locNY = new Location("New York", Country.USA, " 10th Avenue", 32);
    Location locRu = new Location("Moscow", Country.RUSSIA, null, 0);
    Location locUS = new Location("New York", Country.USA, null,  0);


    @Test
     void TestHostIp () {
        Location actual = new GeoServiceImpl().byIp(GeoServiceImpl.LOCALHOST);
        Assertions.assertEquals(locHost.getCountry(),actual.getCountry());
        Assertions.assertEquals(locHost.getBuiling(),actual.getBuiling());
        Assertions.assertEquals(locHost.getCity(),actual.getCity());
        Assertions.assertEquals(locHost.getStreet(),actual.getStreet());
    }

    @Test
    void TestMskIp () {
        Location actual = new GeoServiceImpl().byIp(GeoServiceImpl.MOSCOW_IP);
        Assertions.assertEquals(locMsk.getCountry(),actual.getCountry());
        Assertions.assertEquals(locMsk.getBuiling(),actual.getBuiling());
        Assertions.assertEquals(locMsk.getCity(),actual.getCity());
        Assertions.assertEquals(locMsk.getStreet(),actual.getStreet());
    }

    @Test
    void TestNYIp () {
        Location actual = new GeoServiceImpl().byIp(GeoServiceImpl.NEW_YORK_IP);
        Assertions.assertEquals(locNY.getCountry(),actual.getCountry());
        Assertions.assertEquals(locNY.getBuiling(),actual.getBuiling());
        Assertions.assertEquals(locNY.getCity(),actual.getCity());
        Assertions.assertEquals(locNY.getStreet(),actual.getStreet());
    }


    @Test
    void TestRuIp () {
        Location actual = new GeoServiceImpl().byIp("172.");
        Assertions.assertEquals(locRu.getCountry(),actual.getCountry());
        Assertions.assertEquals(locRu.getBuiling(),actual.getBuiling());
        Assertions.assertEquals(locRu.getCity(),actual.getCity());
        Assertions.assertEquals(locRu.getStreet(),actual.getStreet());
    }


    @Test
    void TestUSIp () {
        Location actual = new GeoServiceImpl().byIp("96.");
        Assertions.assertEquals(locUS.getCountry(),actual.getCountry());
        Assertions.assertEquals(locUS.getBuiling(),actual.getBuiling());
        Assertions.assertEquals(locUS.getCity(),actual.getCity());
        Assertions.assertEquals(locUS.getStreet(),actual.getStreet());
    }
}

