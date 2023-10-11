import java.util.*;

class Solution {
    public String solution(String s) {
        
        String [] arr = s.split(" ");     
        int[] num = new int[arr.length];
        
        for(int i=0; i<arr.length; i++) {
            num[i] = Integer.parseInt(arr[i]);
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<num.length; i++) {
            int number = num[i];
            
            min = Math.min(min, number);
            max = Math.max(max, number);
        }
        
        String answer = min + " " + max;
        return answer;
    }
}