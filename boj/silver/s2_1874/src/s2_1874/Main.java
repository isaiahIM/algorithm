package s2_1874;

/*
* 핵심 설명:
* 1. 먼저 stack의 개념을 잘 알아야함.
*   stack에 대해서는 알고 있다고 가정하고 설명함. 모르면 알아서 공부ㄱㄱ
*
* 2. 이 문제의 중요한 점은 stack에서 pop을 할때 수열이 만들어짐.
*   즉, pop을 하는 숫자와 수열이 같아야 함.
*   그래서 나는 num==stack.peek() 라는 코드로 먼저 찍먹해서 숫자가 맞으면 pop을 했음.
*
* 3. stack에 push할때는 숫자가 1부터 차례대로 증가한다는 점을 유의해야함.
*   즉, 1, 2, 3 push하고, pop 한번 했다고 3이 다시 들어가는게 아님.
*   1, 2, 3 ->pop -> push --> 1, 2, 4 이렇게 되는거.
*   이거는 숫자를 넣는 cnt를 감소하지 않는 방법으로 진행하면 됨.
*
* 4. 숫자가 차례대로 들어간다는 점을 기반으로, 만드는게 불가능한 수열을 찾을 수 있음.
*   예제를 보면 1 2 5 3 4가 수열이잖음.
*   그럼 동작은 이렇게 될거임.
*   1 push, 1 pop
*   2 push, 2 pop
*   3, 4, 5 push 5 pop
*   다음으로 pop하면 4인데 수열은 3이잖음?
*   그럼 어쩔 수 없이 4, 3 이렇게 수열이 만들어질텐데 그럼 1 2 5 4 3이 됨.
*   즉, 불가능함.
*   이걸 논리적으로 말하면 pop할 숫자가 수열보다 크면 못만듦.
*   이거를 push하면 더 큰 숫자가 들어갈꺼고, stack 특성상 작은 숫자가 아래에 깔리는데, 이 깔린 숫자를 못빼는게 stack임.
*   이 로직도 작성할 줄 알아야함.
*
* 5. stack에서 pop을 할때 stack이 비었는데 pop하면 예외 발생하니까 그거 고려해서 미리 stack이 비었는지 확인하는 작업 필요함.
* */
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        int n;
        int []arr;
        int num;
        int cnt=1;
        Scanner sc =new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        int i;
        boolean isPossible=true;

        /*수열 갯수 입력*/
        n= sc.nextInt();

        /*수열 입력*/
        arr = new int[n];
        for(i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }

        for(i=0; i<n; i++){
            num=arr[i];// 수열을 순차적으로 비교함

            while(num>=cnt){// stack에 있을 수 있는 최대 숫자(cnt)가 수열의 숫자보다 작으면 push
                stack.push(cnt);
                cnt++;
                sb.append("+\n");
            }

            if(!stack.isEmpty() && num==stack.peek()){// stack에 있는 숫자가 수열의 숫자와 같으면 pop
                stack.pop();
                sb.append("-\n");
            }
            else if(!stack.isEmpty() && num<stack.peek()){// stack에 있는 숫자가 수열의 숫자보다 크면 만들 수 없음.
                System.out.println("NO");
                isPossible=false;
                break;
            }
        }

        if(isPossible){
            System.out.println(sb.toString());
        }

    }
}
