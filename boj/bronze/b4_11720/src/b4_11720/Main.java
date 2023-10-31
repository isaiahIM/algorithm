package b4_11720;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int N;
        int sum=0;

        Scanner sc = new Scanner(System.in);
        String str;

        N=Integer.parseInt(sc.nextLine());// N 입력
        str=sc.nextLine();// 숫자들 입력

        for(int i=0; i<N; i++){
            sum+=str.charAt(i)-'0';// 각 숫자들 합계 구하기
        }

        System.out.println(sum);
    }
}