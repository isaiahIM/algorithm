import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
* 1. 그냥 StringTokenizer로 하면 안됨!
*   -> 왜냐하면 < 구분과 괄호 안에 공배이 있을 수 있기 때문!
* */
public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String str;

        str = br.readLine();// 문자열 읽음

        for(int i=0; i<str.length(); i++){

            /*여는 태그일 경우*/
            if(str.charAt(i) == '<'){
                while(!stack.isEmpty()){// 지금까지 앞에서 쌓은 문자열을 뒤집음
                    sb.append(stack.pop() );
                }

                while(str.charAt(i) != '>'){// 닫는 괄호가 나올때까지 문자를 넣음
                    sb.append(str.charAt(i));
                    i++;
                }
                sb.append(str.charAt(i));// '>' 문자 넣기
                continue;
            }

            /*단어 구분*/
            if(str.charAt(i) == ' '){// 단어일 경우
                while(!stack.isEmpty()){// 문자열을 뒤집음
                    sb.append(stack.pop() );
                }
                sb.append(' ');// 공백 추가
            } else{
                stack.push(str.charAt(i));
            }

        }

        while(!stack.isEmpty()){
            sb.append(stack.pop() );
        }

        System.out.println(sb.toString());
    }
}