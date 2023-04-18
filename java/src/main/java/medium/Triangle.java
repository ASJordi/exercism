package medium;

public class Triangle {

    private final double s1, s2, s3;

    Triangle(double side1, double side2, double side3) throws TriangleException {

        if (side1 + side2 + side3 == 0) {
            throw new TriangleException();
        }
        if (side1 + side2 < side3 || side1 + side3 < side2 || side2 + side3 < side1){
            throw new TriangleException();
        }

        this.s1 = side1;
        this.s2 = side2;
        this.s3 = side3;
    }

    public boolean isEquilateral() {
        return (s1 == s2 && s2 == s3) ? true : false;
    }

    public boolean isIsosceles() {
        return (s1 == s2 || s1 == s3 || s2 == s3) ? true : false;
    }

    public boolean isScalene() {
        return (s1 != s2 && s1 != s3 && s2 != s3) ? true : false;
    }

}
