import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        int[] answer = new int[photo.length];
        
        HashMap<String, Integer> map = new LinkedHashMap<>();
        for(int i=0; i<name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        for(int i=0; i<photo.length; i++) {
            String[] people = photo[i];
            int score = 0;
            for(int j=0; j<people.length; j++) {
                String person = people[j];
                if(map.containsKey(person)) {
                    score += map.get(person);
                }
            }
            answer[i] = score;
        }
        
        return answer;
    }
}