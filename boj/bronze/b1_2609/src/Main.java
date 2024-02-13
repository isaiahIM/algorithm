import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int num1, num2;
        int i;
        int gcd=0, lcm=0;

        num1 = sc.nextInt();
        num2 = sc.nextInt();

        int small;
        small = Math.min(num1, num2);

        for(i=small; i>=1; i--){
            if(num1%i==0 && num2%i==0){
                gcd = i;
                break;
            }
        }

        int big, mul=1;
        big = Math.max(num1, num2);
        while(true){
            int mux = big*mul;
            if(mux%num1==0 && mux%num2==0){
                lcm = mux;
                break;
            }
            mul++;
        }

        System.out.println(gcd);
        System.out.println(lcm);
    }
}