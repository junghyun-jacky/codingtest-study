import java.util.*;

class Solution {
    
    static boolean[] visit;
    static int answer;
    
    public int solution(String begin, String target, String[] words) {
        answer = 51;
        
        visit = new boolean[words.length];
        
        // words에 target이 없는 경우 0 반환
        List<String> list = new ArrayList<>(Arrays.asList(words));
        if(!list.contains(target)) {
            return 0;
        }
        
        dfs(begin, words, target, 0);
        
        return answer;
    }
    
    public void dfs(String begin, String[] words, String target, int count) {
        // 종료 조건
        if(begin.equals(target)) {
            if(answer > count) {
                answer = count;
            }
            return;
        }
        
        for(int i=0; i<words.length; i++) {
            if(!visit[i] && check(begin, words[i])) {
                visit[i] = true;
                dfs(words[i], words, target, count+1);
                visit[i] = false;
            }
        }
    }
    
    // words에 있는 단어 중 한 글자만 다른 단어 찾기
    public boolean check(String pre, String next) {
        int count = 0;
        for(int i=0; i<pre.length(); i++) {
            if(pre.charAt(i) != next.charAt(i)) {
                count++;
            }
        }
        if(count == 1) {
            return true;
        } else {
            return false;
        }
    }
}