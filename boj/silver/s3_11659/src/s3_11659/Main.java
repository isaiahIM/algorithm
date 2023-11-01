package s3_11659;

import java.util.*;

public class Main {
    public static void main(String[] args){
        int N, M;
        int []sums;
        int start, end;
        int i;
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();

        sums = new int[N+1];
        /*전체 합*/
        for(i=1; i<=N; i++){
            sums[i]=sums[i-1]+sc.nextInt();
        }

        for(i=0; i<M; i++){
            start=sc.nextInt();
            end=sc.nextInt();
            System.out.println(sums[end]-sums[start-1]);
        }
    }
}
