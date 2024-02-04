import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int n;
        int []line;
        int i;
        int order=1;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        line = new int[n];

        for(i=0; i<n; i++){
            line[i] = sc.nextInt();
        }

        for(i=0; i<n; i++){

            if(line[i]!=order){
                stack.push(line[i]);
            } else{
                order++;
            }

            while(!stack.isEmpty() && stack.peek()==order){
                order++;
                stack.pop();
            }

        }

        if(order==n+1){
            System.out.println("Nice");
        } else{
            System.out.println("Sad");
        }

    }
}