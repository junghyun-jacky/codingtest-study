class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = n - 1;
        int min = 1000000;
        
        for(int i=2; i<=num; i++) {  
            if (num%i == 0) {
                if(min >= i) {
                    min = i;
                }
            }
        }
        answer = min;
        return answer;
    }
}