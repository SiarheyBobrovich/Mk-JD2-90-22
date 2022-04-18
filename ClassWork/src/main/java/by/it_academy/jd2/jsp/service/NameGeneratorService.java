package by.it_academy.jd2.jsp.service;

import java.util.Random;

public class NameGeneratorService {

    public static String getRandomName() {
        String[] name = {
                "Илья", "Антон", "Иван"
        };

        Random random = new Random();

        return name[random.nextInt(name.length)];
    }


}
