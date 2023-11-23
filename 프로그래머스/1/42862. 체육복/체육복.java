import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        // answer 초기화 : 도난당하지 않은 학생들의 수
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여벌 체육복을 가져온 학생이 도난당한 경우
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]) {
                    answer++;        // 여벌이 있으니 수업 참여 가능
                    lost[i] = -1;    // 도난 대상 제외
                    reserve[j] = -1; // 대여 불가능
                    break;
                }
            }
        }
        
        // 도난당한 학생에게 체육복 빌려주는 경우
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}