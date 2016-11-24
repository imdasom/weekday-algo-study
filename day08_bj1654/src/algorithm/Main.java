package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by dasom on 2016-11-23.
 */
public class Main {
    public static int K;
    public static int N;
    public static int[] lans;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("day08_bj1654\\data\\input_data.txt"));
        K = sc.nextInt();
        N = sc.nextInt();

        int left = 0;
        int right = 0;
        lans = new int[K];

        for(int i=0; i<K; i++){
            // 가장 긴 길이의 랜선을 찾아서 right에 저장한다.
            lans[i] = sc.nextInt();
            if(lans[i] >= right){
                right = lans[i];
            }
        }

        long result = bs(1, right);
        System.out.println(result);
    }

    public static long bs(long s, long e){
        long m = 0;
        while(s<=e){
            m = (s+e)/2;
            long v = 0;

            for(int i=0; i<K; i++){
                v += lans[i] / m;
            }

            if(v >= N) s = m +1;
            else if(v<N) e = m-1;
        }

        return e;
    }
}
