package by.it_academy.jd2.voting.my_voting.core.dto.api;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public interface IVoteCounter<K, V> {

    /**
     * Method's going to take map from IVoteContainer and sort it by the comparator
     * @param comparator - to sort
     * @return - sorted Map
     */
    Map<K, V> getSortedMap(Comparator<Map.Entry<K, V>> comparator);

    /**
     * Default sort method by value
     * @param map - Map which need to sort
     * @param comparator - Comparator to sort
     * @return sorted LinkedHashMap
     */
    default Map<K, V> sort(Map<K, V> map, Comparator<Map.Entry<K, V>> comparator) {
        Map<K, V> resultMap = new LinkedHashMap<>();

        Stream<Map.Entry<K, V>> sorted = map.entrySet()
                .stream()
                .sorted(comparator);

        sorted.forEach(x -> resultMap.put(x.getKey(), x.getValue()));

        return resultMap;
    }
}
