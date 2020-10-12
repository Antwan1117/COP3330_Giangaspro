public abstract class Shape2D extends Shape{
    protected double sideLength;
    protected double Base;
    protected double Height;
    protected double Radius;
}

class Square extends Shape2D {
    public Square (double s) {
        sideLength = s;
    }
    public String getName () {
        return "square";
    }
    public double getArea() {
        return sideLength*sideLength;
    }
}

class Triangle extends Shape2D {
    public Triangle (double b, double h) {
        Base = b;
        Height = h;
    }
    public String getName() {
        return "triangle";
    }
    public double getArea() {
        return (0.5*Base*Height);
    }
}

class Circle extends Shape2D {
    public Circle (double r) {
        Radius = r;
    }
    public String getName() {
        return "circle";
    }
    public double getArea() {
        return (3.14159*(Radius*Radius));
    }
}
