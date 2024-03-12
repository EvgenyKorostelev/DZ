package mainclasses.subclasses.baseclasses;

public class Point {
    protected int coordinateX;
    protected int coordinateY;
    protected int fieldsize;

    public Point(int coordinateX, int coordinateY, int fieldsize) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.fieldsize = fieldsize;

    }

    public Point() {
        this(0, 0, 10);
    }


    public double distanceTo(Point target) {//Метод вычисления минимальной дистанции
        return Math.sqrt(Math.pow(target.coordinateX-coordinateX, 2)+Math.pow(target.coordinateY-coordinateY,2));
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + coordinateX +
                ", y=" + coordinateY +
                '}';
    }
}
