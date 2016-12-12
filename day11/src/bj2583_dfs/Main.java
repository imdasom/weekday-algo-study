package bj2583_dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by dasom on 2016-12-12.
 */
public class Main {
    public static int[][] adj;
    public static int M, N, K;
    public static int firstX, firstY;
    public static final int RECTANGLE = 1;
    public static final int VISITED = -1;
    public static int[] blankSpaces = new int[1024];
    public static int blankSpaceIndex = 0;
    public static Queue<Pair> q = new LinkedList<>();

    public static void main(String[] args) throws FileNotFoundException {

        initValues();

        while (isThereFirstPoint()) {

            search(firstY, firstX);

            // 큐가 비었다는 것은 더 이상 인접한 빈 공간이 없다는 것.
            blankSpaceIndex++;
        }

        //Collections.sort(blankSpaces);

        for (int i = 0; i < blankSpaceIndex - 1; i++) {
            for (int j = 0; j < blankSpaceIndex - 1; j++) {
                if (blankSpaces[j] > blankSpaces[j+1]) {
                    int temp = blankSpaces[j];
                    blankSpaces[j] = blankSpaces[j+1];
                    blankSpaces[j+1] = temp;
                }
            }
        }

        System.out.println(blankSpaceIndex);
        System.out.print(blankSpaces[0]);
        for (int i = 1; i < blankSpaceIndex; i++) {
            System.out.print(" " + blankSpaces[i]);
        }
    }

    public static void initValues() throws FileNotFoundException {

        Scanner sc = new Scanner(new FileInputStream("day11\\data\\input_data.txt"));

        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();

        if (M > 100 || N > 100) return;
        adj = new int[M][N];

        // 직사각형이 그려진 영역은 1로 표시한다.
        for (int numOfK = 0; numOfK < K; numOfK++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    adj[y][x] = RECTANGLE;
                }
            }
        }
    }

    // 진입점을 찾는다 --> 빈공간을 찾는다 --> 직사각형이 그려지지 않은 영역을 찾는다.
    public static boolean isThereFirstPoint() {
        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (adj[y][x] == 0) {
                    firstY = y;
                    firstX = x;
                    return true;
                }
            }
        }
        return false;
    }

    public static void search(int y, int x) {
        if (y < 0 || y >= M || x < 0 || x >= N) {
            return;
        }

        if (adj[y][x] == VISITED || adj[y][x] == RECTANGLE) {
            return;
        }

        // 위 if문에 해당하지 않으면 빈 공간으로 판단한다.
        adj[y][x] = VISITED;
        blankSpaces[blankSpaceIndex]++;

        search(y, x - 1);
        search(y, x + 1);
        search(y - 1, x);
        search(y + 1, x);
    }
}

class Pair {
    int y;
    int x;

    public Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}