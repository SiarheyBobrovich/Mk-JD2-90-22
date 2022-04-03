package by.it_academy.jd2.voting.my_voting.dto.api;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public interface IVoteCounter<K, V> {

    Map<K, V> getSortedMap(Comparator<Map.Entry<K, V>> comparator);

    default Map<K, V> sort(Map<K, V> map, Comparator<Map.Entry<K, V>> comparator) {
        Map<K, V> resultMap = new LinkedHashMap<>();

        Stream<Map.Entry<K, V>> sorted = map.entrySet()
                .stream()
                .sorted(comparator);

        sorted.forEach(x -> resultMap.put(x.getKey(), x.getValue()));

        return resultMap;
    }
}
