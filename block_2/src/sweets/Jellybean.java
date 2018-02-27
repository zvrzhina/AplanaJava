package sweets;

public class Jellybean extends BasicSweets{
    //будем считать что уникальный идентификатор настолько уникален что в каждом подклассе это отдельное поле
    private String uniq;

    public Jellybean(String name, double weight, double cost, String uniq){
        //вызов конструктора BasicSweets
        super(name, weight, cost);
        this.uniq = uniq;
    }

    public String getUniq(){
        return uniq;
    }

}
