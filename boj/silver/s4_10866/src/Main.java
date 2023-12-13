import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deq = new LinkedList<>();
        StringTokenizer st;
        String command;
        int data;
        int N;

        /*명령어 횟수 입력*/
        N=Integer.parseInt(br.readLine() );

        int i;
        for(i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            command=st.nextToken();


            switch (command){
                case "push_front":
                    data = Integer.parseInt(st.nextToken());
                    deq.offerFirst(data);
                    break;

                case "push_back":
                    data = Integer.parseInt(st.nextToken());
                    deq.offerLast(data);
                    break;

                case "pop_front":
                    if(deq.isEmpty()){
                        data = -1;
                    } else{
                        data = deq.pollFirst();
                    }
                    System.out.println(data);
                    break;

                case "pop_back":
                    if(deq.isEmpty()){
                        data = -1;
                    } else{
                        data = deq.pollLast();
                    }
                    System.out.println(data);
                    break;

                case "size":
                    System.out.println(deq.size());
                    break;

                case "empty":
                    if(deq.isEmpty()){
                        System.out.println("1");
                    }else{
                        System.out.println("0");
                    }
                    break;

                case "front":
                    if(deq.isEmpty()){
                        data = -1;
                    }else{
                        data = deq.peekFirst();
                    }
                    System.out.println(data);
                    break;

                case "back":
                    if(deq.isEmpty()){
                        data = -1;
                    }else{
                        data = deq.peekLast();
                    }
                    System.out.println(data);
                    break;
            }
        }


    }
}
