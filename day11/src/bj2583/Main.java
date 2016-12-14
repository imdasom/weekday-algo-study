package bj2583;

import java.io.*;
import java.util.*;

/**
 * Created by dasom on 2016-12-12.
 */
public class Main {
    public static int[][] adj;
    public static int M, N, K;
    public static final int RECTANGLE = 1;
    public static final int VISITED = -1;
    public static ArrayList<Integer> blankSpaces = new ArrayList<>();
    public static int blankSpaceIndex = 0;
    public static Queue<Pair> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        initValues();

        while(isThereFirstPoint()){
            while (!q.isEmpty()) {
                // 큐에 방문해야 할 정점이 있으면 꺼낸다.
                // 그 정점을 기준으로 동서남북 방향에 빈공간이 있는지 검사한다.
                Pair pair = q.poll();

                search(pair.y, pair.x - 1);
                search(pair.y, pair.x + 1);
                search(pair.y - 1, pair.x);
                search(pair.y + 1, pair.x);
            }

            // 큐가 비었다는 것은 더 이상 인접한 빈 공간이 없다는 것.
            blankSpaceIndex++;
        }

        //Collections.sort(blankSpaces);

        for (int i = 0; i<blankSpaceIndex-1; i++){
            for (int j = 0; j<blankSpaceIndex-1; j++){
                if (blankSpaces.get(j) > blankSpaces.get(j+1)){
                    blankSpaces.set(j+1, blankSpaces.set(j, blankSpaces.get(j+1)));
                }
            }
        }

        System.out.println(blankSpaceIndex);
        System.out.print(blankSpaces.get(0));
        for(int i=1; i<blankSpaceIndex; i++){
            System.out.print(" "+blankSpaces.get(i));
        }
    }

    public static void initValues() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("day11\\data\\input_data.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(M>100 || N>100) return;
        adj = new int[M][N];

        // 직사각형이 그려진 영역은 1로 표시한다.
        for (int numOfK = 0; numOfK < K; numOfK++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    adj[y][x] = RECTANGLE;
                }
            }
        }

        br.close();
    }

    // 진입점을 찾는다 --> 빈공간을 찾는다 --> 직사각형이 그려지지 않은 영역을 찾는다.
    public static boolean isThereFirstPoint(){
        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (adj[y][x] == 0) {
                    adj[y][x] = VISITED;
                    blankSpaces.add(blankSpaceIndex, 1);
                    q.offer(new Pair(y, x));
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
        blankSpaces.set(blankSpaceIndex, blankSpaces.get(blankSpaceIndex)+1);
        q.offer(new Pair(y, x));
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
