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
        M = sc.nextInt();

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
        int middle = -1;
        while(left <= right) {

            middle = (left + right) / 2;

            int totalLen = 0;
            for (int treeLen : trees) {
                if(treeLen >= middle)
                    totalLen += (treeLen - middle);
            }

            if(totalLen == M){
                return middle;
            }else if(totalLen > M){
                left = middle + 1;
            }else{
                right = middle - 1;
            }
        }
        return middle;
    }
}
