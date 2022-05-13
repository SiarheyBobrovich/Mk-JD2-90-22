package by.it_academy.jd2.Mk_JD2_90_22.person.core;

public enum StorageType {
    COOKIES,
    SESSION
    ;


    public static StorageType valueOfIgnoreCase(String name){
        for (StorageType type : values()) {
            if(type.name().equalsIgnoreCase(name)){
                return type;
            }
        }
        throw new IllegalArgumentException("Не верный тип хранилища");
    }
}
