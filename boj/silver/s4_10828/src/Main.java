import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
        int N;
        String command;
        int data;
        StringTokenizer st;

        N=Integer.parseInt(br.readLine());

        int i;
        for(i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            command=st.nextToken();

            switch (command){
                case "push":
                    data=Integer.parseInt(st.nextToken());
                    stack.push(data);
                    break;

                case "pop":
                    if(stack.isEmpty()){
                        data = -1;
                    } else{
                        data = stack.pop();
                    }
                    System.out.println(data);
                    break;

                case "size":
                    System.out.println(stack.size() );
                    break;

                case "empty":
                    if(stack.isEmpty()){
                        System.out.println("1");
                    } else{
                        System.out.println("0");
                    }
                    break;

                case "top":
                    if(stack.isEmpty()){
                        System.out.println(-1);
                    } else{
                        System.out.println(stack.peek());
                    }
            }


        }
    }
}