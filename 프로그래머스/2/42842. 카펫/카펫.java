import java.lang.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] answer = new int [2];
        
        int total = brown + yellow;
        int m = 0;
        int n = 0;
        for(int i=3; i<=total; i++) {
            if(total % i != 0) {
                continue;
            }
            m = total / i;
            n = i;
            if(m < n) {
                continue;
            }
            if((m-2) * (n-2) == yellow) {
                answer[0] = m;
                answer[1] = n;
                return answer;
            }
        }
        return answer;
    }
}