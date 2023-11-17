class Solution {
    
    int count;
    
    public int solution(int[] numbers, int target) {
        
        count = 0;
        dfs(numbers, 0, target, 0);
        
        return count;
    }
    
    public void dfs(int[] numbers, int depth, int target, int result) {
        // depth : 노드 깊이
        // target : 타켓 넘버
        // result : 비교할 결과값
        if(numbers.length == depth) {
            if(target == result) {
                count++;
            }
        } else {
            dfs(numbers, depth+1, target, result + numbers[depth]);
            dfs(numbers, depth+1, target, result - numbers[depth]);
        }
    }
}