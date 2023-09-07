import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<commands.length; i++) {
            int[] newArr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(newArr);
            list.add(newArr[commands[i][2]-1]);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<commands.length; i++) {
            answer[i] = list.get(i).intValue();
        }
        return answer;
    }
}