
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*boj 11399*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            int p = sc.nextInt();
            if(list.isEmpty()){
                list.add(p);
                continue;
            }

            int index = list.size();
            while(true){
                if(index==0){
                    list.add(index, p);
                    break;
                } else if(list.get(index-1)>p ) {
                    index--;
                }else{
                    list.add(index,p);
                    break;
                }
            }
        }

        /*구간합*/
        List<Integer> acmSum = new ArrayList<>();
        list.add(0, 0);
        acmSum.add(0);// 구간합 리스트

        for(int i=1; i<list.size(); i++){
            acmSum.add(list.get(i) + acmSum.get(i-1));
        }

        int sum = 0;
        for (Integer integer : acmSum) {
            sum += integer;
        }
        System.out.println(sum);
    }
}