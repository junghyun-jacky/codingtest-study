class Solution
{
    public int solution(int n, int a, int b)
    {
        int round = 1;
        
        while (true) {
            // 참가자 번호를 다음 라운드에서 부여받는 방법
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            
            // 라운드에서 만나게 되면 반복문 종료
            if (a == b) {
                break;
            }
            
            round++;
        }
        
        return round;
    }
}