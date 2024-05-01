package entity;

public class Toy {

    private int id;
    private String name;
    private int count;
    private float rate;

    public Toy(int id, String name, int count, float rate) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getCount() {
        return count;
    }
    public float getRate() {
        return rate;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", название='" + name + '\'' +
                ", количество=" + count +
                ", шанс выпадения=" + rate +
                '}';
    }
}
