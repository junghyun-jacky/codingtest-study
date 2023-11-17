import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 유저별 신고 당한 횟수 관리
        Map<String, Integer> reportManagement = new LinkedHashMap<>();
        for (String id : id_list) {
            reportManagement.put(id, 0);
        }

        // 중복 신고 관리용
        List<Set<String>> duplicateCheck = new ArrayList<>();

        // 각 유저별 신고 체크할 Set
        for (int i = 0; i < id_list.length; i++) {
            duplicateCheck.add(new HashSet<>());
        }

        for (int i = 0; i < report.length; i++) {
            String[] reportPeople = report[i].split(" ");
            String reporter = reportPeople[0];
            String reported = reportPeople[1];

            int reporterIdx = getIndex(id_list, reporter);
            int reportedIdx = getIndex(id_list, reported);

            if (!duplicateCheck.get(reportedIdx).contains(reporter)) {
                reportManagement.put(reported, reportManagement.get(reported) + 1);
                duplicateCheck.get(reportedIdx).add(reporter);
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            
            // 해당 유저를 신고한 모든 유저를 확인
            for (int j = 0; j < id_list.length; j++) {
                
                // j번째 유저가 i번째 유저를 신고했을 때, i번째 유저가 k번 이상 신고되었을 경우
                if (duplicateCheck.get(j).contains(id_list[i])) {
                    if (reportManagement.get(id_list[j]) >= k) {
                        answer[i]++;
                    }
                }
            }
        }

        return answer;
    }

    // 유저의 인덱스 찾기
    public static int getIndex(String[] id_list, String user) {
        for (int i = 0; i < id_list.length; i++) {
            if (user.equals(id_list[i])) {
                return i;
            }
        }
        return -1;
    }
}