import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};        
        int[] score = {0,0,0};
        
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == one[i%5]) {
                score[0]++;
            }
        }
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == two[i%8]) {
                score[1]++;
            }
        }
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == three[i%10]) {
                score[2]++;
            }
        }
        
        int max = Math.max(Math.max(score[0],score[1]),score[2]);
        
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=0; i<score.length; i++) {
            if(max == score[i]) {
                ans.add(i+1);
            }
        }
        
        int[] answer = new int[ans.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = ans.get(i);
        }
            
        Arrays.sort(answer);
        
        return answer;
    }
}