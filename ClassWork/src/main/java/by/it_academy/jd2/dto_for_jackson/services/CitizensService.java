package by.it_academy.jd2.dto_for_jackson.services;

import by.it_academy.jd2.dto_for_jackson.dto.Citizen;
import by.it_academy.jd2.dto_for_jackson.dto.Passport;
import by.it_academy.jd2.dto_for_jackson.services.api.IJsonService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CitizensService implements IJsonService<Citizen> {

    private static final CitizensService instance = new CitizensService();
    private final List<Citizen> citizenList;

    private CitizensService() {
        citizenList = new ArrayList<>();
        Passport pass = new Passport("1", "1", "dawd", LocalDate.now());
        Citizen citizen = new Citizen();
        citizen.setPassport(pass);
        citizen.setBirthday(LocalDate.of(1987, 6, 27));
        citizenList.add(citizen);
    }

    @Override
    public List<Citizen> getAll() {
        return citizenList;
    }

    @Override
    public void save(Citizen citizen) {
        citizenList.add(citizen);
    }

    public static CitizensService getInstance() {
        return instance;
    }
}
