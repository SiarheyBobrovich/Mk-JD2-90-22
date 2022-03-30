package by.it_academy.jd2.voting.dto.enums;


/**
 * Music-enum
 */
public enum Genres {
    POP("Поп"),
    ROCK("Рок"),
    FUNK("Фанк"),
    METAL("Метал"),
    JAZZ("Джаз"),
    BLUEZ("Блюз"),
    COUNTRY("Кантри"),
    REGGY("Рэгги"),
    HIP_HOP("Хип-хоп"),
    ELECTRONIC("Электронная");

    private final String name;

    Genres(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
