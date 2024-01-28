import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack();
        String str;

        while (true) {
            str = sc.nextLine();

            if (str.equals(".")){
                break;
            }

            char[]sentence = str.toCharArray();
            for(char word : sentence){
                switch (word) {
                    case ('('):
                    case ('['):
                        stack.push(word);
                        break;

                    case (')'):
                        if(!stack.isEmpty() && stack.peek().equals('(')){
                            stack.pop();
                        } else {
                            stack.push(')');
                        }
                        break;

                    case (']'):
                        if(!stack.isEmpty() && stack.peek().equals('[')){
                            stack.pop();
                        } else{
                            stack.push(']');
                        }
                        break;
                }
            }

            if (stack.empty()){
                System.out.println("yes");
            } else{
                System.out.println("no");
                stack.clear();
            }

        }
    }
}