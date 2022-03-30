package by.it_academy.jd2.voting.dto.enums;


/**
 * Singers-enum
 */
public enum Singers {
    RIHANNA("Риана"),
    LARISA_DOLINA("Лариса Долина"),
    SKILLET("Skillet"),
    LINKIN_PARK("Linkin Park");

    private final String name;

    Singers(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
