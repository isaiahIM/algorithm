import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
* 핵심:
* 문제를 이해해야됨.
* 1. 기존의 큐로 원형큐를 구현할 수 있는가?
*
* */
public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n, k;
        int i;

        /*n, k 입력받음*/
        n = scanner.nextInt();
        k = scanner.nextInt();

        /*queue에 값 집어넣음*/
        for(i=1; i<=n; i++){
            queue.offer(i);
        }
        sb.append("<");
        while(queue.size()>1){

            /*k번째 사람 찾음*/
            for(i=0; i<k-1; i++){
                int num = queue.poll();
                queue.offer(num);
            }
            sb.append(queue.poll())// 찾으면 조짐
                    .append(", ");
        }
        sb.append(queue.poll())
                .append(">");
        System.out.println(sb.toString());
    }
}