package medium;

import java.util.Arrays;
import java.util.List;

public class RelationshipComputer<T> {

    public Relationship computeRelationship(List list1, List list2) {

        if(Arrays.deepEquals(list1.toArray(),list2.toArray())) return Relationship.EQUAL;

        if(list1.size() == 0 || checkIfListInSecondList(list1, list2)) return Relationship.SUBLIST;

        if(list2.size() == 0 || checkIfListInSecondList(list2, list1)) return Relationship.SUPERLIST;

        return Relationship.UNEQUAL;
    }

    private boolean checkIfListInSecondList(List<Object> list1, List<Object> list2) {

        for(int i = 0; i < list2.size()- list1.size() + 1; i++){
            if(Arrays.deepEquals(list2.subList(i, i + list1.size()).toArray(), list1.toArray())) return true;
        }

        return false;
    }

}
