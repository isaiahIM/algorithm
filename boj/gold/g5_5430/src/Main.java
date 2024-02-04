import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
* edge case 고려!
*  데이터(N) = 0일때 고려!
* */
public class Main {
    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());


        for(int i=0; i<testCase; i++){
            String p = br.readLine();// 명령함수 입력
            int n = Integer.parseInt(br.readLine());// 데이터 갯수
            st = new StringTokenizer(br.readLine(), "[],");// 데이터

            /*덱에 값 입력*/
            while(st.hasMoreTokens()){
                deque.offerLast(Integer.parseInt(st.nextToken()) );
            }

            int dir = calculate(deque, p);
            printResult(deque, dir);
        }
    }

    public static int calculate(Deque<Integer> deque, String commands){
        int frontState=1;

        for(int j=0; j<commands.length(); j++){

            /*방향 결정*/
            if(commands.charAt(j) == 'R'){
                frontState++;
                frontState%=2;// 1, 0 스위칭
                continue;

            }

            /*삭제 연산*/
            if (commands.charAt(j) == 'D') {
                if (deque.isEmpty()) {// 비어있는데 제거하려고 할때
                    return -1;
                }
                if (frontState == 1) {
                    deque.pollFirst();
                } else {
                    deque.pollLast();
                }
            }
        }

        return frontState;
    }

    public static void printResult(Deque<Integer> deque, int dir){
        if(dir == -1){
            System.out.println("error");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        if(deque.isEmpty()){
            sb.append("]");
            System.out.println(sb.toString());
            return;
        }

        if(dir==1){
            while(deque.size()>1){
                sb.append(deque.pollFirst())
                        .append(",");
            }
            sb.append(deque.pollFirst());
        } else{
            while(deque.size()>1){
                sb.append(deque.pollLast())
                        .append(",");
            }
            sb.append(deque.pollLast());
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}