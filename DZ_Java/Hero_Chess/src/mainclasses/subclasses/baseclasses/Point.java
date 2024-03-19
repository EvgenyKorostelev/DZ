package mainclasses.subclasses.baseclasses;

//Класс координат для юнитов
public class Point {
    protected int coordinateX;
    protected int coordinateY;
    protected int fieldsize;
    //Конструкторы
    public Point(int coordinateX, int coordinateY, int fieldsize) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.fieldsize = fieldsize;
    }
    public Point(int coordinateX, int coordinateY){
        this(coordinateX, coordinateY, 10);
    }
    public Point() {
        this(0, 0, 10);
    }
    //Метод вычисления минимальной дистанции
    public double distanceTo(Point target) {
        return Math.sqrt(Math.pow(target.coordinateX-coordinateX, 2)+Math.pow(target.coordinateY-coordinateY,2));
    }

    public int getFieldsize() {
        return fieldsize;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + coordinateX +
                ", y=" + coordinateY +
                '}';
    }
}
