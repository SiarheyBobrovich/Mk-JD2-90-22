package by.it_academy.jd2.Mk_JD2_90_22.aviasales.controllers.json.dto;

import java.util.List;

public class Page<T> {
    private long totalElements;
    private int page;
    private int size;
    private List<T> content;

    public Page(long totalElements, int page, int size, List<T> content) {
        this.totalElements = totalElements;
        this.page = page;
        this.size = size;
        this.content = content;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public List<T> getContent() {
        return content;
    }

    public static class Builder<T>{
        private long totalElements;
        private int page;
        private int size;
        private List<T> content;

        public Builder<T> setTotalElements(long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public Builder<T> setPage(int page) {
            this.page = page;
            return this;
        }

        public Builder<T> setSize(int size) {
            this.size = size;
            return this;
        }

        public Builder<T> setContent(List<T> content) {
            this.content = content;
            return this;
        }

        public static <T> Builder<T> create(Class<T> tClass){
            return new Builder<>();
        }

        public Page<T> build(){
            return new Page<>(totalElements, page, size, content);
        }
    }
}
