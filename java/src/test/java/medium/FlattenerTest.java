package medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

public class FlattenerTest {

    private Flattener flattener;

    @BeforeEach
    public void setUp() {
        flattener = new Flattener();
    }

    @Test
    public void testFlatListIsPreserved() {
        assertEquals(asList(0, '1', "two"), flattener.flatten(asList(0, '1', "two")));
    }

    @Test
    public void testASingleLevelOfNestingWithNoNulls() {
        assertEquals(
                asList(1, '2', 3, 4, 5, "six", "7", 8),
                flattener.flatten(asList(1, asList('2', 3, 4, 5, "six", "7"), 8)));
    }

    @Test
    public void testFiveLevelsOfNestingWithNoNulls() {
        assertEquals(
                asList(0, '2', 2, "three", '8', 100, "four", 50, "-2"),
                flattener.flatten(asList(0,
                        '2',
                        asList(asList(2, "three"),
                                '8',
                                100,
                                "four",
                                singletonList(singletonList(singletonList(50)))), "-2")));
    }

    @Test
    public void testSixLevelsOfNestingWithNoNulls() {
        assertEquals(
                asList("one", '2', 3, '4', 5, "six", 7, "8"),
                flattener.flatten(asList("one",
                        asList('2',
                                singletonList(singletonList(3)),
                                asList('4',
                                        singletonList(singletonList(5))), "six", 7), "8")));
    }

    @Test
    public void testSixLevelsOfNestingWithNulls() {
        assertEquals(
                asList("0", 2, "two", '3', "8", "one hundred", "negative two"),
                flattener.flatten(asList("0",
                        2,
                        asList(asList("two", '3'),
                                "8",
                                singletonList(singletonList("one hundred")),
                                null,
                                singletonList(singletonList(null))),
                        "negative two")));
    }

    @Test
    public void testNestedListsFullOfNullsOnly() {
        assertEquals(emptyList(),
                flattener.flatten(asList(null,
                        singletonList(singletonList(singletonList(null))),
                        null,
                        null,
                        asList(asList(null, null), null), null)));
    }

}
