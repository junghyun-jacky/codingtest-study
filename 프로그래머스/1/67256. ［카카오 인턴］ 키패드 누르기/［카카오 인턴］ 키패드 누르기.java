import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        int left = 10;
        int right = 12;
        
        for(int i=0; i<numbers.length; i++) {
            int n = numbers[i];
            
            if(n == 1 || n == 4 || n == 7) {
                answer.append("L");
                left = n;
            }
            if (n == 3 || n == 6 || n == 9) {
                answer.append("R");
                right = n;
            }
            if (n == 2 || n == 5 || n == 8 || n== 0) {
                if( n == 0 ) n = 11;
                
                int leftCount = (Math.abs(left-n)/3) + (Math.abs(left-n)%3);
                int rightCount = (Math.abs(right-n)/3) + (Math.abs(right-n)%3);
                
                if(leftCount == rightCount) {
                    if(hand.equals("left")) {
                        answer.append("L");
                        left = n;
                    } else {
                        answer.append("R");
                        right = n;
                    }
                } else if(leftCount > rightCount) {
                    answer.append("R");
                    right = n;
                } else if(leftCount < rightCount) {
                    answer.append("L");
                    left = n;
                }
            }
        }
        
        return answer.toString();
    }
}