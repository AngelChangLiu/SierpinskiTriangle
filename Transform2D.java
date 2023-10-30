public class Transform2D {
    /* This code copies, scales, translates, and rotates a polygon. It does not
    take in inputs, rather outputs the set polygon.
     */

    // Returns a new array object that is an exact copy of the given array.
    // The given array is not mutated.
    public static double[] copy(double[] array) {
        int n = array.length;
        double[] copy = new double[array.length];
        for (int i = 0; i < n; i++)
            copy[i] = array[i];
        return copy;
    }

    // Scales the polygon by the factor alpha.
    public static void scale(double[] x, double[] y, double alpha) {
        int n = x.length;
        for (int i = 0; i < n; i++) {
            x[i] = alpha * x[i];
            y[i] = alpha * y[i];

        }
    }

    // Translates the polygon by (dx, dy).
    public static void translate(double[] x, double[] y, double dx, double dy) {
        int n = x.length;
        for (int i = 0; i < n; i++) {
            x[i] += dx;
            y[i] += dy;
        }
    }

    // Rotates the polygon theta degrees counterclockwise, about the origin.
    public static void rotate(double[] x, double[] y, double theta) {
        double[] xcopy = copy(x);
        double[] ycopy = copy(y);
        int n = x.length;
        double THETA = Math.toRadians(theta);
        for (int i = 0; i < n; i++) {
            x[i] = xcopy[i] * Math.cos(THETA) - ycopy[i] * Math.sin(THETA);
            y[i] = ycopy[i] * Math.cos(THETA) + xcopy[i] * Math.sin(THETA);
        }

    }

    // Tests each of the API methods by directly calling them.
    public static void main(String[] args) {
        // Set the x- and y-scale
        StdDraw.setScale(-5.0, +5.0);

        // Create polygon
        double[] x = { 0, 1, 1, 0 };
        double[] y = { 0, 0, 2, 1 };

        // Draw original polygon in red
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.polygon(x, y);

        // Rotate polygon by 45 degrees ccw
        rotate(x, y, 45.0);

        // Draw rotated polygon in blue
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.polygon(x, y);
    }
}
