import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int n;
        String commands;
        StringTokenizer st;
        int i;
        int data;

        n = Integer.parseInt(br.readLine());

        for(i=0; i<n; i++){
            commands = br.readLine();
            st = new StringTokenizer(commands);

            switch (st.nextToken()){
                case "push" :
                    data=Integer.parseInt(st.nextToken());
                    deque.offerLast(data);
                    break;

                case "pop" :
                    if(deque.isEmpty()){
                        data=-1;
                    } else{
                        data=deque.pollFirst();
                    }
                    sb.append(data).append("\n");
                    break;

                case "size" :
                    data = deque.size();
                    sb.append(data).append("\n");
                    break;

                case "empty" :
                    if(deque.isEmpty()){
                        data = 1;
                    } else {
                        data = -0;
                    }
                    sb.append(data).append("\n");
                    break;

                case "front" :
                    if(deque.isEmpty()){
                        data=-1;
                    } else{
                        data=deque.peekFirst();
                    }
                    sb.append(data).append("\n");
                    break;

                case "back" :
                    if(deque.isEmpty()){
                        data=-1;
                    } else{
                        data=deque.peekLast();
                    }
                    sb.append(data).append("\n");
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}