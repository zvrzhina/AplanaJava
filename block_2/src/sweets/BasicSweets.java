package sweets;

public class BasicSweets {
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

    BasicSweets(String name, double weight, double cost){
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }
}
