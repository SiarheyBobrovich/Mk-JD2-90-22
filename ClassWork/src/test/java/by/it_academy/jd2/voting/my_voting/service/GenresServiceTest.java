package by.it_academy.jd2.voting.my_voting.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenresServiceTest {

    private static final GenresService service = GenresService.getInstance();

    @Test
    void getInstance() {
        Assertions.assertEquals(GenresService.getInstance(), service);
    }

    @Test
    void add() {
        List<String> list = new ArrayList<>(service.getList());
        String s = "Тик-тоник";
        service.add(s);
        list.add(s);

        int size = service.getList().size();
        Assertions.assertEquals(s, service.getList().get(size - 1));
        Assertions.assertEquals(list.size(), size);
        Assertions.assertThrows(UnsupportedOperationException.class,() -> service.getList().add(s));
    }

    @Test
    void isExist() {
        int size = service.getList().size();
        Assertions.assertTrue(service.isExist(0));
        Assertions.assertTrue(service.isExist(size - 1));
        Assertions.assertFalse(service.isExist(-1));
        Assertions.assertFalse(service.isExist(size));
    }
}