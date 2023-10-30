import java.awt.Color;

/* This code inputs an integer from the user, which controls the depth of
recursion and outputs a picture of circles with four circles on the peripheral
of the circle with a mix of green and red colors and a mix of filled or hollow
circles.
 */

public class Art {

    // Draws circles and determines red or green
    private static void circle(double x, double y, double length) {
        if (StdRandom.uniformDouble() < 0.5) {
            StdDraw.setPenColor(Color.RED);
            StdDraw.setPenRadius(0.01);
            StdDraw.circle(x, y, length);
        }
        else {
            StdDraw.setPenColor(Color.GREEN);
            StdDraw.setPenRadius(0.01);
            StdDraw.circle(x, y, length);
        }
    }

    // Draws filled circles and determines red or green
    private static void filledCircle(double x, double y, double length) {
        if (StdRandom.uniformDouble() < 0.5) {
            StdDraw.setPenColor(Color.RED);
            StdDraw.setPenRadius(0.01);
            StdDraw.filledCircle(x, y, length);
        }
        else {
            StdDraw.setPenColor(Color.GREEN);
            StdDraw.setPenRadius(0.01);
            StdDraw.filledCircle(x, y, length);
        }
    }


    // Recursion for circles and filled circles
    private static void recursive(int n, double x, double y, double radius) {
        // base case
        if (n == 0)
            return;
        // Reduction Steps
        if (n % 2 == 0) {
            circle(x, y, radius);
            recursive(n - 1, x + radius, y + radius, radius / 2);
            recursive(n - 1, x + radius, y - radius, radius / 2);
            recursive(n - 1, x - radius, y - radius, radius / 2);
            recursive(n - 1, x - radius, y + radius, radius / 2);
        }
        else {
            filledCircle(x, y, radius);
            recursive(n - 1, x + radius, y + radius, radius / 2);
            recursive(n - 1, x + radius, y - radius, radius / 2);
            recursive(n - 1, x - radius, y - radius, radius / 2);
            recursive(n - 1, x - radius, y + radius, radius / 2);
        }

    }

    // Background and makes initial circle
    public static void main(String[] args) {
        StdDraw.picture(0.5, 0.5, "starfield.jpg");
        recursive(Integer.parseInt(args[0]), 0.5, 0.5, 0.25);
    }

}
