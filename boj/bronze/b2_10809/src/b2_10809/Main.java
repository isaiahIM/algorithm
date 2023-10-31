package b2_10809;

import java.util.*;

public class Main {
    public static void main(String[] args){
        int i;
        String str;
        int []index = new int[26];
        Scanner sc = new Scanner(System.in);


        /*인덱스 초기화*/
        for (i=0; i<26; i++){
            index[i]=-1;
        }
        str = sc.nextLine();

        for(i=0; i<str.length(); i++){// ASCII 코드 이용
            if(index[str.charAt(i) - 'a']==-1){// 첫 경험♥ 인 경우
                index[str.charAt(i) - 'a']=i;
            }
        }

        for(int result : index){
            System.out.print(result + " ");
        }
    }
}