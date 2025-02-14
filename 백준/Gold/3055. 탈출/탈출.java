    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.LinkedList;
    import java.util.Queue;
    import java.util.StringTokenizer;

    public class Main {

        public static class Point {
            int r;
            int c;

            Point(int r, int c) {
                this.r = r;
                this.c = c;
            }
        }

        public static int r, c, time;
        public static boolean cantGo, depart;
        public static char[][] map;
        public static boolean[][] visited;
        public static Queue<Point> animalQueue, waterQueue;
        public static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            map = new char[r][c];
            visited = new boolean[r][c];
            animalQueue = new LinkedList<>();
            waterQueue = new LinkedList<>();

            for(int i = 0; i < r; i++) {
                String line = br.readLine();
                for(int j = 0; j < c; j++) {
                    // 고슴도치는 객체를 생성하고, .으로 대체
                    if(line.charAt(j) == 'S') {
                        animalQueue.offer(new Point(i, j));
                        map[i][j] = '.';
                        visited[i][j] = true;
                        continue;
                    }
                    if(line.charAt(j) == '*') {
                        waterQueue.offer(new Point(i, j));
                    }
                    map[i][j] = line.charAt(j);
                }
            }

            time = 0;
            while(true){
                spreadWater();
                moveAnimal();

                // 갈 곳이 없다면
                if(cantGo) {
                    System.out.println("KAKTUS");
                    break;
                }
                
                // 도착했다면
                if(depart) {
                    System.out.println(time);
                    break;
                }
            }
        }

        // 물을 퍼뜨리는 메서드
        public static void spreadWater() {
            int size = waterQueue.size();
            for(int i = 0; i < size; i++) {
                Point point = waterQueue.poll();
                for(int d = 0; d < 4; d++) {
                    int nr = point.r + dr[d];
                    int nc = point.c + dc[d];

                    if(nr >= 0 && nr < r && nc >= 0 && nc < c && map[nr][nc] != 'X' && map[nr][nc] != 'D' && map[nr][nc] != '*') {
                        map[nr][nc] = '*';
                        waterQueue.offer(new Point(nr, nc));
                    }
                }
            }
        }

        // 고슴도치가 이동하는 메서드
        public static void moveAnimal() {
            time++;
            int size = animalQueue.size();

            // 움직일 수 있는 고슴도치가 있는지 확인
            if(size == 0) {
                cantGo = true;
                return;
            }

            for(int i = 0; i < size; i++) {
                Point point = animalQueue.poll();
                for(int d = 0; d < 4; d++) {
                    int nr = point.r + dr[d];
                    int nc = point.c + dc[d];

                    // 움직일 수 있다면
                    if(nr >= 0 && nr < r && nc >= 0 && nc < c && !visited[nr][nc] && map[nr][nc] != 'X' && map[nr][nc] != '*') {
                        // 굴을 만나면
                        if(map[nr][nc] == 'D') {
                            depart = true;
                            return;
                        }

                        Point newPoint = new Point(nr, nc);
                        animalQueue.offer(newPoint);
                        visited[nr][nc] = true;
                    }
                }
            }
        }
    }
