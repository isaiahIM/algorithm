package g4_17298;

/*
* 핵심설명:
* 1. stack을 이용해야 함.
* 2. stack에는 인덱스를 저장한다는 점이 중요함.
* 3. 인덱스를 저장하는 이유는 오큰수를 배열에 저장을 함.
*       예를들어 [3, 5, 2, 7]의 오큰수를 배열에 [5, 5, 7, -1] 이렇게 저장하고 출력함.
*       이렇게 해야 순서대로 잘 저장할 수 있음.
* 4. 동작 원리는 다음과 같음.
*       예제를 보고 [3, 5, 2, 7]이 입력된다 가정하자.
*       그럼 먼저 3의 인덱스인 0을 stack에 저장함.
*       그리고 stack에 있는 0인덱스에 해당하는 3과 5를 비교함.
*       5가 더 크니까 배열의 stack에서 pop을 하고, 0 인덱스에 5를 저장함.
*       다음으로 5의 인덱스인 1을 push하고 2와 비교함.
*       2가 더 작으니까 2의 인덱스인 2도 push함.
*       다음으로 2의 인덱스인 2와 7을 비교함.
*       7이 더 크니까 2의 인덱스인 2에 7을 넣고 pop함.
*       다음으로 또, stack에 있는 1번 인덱스인 5와 7을 비교함.
*       7이 더 크니까 pop하고 기존의 5의 자리였던 인덱스 1에 7을 넣음.
*       다음으로 7의 인덱스인 3을 push함.
*       더 비교할 수가 없으니 stack에 있는 인덱스 숫자들을 -1로 함.
*       이번 케이스의 경우 7이 있던 자리에  -1이 대입함.
*       이러한 연산을 거치면 [5, 7, 7, -1]이 됨.
*       여기서 굳이 인덱스를 저장하는 이유는 예제 입력에서 5, 2같이 연속으로 작은 수가 나올 경우
*       해당 위치를 기반으로 정확하게 오큰수를 저장하기 위함임.
*
*       A[9, 5, 4, 8]이 입력된 경우를 보자.
*       그럼 먼저 9의 인덱스인 0을 push.
*       그리고, 9와 5를 비교함.
*       1 push
*       5와 4 비교
*       2 push
*       그럼 stack은 0 1 2 가 들어있음.
*       이제 A[2]인 4와 8 비교.
*       오큰수니까 A[2]=8, 2 pop
*       다음으로, A[1]인 5와 8 비교.
*       오큰수니까 A[1]=8, 1 pop
*       다음으로, A[0]인 9와 8 비교.
*       3 push
*       더 비교할거 없으니 stack에 있는 인덱스값 A[0, 3]=-1로 대입.
*       이렇게 하면 [-1, 8, 8, -1]이 됨.
*
*       이 알고리즘의 핵심은  1. stack을 이용함, 2. 인덱스를 저장함 이 두가지임.
*        */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        int N;
        int []A;
        int i;
        int index;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        N=Integer.parseInt(bf.readLine());// N 입력
        A = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(i=0; i<N; i++){// 수열 A 입력
            A[i]= Integer.parseInt(st.nextToken());
        }

        for(i=0; i<N; i++){

            if(stack.empty()){// stack이 비었으면 push
                stack.push(i);
                continue;
            }

            while(!stack.isEmpty() && A[stack.peek()]<A[i]){
                int poped= stack.pop();
                A[poped]=A[i];
                //System.out.println("Pop: "+poped);
            }
            stack.push(i);
            //System.out.println("push: "+A[i]);
        }

        while(!stack.empty()){
            A[stack.pop()]=-1;
        }

        for(int num: A){
            sb.append(num).append(" ");

        }

        System.out.print(sb.toString());
    }
}
