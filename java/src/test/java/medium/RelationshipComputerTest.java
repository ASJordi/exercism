package medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

public class RelationshipComputerTest {

    @Test
    public void testThatTwoEmptyListsAreConsideredEqual() {
        Relationship computedRelationship = new RelationshipComputer<>().computeRelationship(emptyList(), emptyList());

        assertEquals(Relationship.EQUAL, computedRelationship);
    }

    @Test
    public void testEmptyListIsSublistOfNonEmptyList() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(emptyList(), asList(1, 2, 3));

        assertEquals(Relationship.SUBLIST, relationship);
    }

    @Test
    public void testNonEmptyListIsSuperlistOfEmptyList() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(asList('1', '2', '3'), emptyList());

        assertEquals(Relationship.SUPERLIST, relationship);
    }

    @Test
    public void testListIsEqualToItself() {
        List<String> anyList = asList("1", "2", "3");

        Relationship relationship = new RelationshipComputer<String>().computeRelationship(anyList, anyList);

        assertEquals(Relationship.EQUAL, relationship);
    }

    @Test
    public void testDifferentListsOfTheSameLengthAreUnequal() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(asList(1, 2, 3), asList(2, 3, 4));

        assertEquals(Relationship.UNEQUAL, relationship);
    }

    @Test
    public void testSublistCheckDoesNotAbortAfterFalseStart() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(asList('1', '2', '5'), asList('0', '1', '2', '3', '1', '2', '5', '6'));

        assertEquals(Relationship.SUBLIST, relationship);
    }

    @Test
    public void testSublistCheckHandlesExtraneousRepeatsOfFirstEntry() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(asList("1", "1", "2"), asList("0", "1", "1", "1", "2", "1", "2"));

        assertEquals(Relationship.SUBLIST, relationship);
    }

    @Test
    public void testSublistAtStart() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(asList(0, 1, 2), asList(0, 1, 2, 3, 4, 5));

        assertEquals(Relationship.SUBLIST, relationship);
    }

    @Test
    public void testSublistInMiddle() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(asList('2', '3', '4'), asList('0', '1', '2', '3', '4', '5'));

        assertEquals(Relationship.SUBLIST, relationship);
    }

    @Test
    public void testSublistAtEnd() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(asList("3", "4", "5"), asList("0", "1", "2", "3", "4", "5"));

        assertEquals(Relationship.SUBLIST, relationship);
    }

    @Test
    public void testAtStartOfSuperlist() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(asList(0, 1, 2, 3, 4, 5), asList(0, 1, 2));

        assertEquals(Relationship.SUPERLIST, relationship);
    }

    @Test
    public void testInMiddleOfSuperlist() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(asList('0', '1', '2', '3', '4', '5'), asList('2', '3'));

        assertEquals(Relationship.SUPERLIST, relationship);
    }

    @Test
    public void testAtEndOfSuperlist() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(asList("0", "1", "2", "3", "4", "5"), asList("3", "4", "5"));

        assertEquals(Relationship.SUPERLIST, relationship);
    }

    @Test
    public void testFirstListMissingElementFromSecondList() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(asList(1, 3), asList(1, 2, 3));

        assertEquals(Relationship.UNEQUAL, relationship);
    }

    @Test
    public void testSecondListMissingElementFromFirstList() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(asList('1', '2', '3'), asList('1', '3'));

        assertEquals(Relationship.UNEQUAL, relationship);
    }

    @Test
    public void testThatListOrderingIsAccountedFor() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(asList("1", "2", "3"), asList("3", "2", "1"));

        assertEquals(Relationship.UNEQUAL, relationship);
    }

    @Test
    public void testThatListsWithSameDigitsButDifferentNumbersAreUnequal() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(asList(1, 0, 1), asList(10, 1));

        assertEquals(Relationship.UNEQUAL, relationship);
    }

}
