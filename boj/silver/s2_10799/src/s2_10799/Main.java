package s2_10799;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        int cnt=0;
        int i;
        boolean laserArm=false;

        char [] arr= sc.nextLine().toCharArray();

        for(i=0; i<arr.length; i++){
            if(arr[i] == '('){// ( 인 경우
                stack.push(arr[i]);
                laserArm=true;
            }
            else{// ) 인 경우
                char poped = stack.pop();

                if(laserArm){
                    laserArm=false;
                    cnt+=stack.size();
                }else{
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
