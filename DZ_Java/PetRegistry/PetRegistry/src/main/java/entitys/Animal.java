package entitys;

public abstract class Animal {

    private Integer id;
    private String typeAnimal;

    public Animal(Integer id, String typeAnimal) {
        this.id = id;
        this.typeAnimal = typeAnimal;
    }
}
