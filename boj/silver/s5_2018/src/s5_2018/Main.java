package s5_2018;

import java.util.Scanner;

public class Main {
    public static void main(String []args){
        int N;
        int start=1, end=1;
        int cnt=1;
        int i;
        int result;
        int sum[];
        Scanner sc = new Scanner(System.in);

        N=sc.nextInt();
        sum = new int[N+1];

        /*누적합*/
        for(i=1; i<=N; i++){
            sum[i]= sum[i-1]+i;
        }

        while(start<N){
            result=sum[end] - sum[start-1];

            if(result<N){
                end++;
            }
            else if(result>N){
                start++;
            }
            else{
                cnt++;
                start++;
            }

        }

        System.out.println(cnt);
    }
}
