package by.it_academy.jd2.Mk_JD2_90_22.vote.core;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class TopDto<T>{
    private final T name;
    private AtomicInteger count;

    public TopDto(T name) {
        this.name = name;
        this.count = new AtomicInteger(0);
    }

    public TopDto(T name, int count) {
        this.name = name;
        this.count = new AtomicInteger(count);
    }

    public T getName() {
        return name;
    }

    public void incCount(){
        this.count.incrementAndGet();
    }

    public void decCount(){
        this.count.decrementAndGet();
    }

    public int getCount() {
        return count.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopDto<?> topDto = (TopDto<?>) o;
        return Objects.equals(name, topDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
