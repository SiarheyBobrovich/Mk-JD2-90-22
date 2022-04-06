package by.it_academy.jd2.voting.my_voting.core.dto.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IVoteCounterTest {

    private final IVoteCounter<String, Integer> counter = new IVoteCounter<String, Integer>() {
        @Override
        public Map<String, Integer> getSortedMap(Comparator<Map.Entry<String, Integer>> comparator) {
            return null;
        }
    };

    private final static Map<String, Integer> TEST_MAP = new HashMap<>();
    private final static Map<String, Integer> STRAIGHT_RESULT_MAP = new LinkedHashMap<>();
    private final static Map<String, Integer> REVERSED_RESULT_MAP = new LinkedHashMap<>();


    private static final Comparator<Map.Entry<String, Integer>> straight = new Comparator<Map.Entry<String, Integer>>() {

        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o1.getValue() - o2.getValue();
        }

    };

    private static final Comparator<Map.Entry<String, Integer>> reverse = new Comparator<Map.Entry<String, Integer>>() {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o1.getValue() - o2.getValue();
        }
    }.reversed();



    static {
        TEST_MAP.put("four", 4);
        TEST_MAP.put("two", 2);
        TEST_MAP.put("one", 1);
        TEST_MAP.put("three", 3);
        TEST_MAP.put("five", 5);
    }

    static {
        Stream.of(
            Map.entry("one", 1),
            Map.entry("two", 2),
            Map.entry("three", 3),
            Map.entry("four", 4),
            Map.entry("five", 5)
        ).forEach((entry) ->
                STRAIGHT_RESULT_MAP.put(entry.getKey(), entry.getValue())
        );
    }

    static {
        Stream.of(Map.entry("five", 5),
                Map.entry("four", 4),
                Map.entry("three", 3),
                Map.entry("two", 2),
                Map.entry("one", 1)
        ).forEach((entry) ->
                REVERSED_RESULT_MAP.put(entry.getKey(), entry.getValue())
        );
    }

    @ParameterizedTest(name = "After: {0}, Before: {2}")
    @DisplayName("Comparator's sort")
    @MethodSource("getArguments")
    void sort(Map<String, Integer> map,
                      Comparator<Map.Entry<String, Integer>> comparator,
                      Map<String, Integer> result) {
        map = counter.sort(map, comparator);
        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(result.entrySet());

        Assertions.assertEquals(result.size(), map.size());

        int i = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Assertions.assertEquals(entries.get(i).getKey(), entry.getKey());
            Assertions.assertEquals(entries.get(i).getValue(), entry.getValue());
            i++;
        }
    };

    public static Stream<Arguments> getArguments() {
        return Stream.of(
                Arguments.arguments(TEST_MAP, straight, STRAIGHT_RESULT_MAP),
                Arguments.arguments(TEST_MAP, reverse, REVERSED_RESULT_MAP)
        );
    }
}
