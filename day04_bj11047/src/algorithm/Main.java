package algorithm;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by dasom on 2016-10-26.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] coins = new int[N];
        for(int i=0; i<N; i++){
            coins[i] = sc.nextInt();
        }

        int coinType = N-1;
        int coinNumber = 0;

        while(coinType > -1){
            if((K / coins[coinType]) == 0){
                coinType--;
            } else{
                int numberOf = (K/coins[coinType]);
                coinNumber += numberOf;
                K -= (coins[coinType]*numberOf);
            }
        }

        System.out.println(coinNumber);
    }
}
