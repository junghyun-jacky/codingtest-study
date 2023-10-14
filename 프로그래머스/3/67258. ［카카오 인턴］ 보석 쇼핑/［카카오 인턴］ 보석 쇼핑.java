import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {1, gems.length};
        int start = 0;
        int end = 0;
        HashSet<String> gemTypes = new HashSet<>();
        HashMap<String, Integer> gemMap = new HashMap<>();

        // 모든 보석의 종류를 찾음
        for (String gem : gems) {
            gemTypes.add(gem);
        }

        int minLength = gems.length + 1;

        while (end < gems.length) {
            // 현재 보석을 보석 목록에 추가
            gemMap.put(gems[end], gemMap.getOrDefault(gems[end], 0) + 1);
            end++;

            // 모든 종류의 보석을 포함하는 구간을 찾음
            while (gemMap.size() == gemTypes.size()) {
                // 더 짧은 구간을 찾으면 갱신
                if (end - start < minLength) {
                    minLength = end - start;
                    answer[0] = start + 1;
                    answer[1] = end;
                }

                // 시작 지점을 옮겨가며 보석 목록을 업데이트
                gemMap.put(gems[start], gemMap.get(gems[start]) - 1);
                if (gemMap.get(gems[start]) == 0) {
                    gemMap.remove(gems[start]);
                }
                start++;
            }
        }

        return answer;
    }
}
