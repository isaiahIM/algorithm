package p5_11003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
* 핵심 설명:
* 1. deque의 맨 앞 원소는 늘 현재 구간의 최소값이 되도록 오름차순 정렬을 유지해야 함.
*   예를 들어 sliding window가 [3,5,10] 상황에서 4 가 들어오려 한다면(현재 구간 최소값 3) 5과 10을 제거한 후에 4를 추가하여 [3,4]로 만들어야 한다.
*   왜냐하면 5과 10는 4보다 크고, 인덱스가 앞서기 때문에 4와 함께 같은 구간안에 있는한 절대 최소값이 될 수 없음.
*   즉, 4 보다도 먼저 빠져나가고, 최소값이 되지 않기 때문에 출력될 일도 없어서 굳이 기억할 필요가 없음.
*   따라서 5와 10은 제거한다.
*   이런식으로 오름차순 정렬을 해서 "출력될 슷자만 deque에 저장" 하는 방식.
*   5는 3이 구간을 빠져나가고나면 다음 최소값이 될 수 있는 후보가 될 수 있다.
*
* 2. deque에서 빠져나갈 타이밍을 알아야함.
*   예제에서 나온 입력처럼 1 5 2 3 6 2 3 7 3 5 2 6 이 입력됬다 가정하자.
*   sliding window가 3이니까 1(맨 처음이니까 1이 최소값), 1(5보다 1이 작음), 1(2보다 1이 작음)이 입력됨.
*   sliding window가 3으로 가득 차고, 윈도우가 움직이면서 1이 빠져나가고 다음 수인 2가 들어와서 2가 최소값이 되야함.
*   근데 그냥 값만 받으면 1이 빠져나갈 타이밍을 모르니 여전이 1이 최소값이 됨.
*   그래서 각 숫자가 몇번째로 입력됬는지 알아야됨.
*   그거를 필자는 클래스로 만들어서 값(val), 위치(idx)로 만든거.
*   현재 인덱스 - 슬라이딩 윈도우 크기+1 을 해서 이걸 기준으로 최소값이 빠져나갈 타이밍을 계산함.
*   그게 windowStartPos 라는 변수의 사용법임.
*   예제처럼 슬라이딩 윈도우 크기가 3이고, 7번째로 값을 입력받는다면(인덱스=6)
*   windowStartPos = 6-3+1 = 4
*   즉, 최소값의 인덱스가 4보다 작으면 최소값이고 나발이고 알빠노 시전하면서 슬라이딩 윈도우에서 빠져나가야함.
* */
public class Main {
    static class A{
        int idx;
        int val;

        A(int idx, int val){
            this.idx= idx;
            this.val=val;
        }
        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }

    public static void main(String []args) throws IOException {
        Deque<A> dq = new LinkedList<>();
        int N, L;
        int i;
        int data;
        int windowStartPos;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        /*N, L값 입력*/
        st = new StringTokenizer(bf.readLine());
        N= Integer.parseInt(st.nextToken());
        L= Integer.parseInt(st.nextToken());

        /*Ai 값 입력*/
        st = new StringTokenizer(bf.readLine());

        for(i=0; i<N; i++){

            windowStartPos=i-L+1;// sliding window 시작 위치
            data = Integer.parseInt(st.nextToken());
            
            /*sliding window 정렬*/
            while(!dq.isEmpty() && (dq.peekLast().getVal() > data) ){
                dq.removeLast();
            }

            dq.addLast(new A(i,data));// sliding window에 값 입력

            if(!dq.isEmpty() && dq.peekFirst().getIdx()<windowStartPos){// 최소값 빠져나갈 타이밍 계산
                dq.removeFirst();
            }

            if(!dq.isEmpty()){
                sb.append(dq.peekFirst().getVal());// 최소값 출력
                sb.append(" ");
            }

        }
        System.out.println(sb.toString());
    }
}
