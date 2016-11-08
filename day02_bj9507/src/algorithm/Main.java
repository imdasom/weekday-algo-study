package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by dasom on 2016-09-30.
 */
public class Main {
    public static long[] CACHE = new long[68];
    static{
        for(int i=0; i<CACHE.length; i++){
            CACHE[i] = -1L;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = null;

        sc = new Scanner(new FileInputStream("day02_bj9507.txt"));

        int T = sc.nextInt();

        for(int i=0; i<T; i++){
            int N = sc.nextInt();
            System.out.println(getKoongFibo(N));
        }

        sc.close();
    }

    public static long getKoongFibo(int N){
        if(N == 0){
            CACHE[0] = 1;
            return 1;

        } else if(N == 1){
            CACHE[1] = 1;
            return 1;

        } else if(N == 2){
            CACHE[2] = 2;
            return 2;

        } else if(N == 3){
            CACHE[3] = 4;
            return 4;

        }else{
            if(CACHE[N-4] == -1) CACHE[N-4] = getKoongFibo(N-4);
            if(CACHE[N-3] == -1) CACHE[N-3] = getKoongFibo(N-3);
            if(CACHE[N-2] == -1) CACHE[N-2] = getKoongFibo(N-2);
            if(CACHE[N-1] == -1) CACHE[N-1] = getKoongFibo(N-1);
            CACHE[N] = CACHE[N-1] + CACHE[N-2] + CACHE[N-3] + CACHE[N-4];
            return CACHE[N];
        }

    }
}
