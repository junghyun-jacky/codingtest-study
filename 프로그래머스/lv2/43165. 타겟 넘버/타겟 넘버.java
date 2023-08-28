class Solution {
    
    static int ansCount;
    
    // 마지막 노드까지 탐색했을 때 타겟 넘버와 결과값이 같으면 정답 카운트 증가
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        ansCount = 0;
        dfs(numbers, 0, target, 0);
        answer = ansCount;
        
        return answer;
    }
    
    public void dfs(int[] numbers, int depth, int target, int sum) {
        /** numbers : 입력 배열
         * depth : 탐색한 깊이
         * target : 타겟 넘버
         * sum : 이전까지의 합
         */
        if(depth == numbers.length) {
            if(target == sum) {
                ansCount++;
            }
        } else {
            dfs(numbers, depth+1, target, sum + numbers[depth]);
            dfs(numbers, depth+1, target, sum - numbers[depth]);
        }
    }
    
}