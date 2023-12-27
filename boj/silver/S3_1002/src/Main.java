import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  T;
        int x1, x2, y1, y2;
        int r1, r2;

        T= sc.nextInt();

        for(int i=0; i<T; i++){
            x1= sc.nextInt();
            y1= sc.nextInt();
            r1= sc.nextInt();

            x2= sc.nextInt();
            y2= sc.nextInt();
            r2= sc.nextInt();

            double distance = Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2);

            /*수학 변태들한테 좋은 문제...*/
            if(x1==x2 && y1==y2 && r1==r2){// 위치의 갯수가 무한대일때(원이 겹칠때)
                System.out.println("-1");
            }else if(distance==Math.pow(r1+r2, 2) ){// 외접일때
                System.out.println("1");
            }else if(distance==Math.pow(r1-r2, 2) ){// 내접일때
                System.out.println("1");
            }else if(distance <Math.pow(r1-r2, 2)){// 원 안에 있지만 안만날때..?
                System.out.println("0");
            }else if(distance > Math.pow(r1+r2, 2)){// 두 원이 서로 떨어져있음
                System.out.println("0");
            }else{
                System.out.println("2");
            }
        }

    }
}