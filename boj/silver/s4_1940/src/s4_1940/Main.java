package s4_1940;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int N, M;
        int []serials;
        int start, end;
        int result;
        int cnt=0;
        int i;

        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();

        serials = new int[N];

        /*고유번호 받아오기*/
        for(i=0; i<N; i++){
            serials[i]=sc.nextInt();
        }
        Arrays.sort(serials);// 고유번호 정렬



        /*투포인터로 찾기*/
        end=N-1;
        start=0;
        while(start<end){
            result = serials[start]+serials[end];

            if(result<M){
                start++;
            }
            else if(result>M){
                end--;
            }
            else{// result==M일 경우
                cnt++;
                start++;
                end--;
            }
        }

        System.out.println(cnt);
    }
}
