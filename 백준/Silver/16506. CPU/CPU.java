import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static HashMap<String, String> map = new HashMap<>();
    static int N;
    static String[] answers;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        answers = new String[N];
        mapPut();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String opcode = st.nextToken();
            int rD = Integer.parseInt(st.nextToken());
            int rA = Integer.parseInt(st.nextToken());
            int rBC = Integer.parseInt(st.nextToken());

            sb.setLength(0);

            // opcode
            findOpcode(opcode);

            sb.append("0");
            
            // rD
            StringBuilder rDsb = new StringBuilder();
            rDsb.append(intoBinary(rD));
            while(rDsb.length() != 3) {
                rDsb.insert(0, "0");
            }
            sb.append(rDsb);

            // rA
            StringBuilder rAsb = new StringBuilder();
            rAsb.append(intoBinary(rA));
            while(rAsb.length() != 3) {
                rAsb.insert(0, "0");
            }
            sb.append(rAsb);

            // rB or c#
            if (sb.charAt(4) == '0') {
                StringBuilder rBsb = new StringBuilder();
                rBsb.append(intoBinary(rBC));
                while(rBsb.length() != 3) {
                    rBsb.insert(0, "0");
                }
                sb.append(rBsb);
                sb.append("0");
            } else if (sb.charAt(4) == '1') {
                StringBuilder Csb = new StringBuilder();
                Csb.append(intoBinary(rBC));
                while(Csb.length() != 4) {
                    Csb.insert(0, "0");
                }
                sb.append(Csb);
            }
            answers[i] = String.valueOf(sb);
        }
        for (int i = 0; i < N; i++) {
            System.out.println(answers[i]);
        }

    }

    private static String intoBinary(int rN) {
        if (rN == 0) {
            return "000";
        }
        return Integer.toBinaryString(rN);
    }

    private static void findOpcode(String opcode) {
        for(String key : map.keySet()) {
            if(opcode.equals(key)) {
                sb.append(map.get(key));
                break;
            }
        }
    }

    private static void mapPut() {
        map.put("ADD", "00000");
        map.put("ADDC", "00001");
        map.put("SUB", "00010");
        map.put("SUBC", "00011");
        map.put("MOV", "00100");
        map.put("MOVC", "00101");
        map.put("AND", "00110");
        map.put("ANDC", "00111");
        map.put("OR", "01000");
        map.put("ORC", "01001");
        map.put("NOT", "01010");
        map.put("MULT", "01100");
        map.put("MULTC", "01101");
        map.put("LSFTL", "01110");
        map.put("LSFTLC", "01111");
        map.put("LSFTR", "10000");
        map.put("LSFTRC", "10001");
        map.put("ASFTR", "10010");
        map.put("ASFTRC", "10011");
        map.put("RL", "10100");
        map.put("RLC", "10101");
        map.put("RR", "10110");
        map.put("RRC", "10111");
    }
}