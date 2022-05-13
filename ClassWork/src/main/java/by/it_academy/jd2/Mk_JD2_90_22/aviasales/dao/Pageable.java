package by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao;

public class Pageable {
    private int size;
    private int page;

    public Pageable(int size, int page) {
        this.size = size;
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public int getPage() {
        return page;
    }

    public static Pageable of(int size, int page){
        return new Pageable(size, page);
    }
}
