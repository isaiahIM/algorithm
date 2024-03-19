import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
* 핵심 설명:
* 1. 주어지는 랜선(k)의 길이가 integer 범위를 벗어날 수 있다는거 생각해야함
* 2. 이상적인 길이(최대 길이)는 주어진 랜선 길이를 전부 더한다음, 필요한 랜선 갯수로 나눈것임(sum/n)
* 3. 이진탐색트리로 구할때, 종료조건을 생각해야함!(정확한 값을 구하는게 아님)
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;
        long sum=0;
        long max = -1;
        long start, end, cut;
        int cnt;
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[] lans = new int[k];

        /*값 입력받기*/
        for(int i=0; i<k; i++){
            lans[i] = Integer.parseInt(br.readLine());
            sum += lans[i];
        }

        /*이진탐색으로 최적값 찾기*/
        start = 1;
        end = sum/n;
        while(start<=end){
            cnt=0;
            cut = (start+end)/2;

            for(int lan : lans){// 랜선 자르기
                cnt+=lan/cut;
            }

            if(cnt>=n){// 필요한 랜선 갯수 이상으로 자르면
                max = Math.max(max, cut);// 가장 긴 랜선 구하기
                start = cut+1;// 더 크게 자르기
            } else{
                end = cut-1;// 랜선 작게 자르기
            }
        }

        System.out.println(max);

    }
}