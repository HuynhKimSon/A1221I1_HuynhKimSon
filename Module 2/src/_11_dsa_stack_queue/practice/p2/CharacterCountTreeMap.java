package _11_dsa_stack_queue.practice.p2;

import java.util.TreeMap;

public class CharacterCountTreeMap {
    TreeMap<String, Integer> map = new TreeMap<String, Integer>();

    public CharacterCountTreeMap() {
    }

    public void push(String key, int value) {
        if (map.containsKey(key)) {
            map.replace(key, map.get(key) + 1);
        } else {
            map.put(key, value);
        }
    }

    public TreeMap<String, Integer> getMap() {
        return map;
    }
}
