package spoj;

import java.util.Scanner;

/**
 * Created by archithrapaka on 5/7/17.
 */
public class CATM {

    static class Point{
        int x;
        int y;

        public Point(int x , int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isCollinear(Point other) {
            return Math.abs(this.x - other.x) == Math.abs(this.y - other.y);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int k = scanner.nextInt();
        while (k > 0) {

            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            Point mouse = new Point(x1,y1);

            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            Point cat1 = new Point(x2,y2);

            int x3 = scanner.nextInt();
            int y3 = scanner.nextInt();

            Point cat2 = new Point(x3,y3);

            scanner.nextLine();

            if(mouse.isCollinear(cat1) && mouse.isCollinear(cat2)) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
            k--;
        }
    }
}
