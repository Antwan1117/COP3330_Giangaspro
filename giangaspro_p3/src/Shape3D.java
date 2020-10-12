public abstract class Shape3D extends Shape {
    protected double sideLength;
    protected double Base;
    protected double Width;
    protected double Height;
    protected double Radius;
    abstract double getVolume();
}

class Cube extends Shape3D {
    public Cube (double s) {
        sideLength = s;
    }
    public String getName () {
        return "cube";
    }
    public double getArea () {
        return 6*(sideLength*sideLength);
    }
    public double getVolume() {
        return (sideLength*sideLength*sideLength);
    }
}

class Pyramid extends Shape3D {
    public Pyramid (double b, double w, double h) {
        Base = b;
        Width = w;
        Height = h;
    }
    public String getName () {
        return "pyramid";
    }
    public double getArea () {
        return (Base*Width)+(Width*(Math.sqrt((Height*Height)+((Base/2)*(Base/2)))))+(Base*(Math.sqrt((Height*Height)+((Width/2)*(Width/2)))));
    }
    public double getVolume () {
        return 0.33333333*((Base*Width)*Height);
    }
}

class Sphere extends Shape3D {
    public Sphere (double r) {
        Radius = r;
    }
    public String getName () {
        return "sphere";
    }
    public double getArea () {
        return 4*(3.14159*(Radius*Radius));
    }
    public double getVolume () {
        return 1.33333333*(3.14159*(Radius*Radius*Radius));
    }
}
