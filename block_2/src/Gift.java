import sweets.BasicSweets;
import sweets.Candy;
import sweets.Jellybean;

import java.util.*;

/**
 * Класс отвечает за создание подарка, его наполнение и удаление сладостей из него
 */
public class Gift {
    private Map <String, Double> weightGift;// ключ - Название сладости, значение вес
    private Map <String, Double> costGift;// ключ - Название сладости, значение стоимость
    private double overallCost;//итоговая стоимость подарка
    private double overallWeight;//итоговый вес подарка
    private ArrayList<BasicSweets> sweetsList;//список конфет в подарке

    // При создании подарок пуст
    public Gift(){
        weightGift = new HashMap<>();
        costGift = new HashMap<>();
        overallCost = 0;
        overallWeight = 0;
        sweetsList = new ArrayList<>();
    }

    /**
     * Класс добавляет сладости в подарок
     */
    public void addSweets(){
        BasicSweets newSweet;//объявление сладости, пока не известен тип
        System.out.println("Что желаете добавить в подарок: 1 - Candy, 2 - Jellybean.");
        int sweetType = CreatingGift.scanner.nextInt(); //считываем какого типа будет конфета
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
            newSweet = new Candy(name, weight, cost, unid);//создание Candy
        }
        //Создаем сладость класса Jellybean
        else {
            newSweet = new Jellybean(name, weight, cost, unid);
        }
        sweetsList.add(newSweet); //добавление сладости
        System.out.println("Сладость " + newSweet.getName() + " успешно добавлена.");
        // Проверим, что вес и стоимость не равны null
        Double weightChecker = weightGift.get(newSweet.getName());
        if(weightChecker == null)
            weightChecker = 0.;//зануляем значение при добавление ключа
        Double costChecker = costGift.get(newSweet.getName());
        if(costChecker == null)
            costChecker = 0.;
        // Обновление карт для быстрого удаления/добавления элементов с одним именем
        weightGift.put(newSweet.getName(), weightChecker + newSweet.getWeight());
        costGift.put(newSweet.getName(), costChecker + newSweet.getCost());
        updateWeightAndCost();//обновление стоимости и веса всего подарка
    }

    public void updateWeightAndCost(){
        overallWeight = 0;
        overallCost = 0;
        for (Map.Entry<String,Double> entry: weightGift.entrySet()) { //обойдем всю карту
            overallWeight += entry.getValue();
        }
        for (Map.Entry<String, Double> entry: costGift.entrySet()) {
            overallCost += entry.getValue();
        }
    }

    /**
     * Удаляет полностью сладость из подарка
     * @param name - имя удаляемой сладости
     */
    public void removeSweets(String name){
        //обойдем ArrayList через итератор
        for(Iterator<BasicSweets> iterator = sweetsList.iterator(); iterator.hasNext();){
            //если в динамическом массиве встретился элемент для удаления, то удаляем
            if(iterator.next().getName().equals(name)){
                iterator.remove();
            }
        }
        //пройдем карту используя итератор
        for(Iterator<Map.Entry<String, Double>> it = weightGift.entrySet().iterator(); it.hasNext(); ) {
            //совпадение ключа с именем удаляемого объекта приведет к удалению этого объекта
            if(it.next().getKey().equals(name))
                it.remove();
        }
        for(Iterator<Map.Entry<String, Double>> it = costGift.entrySet().iterator(); it.hasNext(); ) {
            if (it.next().getKey().equals(name))
                it.remove();
        }
        updateWeightAndCost();
    }

    /**
     * Вывод информации по составу подарка, а также общий вес и стоимость
     */
    public void printResult() {
        System.out.println("Состав подарка:");
        for(BasicSweets bsSw: sweetsList){
            System.out.println("Имя: " + bsSw.getName() + " Вес: " + bsSw.getWeight() + " Стоимость: " + bsSw.getCost());
        }
        System.out.println("Вес подарка составляет "+ overallWeight +" грамм, стоимость " + overallCost + " руб.");
    }
}
