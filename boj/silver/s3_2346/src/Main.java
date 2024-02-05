import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Balloon{
    private int key;
    private int value;

    public Balloon(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public String toString(){
        return "("+getKey()+", "+getValue() +") ";
    }

}

public class Main {
    public static void main(String[] args) {
        Deque<Balloon> balloons = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        Balloon balloon;
        int n;
        int num;
        int i;
        int target=0;
        Scanner sc = new Scanner(System.in);

        n=sc.nextInt();

        /*풍선 생성*/
        for(i=1; i<=n; i++){
            num = sc.nextInt();
            balloons.offerLast(new Balloon(i, num));
        }

        for(i=0; i<n; i++){
            findBalloon(balloons, target);
            balloon = removeBalloon(balloons);
            //System.out.println("remove: "+balloon);
            target = balloon.getValue();
            sb.append(balloon.getKey()).append(" ");
        }

        System.out.println(sb);

    }

    /*
     * 1. 왜 양수일때는 target -1 이면서 음수일때는 traget인가(도는 횟수 차이)
     *      도는 구조와 삭제시 위치하는 인덱스 확인!*/
    public static void findBalloon(Deque<Balloon> balloons, int target){
        int i;
        Balloon b;
        if(target>0){
            for(i=0; i<target-1; i++){
                b = balloons.pollFirst();
                balloons.offerLast(b);
            }
        } else{
            for(i=0; i>target; i--){
                b = balloons.pollLast();
                balloons.offerFirst(b);
            }
        }

    }
    public static Balloon removeBalloon(Deque<Balloon> balloons){
        //System.out.println(balloons);
        return balloons.pollFirst();
    }
}