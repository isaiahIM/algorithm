package s4_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<String> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int i;
        int n;
        boolean flag = true;

        /*n 입력*/
        n=Integer.parseInt(br.readLine());

        for(i=0; i<n; i++){

            st = new StringTokenizer(br.readLine(), "()", true);// 괄호 문자 입력

            while(st.hasMoreTokens()){
                String str = st.nextToken();
                if(str.equals("(") ){
                    stack.push(str);
                }
                else{
                    if(stack.isEmpty()){
                        flag=false;
                        break;
                    }
                    stack.pop();
                }
            }
            if(!flag || !stack.isEmpty()){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
            stack.clear();// stack 초기화

            flag=true;

        }

    }
}
