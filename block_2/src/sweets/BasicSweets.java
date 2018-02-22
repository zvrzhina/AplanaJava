package sweets;

/**
 * Абстрактный класс конфет
 */
public abstract class BasicSweets {
    private String name;
    private double weight;
    private double cost;

    public String getName(){
        return name;
    }

    public double getWeight(){
        return weight;
    }

    public double getCost(){
        return cost;
    }

    /**
     * Конструктор абстрактного класса, используется в потомках
     * @param name - имя сладости
     * @param weight - вес
     * @param cost - стоимость
     */
    BasicSweets(String name, double weight, double cost){
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }
}
