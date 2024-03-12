package mainclasses.subclasses.baseclasses;

public class Point {
    protected int Xcoordinate;
    protected int Ycoordinate;
    protected int fieldsize;
    public Point(int Xcoordinate, int Ycoordinate){
        this.Xcoordinate = Xcoordinate;
        this.Ycoordinate = Ycoordinate;
    }
    public Point(){
        this(0,0);
    }

//    public Point distanceTo(Point target){
//        Point closeTarget = new Point();
//        return closeTarget;
//    }

    public int getXcoordinate() {
        return Xcoordinate;
    }

    public int getYcoordinate() {
        return Ycoordinate;
    }

    public void setXcoordinate(int xcoordinate) {
        Xcoordinate = xcoordinate;
    }

    public void setYcoordinate(int ycoordinate) {
        Ycoordinate = ycoordinate;
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + Xcoordinate +
                ", y=" + Ycoordinate +
                '}';
    }
}
