package s4_2164;
/*
* 핵심설명:
* 1. 이 문제는 queue의 특징을 알아야 쉽게 풀 수 있는 문제임.
* 2. queue는 줄서기와 같은 자료구조로, 입력한 순서대로 데이터가 나오는 구조임.
*       예를들어 [1, 2, 3]의 데이터가 queue에 있다 가정하자.
*       여기에 4를 넣으면(offer, add) [1, 2, 3, 4]가 됨.
*       즉, 데이터를 넣는거는 뒤에 넣는것임.
*       그리고, 여기서 데이터를 빼면(poll) [2, 3, 4]가 됨.
*       즉, 앞의 데이터가 빠짐.
*       이를 알고 있어야 풀림.*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        Queue<Integer> que = new LinkedList<>();

        N=Integer.parseInt(br.readLine() );

        int i;
        for(i=1; i<=N; i++){
            que.offer(i);
        }

        while(que.size()>1){
            que.poll();// 카드 버리기

            que.offer(que.poll());// 또 카드 한장 뽑고 맨 뒤에 넣기
        }

        System.out.println(que.poll());// 마지막 카드
    }
}
