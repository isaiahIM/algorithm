package b2_8958;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String quiz;
        int totalScore=0;
        int inc=1;
        int cnt;
        int i;
        Scanner sc = new Scanner(System.in);

        cnt=Integer.parseInt(sc.nextLine());

        for(i=0; i<cnt; i++){
            quiz=sc.nextLine();

            /*퀴즈 맞춰버렷~♥*/
            for(int j=0; j<quiz.length(); j++){
                if(quiz.charAt(j)=='O'){
                    totalScore+=inc;
                    inc++;
                }
                else{
                    inc=1;
                }
            }
            System.out.println(totalScore);
            totalScore=0;
            inc=1;
        }

    }
}
