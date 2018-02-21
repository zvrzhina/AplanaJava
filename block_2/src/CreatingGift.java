import java.util.Scanner;

public class CreatingGift {
    static Scanner scanner = new Scanner(System.in); // статический сканнер для считывания значений с консоли

    public static void main(String[] args) {
        Gift gift = new Gift();
        gift.addSweets();
        gift.addSweets();
        gift.addSweets();
        gift.printResult();
        //для проверки удаления необходимо создать экземпляр сладости с именем choco
        gift.removeSweets("choco");
        gift.printResult();
    }
}
