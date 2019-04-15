import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * @program: Leetcode_java
 * @description: 381. Insert Delete GetRandom O(1) - Duplicates allowed
 * @author: Xincheng Huang
 * @create: 2019-04-13 00:24
 **/

public class _381_Insert_Delete_GetRandom_O1_Duplicates_allowed {

}
class RandomizedCollection{
    ArrayList<Integer> list = new ArrayList<>();
    HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
    Random rd = new Random();

    /** Initialize your data structure here. */
    public RandomizedCollection() {

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = map.containsKey(val);
        if(!res) map.put(val, new HashSet<>());
        map.get(val).add(list.size());
        list.add(val);
        return !res;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index = map.get(val).iterator().next();
        map.get(val).remove(index);
        if(map.get(val).size() == 0) map.remove(val);
        int lastVal = list.remove(list.size());
        if(list.size()!=index){
            map.get(lastVal).remove(list.size());
            list.set(index, lastVal);
        }
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rd.nextInt(list.size()));
    }
}