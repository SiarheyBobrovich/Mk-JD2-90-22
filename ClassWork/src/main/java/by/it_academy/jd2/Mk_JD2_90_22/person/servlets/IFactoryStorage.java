package by.it_academy.jd2.Mk_JD2_90_22.person.servlets;

import by.it_academy.jd2.Mk_JD2_90_22.person.core.StorageType;

public interface IFactoryStorage {
    IStorage getStorageByType(StorageType type);
}
