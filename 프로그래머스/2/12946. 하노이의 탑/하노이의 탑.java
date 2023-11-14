import java.util.*;

class Solution {
    
    ArrayList<int[]> seq;
    public int[][] solution(int n) {
        
        seq = new ArrayList<>();
        
        hanoi(n, 1, 3, 2);
        
        int[][] answer = new int[seq.size()][2];
        for(int i=0; i<seq.size(); i++) {
            int[] arr = seq.get(i);
            answer[i][0] = arr[0];
            answer[i][1] = arr[1];
        }
        
        return answer;
    }
    
    private void hanoi(int N, int from, int to, int via) {
        int[] move = {from, to}; // 출력 형식
        
        if(N == 1) { // 탈출 조건
            seq.add(move);
        } else {
            hanoi(N-1, from, via, to);
            seq.add(move);
            hanoi(N-1, via, to, from);
        }
    }
}