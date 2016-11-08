package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = null;
        try {
            sc = new Scanner(new FileInputStream("input.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int N = sc.nextInt();	//주사위 던지는 횟수
        int M = sc.nextInt();	//주사위 합

        getNumberOfTotalTo(N, "", M);

        //주사위눈의 수만큼 반복한다.
        /*for(int A=1; A<=6; A++){
            int secondTotalNum = M - A;	//i가 1일때는 9, i가 2일때는 8...

            for(int B=1; B<=6; B++){
                int C = secondTotalNum - B;

                if((C > 6) || (C < 1)){
                    continue;
                }else{
                    System.out.println(A+" "+B+" "+C);
                }
            }
        }*/

        sc.close();
    }

    public static void getNumberOfTotalTo(int count, String pastNumberStr, int total) {
        if ((total > 6) || (total < 1)) {

        } else {
            System.out.println(pastNumberStr+" "+total);
        }

        // count가 0보다 작아지면 재귀를 끝낸다.
        if(count <= 0){
            return;
        }/*else{
            count--;
        }*/

        // 주사위눈의 수만큼 반복한다.
        for (int A = 1; A <= 6; A++) {
            int secondTotalNum = total - A; // i가 1일때는 9, i가 2일때는 8...
            getNumberOfTotalTo(count--, A+" ", secondTotalNum);
        }
    }

    public static void getNumber2(int N, String pastNumberStr, int total){
        if(N < 0){
            return;
        }else{
            N--;
        }

        for (int A = 1; A <= 6; A++) {
            int secondTotalNum = total - A;
            getNumber3(pastNumberStr + A +" ", secondTotalNum);
        }
    }

    public static void getNumber3(String pastNumberStr, int total){
        if ((total > 6) || (total < 1)) {

        } else {
            System.out.println(pastNumberStr+" "+total);
        }
    }
}