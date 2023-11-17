class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String skillTree : skill_trees) {
            String tmpSkill = skillTree;
            
            for(int i=0; i<skillTree.length(); i++) {
                String word = skillTree.substring(i, i+1);
                // 필수 스킬이 아닌 경우 제거
                if(!skill.contains(word)) {
                    tmpSkill = tmpSkill.replace(word, "");
                }
            }
            if(skill.indexOf(tmpSkill) == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}