package s2_12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int p, s;
        int cnt=0;
        int i, j;
        int condition[] = new int[4];// a, t, g, c 최소조건
        int dnaCount[] = new int[4];// sliding window dna 갯수
        int correctCnt=0;
        int start, end;// sliding window 범위
        char prev;
        char[] password;
        StringTokenizer st;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*dna 문자열 길이, 부분문자열 길이 입력*/
        st = new StringTokenizer(br.readLine());
        s=Integer.parseInt(st.nextToken());
        p=Integer.parseInt(st.nextToken());

        password= br.readLine().toCharArray();// dna문자열 입력

        /*비밀번호 조건 입력*/
        st = new StringTokenizer(br.readLine());
        for(i=0; i<4; i++){
            condition[i]=Integer.parseInt(st.nextToken());
        }


        /*초기 sliding window*/
        start=0;
        end=p-1;
        for(i=0; i<=end; i++){
            if(password[i]=='A'){
                dnaCount[0]++;
            }else if(password[i]=='C'){
                dnaCount[1]++;
            }else if(password[i]=='G'){
                dnaCount[2]++;
            }else if(password[i]=='T'){
                dnaCount[3]++;
            }
        }
        /*초기 비밀번호 검증*/
        for(j=0; j<4; j++){
            if(dnaCount[j]>= condition[j]){
                correctCnt++;
            }
        }
        if(correctCnt==4){
            cnt++;
        }
        
        while(end<s-1){
            prev=password[start];// sliding window 이동 전 첫번째 문자(사라질 문자 저장)

            /*sliding window 이동*/
            end++;
            start++;

            /*새 문자가 비밀번호 조건에 맞는지 비교*/
            if(password[end]=='A'){
                dnaCount[0]++;
            }else if(password[end]=='C'){
                dnaCount[1]++;
            }else if(password[end]=='G'){
                dnaCount[2]++;
            }else if(password[end]=='T'){
                dnaCount[3]++;
            }

            /*빠져나간 문자가 비밀번호 조건에 맞았는지 확인*/
            if(prev=='A'){
                dnaCount[0]--;
            }else if(prev=='C'){
                dnaCount[1]--;
            }else if(prev=='G'){
                dnaCount[2]--;
            }else if(prev=='T'){
                dnaCount[3]--;
            }


            /*비밀번호로 사용할 수 있는지 확인*/
            correctCnt=0;
            for(j=0; j<4; j++){
                if(dnaCount[j]>= condition[j]){
                    correctCnt++;
                }
            }
            if(correctCnt==4){
                cnt++;
            }

        }

        System.out.println(cnt);
    }
}
