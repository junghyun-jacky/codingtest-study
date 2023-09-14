import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++) {
            heap.add(scoville[i]);
        }
        
        int count = 0;
        while(heap.size() > 1 && heap.peek() < K) {
            int minScoville = heap.poll() + (heap.poll() * 2);
            heap.add(minScoville);
            count++;
        }
        if(heap.size() == 1 && heap.peek() < K) {
            count = -1;
        }
        
        int answer = count;
        return answer;
    }
}