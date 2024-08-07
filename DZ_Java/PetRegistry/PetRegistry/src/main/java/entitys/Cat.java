package entitys;

import java.util.List;

public class Cat extends HomeAnimals {

    private Integer id;
    private String name;
    private List<String> commands;
    private String dateBirth;
    private Integer kindId;

    public Cat(Integer id, String typeAnimal, Integer id1, String name, List<String> commands, String dateBirth, Integer kindId) {
        super(id = 1, typeAnimal = "home animals");
        this.id = id1;
        this.name = name;
        this.commands = commands;
        this.dateBirth = dateBirth;
        this.kindId = kindId;
    }

    public Cat() {
        this(null, null, null, null, null);
    }

    public Cat(Integer id1, String name, List<String> commands, String dateBirth, Integer kindId) {
        this(1, "home animals", id1, name, commands, dateBirth, kindId);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getCommands() {
        return commands;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public Integer getKindId() {
        return kindId;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    @Override
    public String toString() {
        return "Кошка {" +
                "id=" + id +
                ", название='" + name + '\'' +
                ", команды=" + commands +
                ", дата рождения=" + dateBirth +
                '}';
    }
}
