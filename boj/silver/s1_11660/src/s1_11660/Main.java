package s1_11660;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String []args) throws IOException {
        int N, M;
        int i, j;
        int data;
        int result;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /*배열 생성*/
        st = new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken() );
        M=Integer.parseInt(st.nextToken()) ;

        int [][]arr= new int[N+1][N+1];// 누적합 배열

        /*x, y 좌표 생성*/
        int []x1 = new int[M];
        int []x2 = new int[M];
        int []y1 = new int[M];
        int []y2 = new int[M];

        /*배열 입력 및 누적합*/
        for(i=1; i<=N; i++){
            st = new StringTokenizer(bf.readLine());
            for(j=1; j<=N; j++){
                data= Integer.parseInt(st.nextToken());
                arr[i][j]=data+arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1];
            }
        }


        /*좌표  입력*/
        for(i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());

            x1[i]=Integer.parseInt(st.nextToken());
            y1[i]=Integer.parseInt(st.nextToken());
            x2[i]=Integer.parseInt(st.nextToken());
            y2[i]=Integer.parseInt(st.nextToken());
        }

        for(i=0; i<M; i++){
            result=arr[x2[i]][y2[i]];
            result-=arr[x1[i]-1][y2[i]];
            result-=arr[x2[i]][y1[i]-1];
            result+=arr[x1[i]-1][y1[i]-1];
            System.out.println(result);
        }

    }
}
