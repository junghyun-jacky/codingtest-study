import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        HashMap<String, Integer> wantMap = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        int answer = 0;
        int consecutiveDays = 10;
        
        for(int i = 0; i < discount.length - consecutiveDays + 1; i++) {
            HashMap<String, Integer> disMap = new HashMap<>();
            
            for(int j = 0; j < consecutiveDays; j++) {
                disMap.put(discount[i+j], disMap.getOrDefault(discount[i+j], 0) + 1);
            }
            
            Boolean isCorrect = true;
            
            // 각 항목의 개수 비교
            for(String key : wantMap.keySet()){
                if(wantMap.get(key) != disMap.get(key)){
                    isCorrect = false;
                    break;
                }
            }
            
            if(isCorrect) {
                answer += 1;
            }
        }
        
        return answer;
    }
}