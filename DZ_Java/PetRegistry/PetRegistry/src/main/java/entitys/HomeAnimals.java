package entitys;

public abstract class HomeAnimals extends Animal {

    private Integer id;
    private String kindAnimal;
    private Integer typeId;

    public HomeAnimals(Integer id, String typeAnimal) {
        super(id, typeAnimal);
    }
}
