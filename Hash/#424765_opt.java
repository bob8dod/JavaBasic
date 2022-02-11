package algorithm.hashmap;

import java.util.HashMap;
import java.util.Map;

public class P42476_opt {

    static String solution(String[] participant, String[] completion) {

        String answer = null;

        HashMap<String, Integer> map = new HashMap<>();
        for (String name : participant) map.put(name, map.getOrDefault(name,0) + 1);
        // HashMap.getOrDefault(key, defaultvalue) : 가져오는 데 해당 key가 Map에 없을 경우 defaultvalue로 값 설정.
        // python에서의 defaultdict와 비슷한 method

        for (String name : completion) map.put(name, map.get(name) - 1);
        // replace 대신 put으로 진행. -> 같은 키값에 대해서는 나중에 들어오는 값으로 변경된다는 점을 이용

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 1) {
                answer = entry.getKey();
            }
        }
        // keySet으로 key를 가져오는 대신, entrySet으로 key, value Set을 보두 가져옴 -> 더 효율적
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
    }
}
