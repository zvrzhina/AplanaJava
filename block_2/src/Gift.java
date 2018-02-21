import sweets.BasicSweets;
import sweets.Candy;
import sweets.Jellybean;

import java.util.*;

public class Gift {
    private Map <String, Double> weightGift;// ключ - Название сладости, значение вес
    private Map <String, Double> costGift;// ключ - Название сладости, значение стоимость
    private double overallCost;
    private double overallWeight;
    private ArrayList<BasicSweets> sweetsList;//список конфет в подарке

    // При создании подарок пуст
    public Gift(){
        weightGift = new HashMap<>();
        costGift = new HashMap<>();
        overallCost = 0;
        overallWeight = 0;
        sweetsList = new ArrayList<>();
    }

    public void addSweets(){
        BasicSweets newSweet;
        System.out.println("Что желаете добавить в подарок: 1 - Candy, 2 - Jellybean.");
        int sweetType = CreatingGift.scanner.nextInt();
        if ((sweetType != 1) & (sweetType != 2))
            throw new IllegalArgumentException("Недопустимый ввод. Вы не определили 1 - Candy или 2 - Jellybean.");
        System.out.println("Введите название добавляемой сладости.");
        String name = CreatingGift.scanner.next();
        System.out.println("Введите вес сладости.");
        double weight = CreatingGift.scanner.nextDouble();
        System.out.println("Введите стоимость сладости.");
        double cost = CreatingGift.scanner.nextDouble();
        System.out.println("Введите уникальный идентификатор сладости.");
        String unid = CreatingGift.scanner.next();
        //Создаем сладость класса Candy
        if (sweetType == 1) {
            newSweet = new Candy(name, weight, cost, unid);
        }
        //Создаем сладость класса Jellybean
        else {
            newSweet = new Jellybean(name, weight, cost, unid);
        }
        sweetsList.add(newSweet); //добавление сладости
        System.out.println("Сладость " + newSweet.getName() + " успешно добавлена.");
        // Проверим, что вес и стоимость в картах равны нулям
        Double weightChecker = weightGift.get(newSweet.getName());
        if(weightChecker == null)
            weightChecker = 0.;
        Double costChecker = costGift.get(newSweet.getName());
        if(costChecker == null)
            costChecker = 0.;
        // Обновление карт для быстрого удаления/добавления элементов с одним именем
        weightGift.put(newSweet.getName(), weightChecker + newSweet.getWeight());
        costGift.put(newSweet.getName(), costChecker + newSweet.getWeight());
        updateWeightAndCost();
    }

    public void updateWeightAndCost(){
        overallWeight = 0;
        overallCost = 0;
        for (Map.Entry<String,Double> entry: weightGift.entrySet()) {
            overallWeight += entry.getValue();
        }
        for (Map.Entry<String, Double> entry: costGift.entrySet()) {
            overallCost += entry.getValue();
        }
    }

    public void removeSweets(String name){
        for(Iterator<BasicSweets> iterator = sweetsList.iterator(); iterator.hasNext();){
            if(iterator.next().getName().equals(name)){
                iterator.remove();
            }
        }
        for(Iterator<Map.Entry<String, Double>> it = weightGift.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Double> entry = it.next();
            if(entry.getKey().equals(name)) {
                it.remove();
            }
        }
        for(Iterator<Map.Entry<String, Double>> it = costGift.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Double> entry = it.next();
            if (entry.getKey().equals(name)) {
                it.remove();
            }
        }
        updateWeightAndCost();
    }

    public void printResult() {
        System.out.println("Состав подарка:");
        for(BasicSweets bsSw: sweetsList){
            System.out.println("Имя: " + bsSw.getName() + " Вес: " + bsSw.getWeight() + " Стоимость: " + bsSw.getCost());
        }
        System.out.println("Вес подарка составляет "+ overallWeight +" грамм, стоимость " + overallCost + " руб.");
    }
}
