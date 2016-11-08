package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by dasom on 2016-11-02.
 */
public class Main {
    public static int[][] friendsInfo;
    public static boolean[] matched;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileInputStream("day06_as_picnic\\data\\input_data.txt"));
        int testCase = sc.nextInt();

        for(int i=0; i<testCase; i++){
            int N = sc.nextInt();
            friendsInfo = new int[N][N];

            // 친구 쌍 입력받아 저장하기
            int K = sc.nextInt();
            for(int j=0; j<K; j++) {
                int p1 = sc.nextInt();
                int p2 = sc.nextInt();
                friendsInfo[p1][p2] = friendsInfo[p2][p1] = 1;
            }

            matched = new boolean[N];

            System.out.println(countPair());

        }

    }

    public static int countPair(){

        int startPoint = -1;
        for(int i=0; i<matched.length; i++){
            if(!matched[i]){
                startPoint = i;
                break;
            }
        }

        if(startPoint == -1) return 1;

        int count = 0;
        for(int i=startPoint+1; i<matched.length; i++){
            if(friendsInfo[startPoint][i] == 1 && !matched[i]){
                matched[startPoint] = matched[i] = true;
                count += countPair();
                matched[startPoint] = matched[i] = false;
            }
        }

        return count;
    }
}
