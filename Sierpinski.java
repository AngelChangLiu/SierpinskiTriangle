import java.awt.Color;

/* This code inputs an integer from the user, which controls the depth of
recursion and outputs Sierpinski's triangle. This is a big upside down triangle
with 3 triangles in it's peripheral.

 */
public class Sierpinski {

    // Height of an equilateral triangle with the specified side length.
    public static double height(double length) {
        return (length * Math.sqrt(3)) / 2;
    }

    // Draws a filled equilateral triangle with the specified side length
    // whose bottom vertex is (x, y).
    public static void filledTriangle(double x, double y, double length) {
        double[] a = { x, x - (length / 2), x + (length / 2) };
        double[] b = { y, y + height(length), y + height(length) };
        StdDraw.filledPolygon(a, b);
    }

    // Draws a Sierpinski triangle of order n, such that the largest filled
    // triangle has the specified side length and bottom vertex (x, y).
    public static void sierpinski(int n, double x, double y, double length) {
        // base case
        if (n == 0)
            return;
        // Reduction Steps
        filledTriangle(x, y, length);
        sierpinski(n - 1, x + (length / 2), y, length / 2); // right triangle
        sierpinski(n - 1, x - (length / 2), y, length / 2); // left triangle
        sierpinski(n - 1, x, y + height(length), length / 2); // top triangle

    }

    // Takes an integer command-line argument n;
    // draws the outline of an upwards equilateral triangle of length 1
    // whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0);
    // and draws a Sierpinski triangle of order n that fits inside the outline.
    public static void main(String[] args) {
        double[] x = { 0, 1, 0.5 };
        double[] y = { 0, 0, height(1) };
        StdDraw.polygon(x, y);
        StdDraw.setPenColor(Color.BLACK);
        sierpinski(Integer.parseInt(args[0]), 0.5, 0, 1.0 / 2);

    }

}
