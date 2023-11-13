package g4_1253;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int N;
        int cnt=0;
        int i, j, pos;
        int sum;

        Scanner sc = new Scanner(System.in);

        N=sc.nextInt();

        int []arr = new int[N];
        for(i=0; i<N; i++){
            arr[i]= sc.nextInt();
        }
        Arrays.sort(arr);


        for(pos=0; pos<N; pos++){
            i=0;
            j=N-1;// 주어지는 값이 음수일 수 있음!
            while(i<j){
                if(pos==i){// 다른 두 수이기 때문에 자기 자신을 제외함!!
                    i++;
                    continue;// i값을 더했을때 i==j가 될 수 있음
                }
                else if(pos==j){
                    j--;
                    continue;// j값을 뺐을때 i==j가 될 수 있음
                }

                sum=arr[i]+arr[j];

                if(sum<arr[pos]){
                    i++;
                }
                else if(sum>arr[pos]){
                    j--;
                }
                else {// sum == arr[pos]
                    cnt++;
                    break;
                }
            }
        }


        System.out.println(cnt);
    }
}
