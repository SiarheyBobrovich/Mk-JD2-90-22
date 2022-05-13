package by.it_academy.jd2.Mk_JD2_90_22.aviasales.controllers.html.utils;

import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.Pageable;

public class PaginationUtils {
    public static long maxPageCount(long totalElements, Pageable pageable){
        return maxPageCount(totalElements, pageable.getSize());
    }

    public static long maxPageCount(long totalElements, int size){
        double result = (double) totalElements / size;
        return (long) Math.ceil(result);
    }
}
