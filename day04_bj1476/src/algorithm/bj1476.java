package algorithm;

import java.util.Scanner;

/**
 * Created by dasom on 2016-10-26.
 */
public class bj1476 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int e = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();

        if (e % 15 == 0)
            e = 0;
        if (s % 28 == 0)
            s = 0;
        if (m % 19 == 0)
            m = 0;

        int result = 0;

        while(true){
            if((result%15 == e) || (result%28 == s) || (result%19 == m))
                break;
            result++;
        }

        System.out.println(result);
    }
}
