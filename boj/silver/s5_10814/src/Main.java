import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int n;
        int i;
        Scanner scanner = new Scanner(System.in);
        List<Member> members = new ArrayList<>();

        n = scanner.nextInt();

        for(i=0; i<n; i++){
            Member member = new Member();
            int age = scanner.nextInt();
            String name = scanner.nextLine();
            member.setAge(age);
            member.setName(name);
            members.add(member);
        }
        List<Member> sorted = members.stream()
                .sorted(Comparator.comparing(Member::getAge))
                .collect(Collectors.toList());

        for(Member m : sorted){
            System.out.println(m);
        }

    }

    static class Member{
        private String name;
        private int age;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return age  + name;
        }
    }
}
