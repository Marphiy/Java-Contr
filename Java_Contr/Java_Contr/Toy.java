package Java_Contr;

public class Toy {
    private int id;
    private String name;
    private int chance;
    private int number;

    public Toy(int id, String name, int chance, int number) {
        this.id = id;
        this.name = name;
        this.chance = chance;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getChance() {
        return chance;
    }

    public Integer getNumber() {
        return number;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("Toy [id: %d, name: %s, chance: %d,  number: %d]", id, name, chance, number);
    }

}
