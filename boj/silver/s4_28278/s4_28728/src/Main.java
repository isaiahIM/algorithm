import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
*
* 핵심:
* 1. stack을 사용할 수 있는가?
* 2. 시간초과의 늪을 벗어날 수 있는가?
*   - 다량의 데이터를 매번 콘솔에 출력하는것 보다는 한번에 모아서 출력하는게 더 좋음
*     콘솔 출력은 I/O 작업이라 많은 시간이 필요함.
*     이때 사용되는게 StringBuilder/StringBuffer임
* */
public class Main {
    public static void main(String[] args) throws IOException {

        Stack<String> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N;
        int command;
        String data;
        int i;

        N=Integer.parseInt(br.readLine());


        for(i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            command=Integer.parseInt(st.nextToken());

            switch (command){
                case 1:
                    data=st.nextToken();
                    stack.push(data);
                    break;

                case 2:
                    if(stack.isEmpty()){
                        data = "-1";
                    } else{
                        data = stack.pop();
                    }
                    sb.append(data).append("\n");
                    break;

                case 3:
                    sb.append(stack.size()).append("\n");
                    break;

                case 4:
                    if(stack.isEmpty()){
                        data = "1";
                    } else{
                        data = "0";
                    }
                    sb.append(data).append("\n");
                    break;

                case 5:
                    if(stack.isEmpty()){
                        data = "-1";
                    } else{
                        data = stack.peek();
                    }
                    sb.append(data).append("\n");
            }


        }

        System.out.println(sb.toString());
    }
}