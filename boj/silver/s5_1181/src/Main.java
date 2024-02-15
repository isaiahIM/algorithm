import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] str;
        int n;

        n = Integer.parseInt(br.readLine());
        str = new String[n];

        int i;
        for(i=0; i<n; i++){
            str[i] = br.readLine();
        }

        Arrays.stream(str)
                .distinct()
                .sorted(comp)
                .forEach(System.out::println);

    }

    static Comparator<String> comp = (o1, o2) -> {
        if(o1.length()==o2.length()){// 두 문자열의 길이가 같은 경우
            /*사전순서로 정렬*/
            return o1.compareTo(o2);
        }

        return o1.length()-o2.length();// 길이 순서로 정렬
    };
}