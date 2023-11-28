package g4_1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, S;
        StringTokenizer st;
        int min = Integer.MAX_VALUE;
        long []arr;
        int start, end;
        long num;

        st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        S=Integer.parseInt(st.nextToken());

        arr = new long[N+1];

        st = new StringTokenizer(br.readLine());
        int i;
        for(i=1; i<=N; i++){
            arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());// 누적합
        }

        start=1;
        end=1;
        while(start<=end && end<=N){
            num=arr[end]-arr[start-1];

            if(num<S){
                end++;
            }else{
                if(end-start<min){
                    min = end-start;
                }
                start++;
            }
        }

        min = (min==Integer.MAX_VALUE) ? 0 : min+1;// 값을 구하지 못할 경우 0 출력(원래 min 값이 Integer.MAX_VALUE가 됨)
        System.out.println(min);
    }
}

