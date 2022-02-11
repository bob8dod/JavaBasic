package algorithm.hashmap;

import java.util.HashMap;

public class P42476 {

    static String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> map = new HashMap<>();
        for (String name : participant) {
            if (map.containsKey(name)) {
                map.replace(name, map.get(name) + 1);
                continue;
            }
            map.put(name, 1);
        }

        for (String name : completion) {
            map.replace(name, map.get(name) - 1);
        }

        for (String name : map.keySet()) {
            if (map.get(name) >= 1) {
                return name;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
    }
}

