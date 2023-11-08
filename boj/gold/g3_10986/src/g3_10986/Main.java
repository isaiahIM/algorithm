package g3_10986;

import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        int N, M;
        long []sum;
        long []comb;
        long count;
        int mod;
        int i, j;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(in.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        sum = new long[N+1];

        comb = new long[M];

        /*구간합 배열 만들기*/
        st = new StringTokenizer(in.readLine());
        for(i=1; i<=N; i++){
            sum[i]=Long.parseLong(st.nextToken())+sum[i-1];
        }

        /*구간합 배열 나머지 연산, 나머지 갯수 카운트*/
        for(i=1; i<=N; i++){
            mod= (int) (sum[i]%M);
            sum[i]=mod;
            comb[mod]++;
        }

        count= comb[0];// 누적합으로 나눴을때 나머지가 0인 경우

        /*조합시 나머지가 0이 되는 경우*/
        for(i=0; i<M; i++){
            count+=comb[i]*(comb[i]-1)/2;
        }

        System.out.println(count);
    }
}
