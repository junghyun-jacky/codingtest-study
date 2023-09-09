using System;
using System.Linq;

public class Solution {
    public string solution(string my_string) {
        string answer = new string(my_string.Reverse().ToArray());
        return answer;
    }
}