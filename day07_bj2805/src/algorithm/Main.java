package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by dasom on 2016-11-16.
 */
public class Main {
    public static int[] trees;
    public static int N;
    public static int M;
    public static int left, right;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileInputStream("day07_bj2805\\data\\input_data.txt"));
        N = sc.nextInt();
        if(N<1 || N>1000000) return;
        M = sc.nextInt();
        if(M<1 || M>2000000000) return;

        trees = new int[N];
        left = 0;
        right = 0;

        for(int i=0; i<N; i++){
            // 가장 긴 길이의 나무를 찾아서 right에 저장한다.
            trees[i] = sc.nextInt();
            if(trees[i] >= right){
                right = trees[i];
            }
        }

        System.out.println(getCutterLength());

    }

    public static int getCutterLength(){
        int max = left;
        while(left <= right) {

            int middle = (left + right) / 2;
            int totalLen = 0;

            for (long treeLen : trees) {
                totalLen += (treeLen >= middle ? (treeLen-middle) : 0);
            }

            if(totalLen > M){
                max = middle;
                left = middle + 1;
            }else if(totalLen < M){
                right = middle - 1;
            }else{
                return middle;
            }
        }
        return max;
    }
}
