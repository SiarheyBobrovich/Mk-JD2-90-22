package org.it_academy.aviasales.info.dto;

public class Pageable {

    private final int size;
    private final int page;

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

}
