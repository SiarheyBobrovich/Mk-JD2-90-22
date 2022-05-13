package by.it_academy.jd2.Mk_JD2_90_22.aviasales.main;

import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.Airport;
import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.AirportDao;
import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.AirportPoolDao;
import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.IAirportDao;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        IAirportDao airportDao = new AirportPoolDao();

        long start = System.currentTimeMillis();
        List<Airport> airports = airportDao.getAll();
        long stop = System.currentTimeMillis();


        //Время получения всех списком
        System.out.println(stop - start);

        start = System.currentTimeMillis();
        for (Airport airport : airports) {
            airportDao.get(airport.getCode());
        }
        stop = System.currentTimeMillis();

        //время получения всех по одной
        System.out.println(stop - start);
    }
}
