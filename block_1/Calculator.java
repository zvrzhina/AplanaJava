import java.util.Scanner;

/** Программа представляет собой Калькулятор для дробных чисел и Поиск самого длинного слова из перечня слов, введенных пользователем в консоли.
 * @autor Zavrazhina Alina
 * @version 1.0
 */
public class Calculator {
    /**
     * Scanner используемый для взаимодействия с Консолью
     */
    static Scanner scanner = new Scanner(System.in);

    /**
     * Метод main, с которого начинается выполнение программы
     * @param args
     */
    public static void main(String args[]) {
        /*
         * Выбор между запуском Калькулятора и Поиска в массиве
         */
        int program = chooseProgram();
        // 1 - Калькулятор
        if (program == 1) {
            // Получение чисел, над которыми будут произведены операции
            double num1 = getDouble();
            double num2 = getDouble();
            System.out.println("Вы выбрали Калькулятор.");
            // Выбор операции и ее исполнение
            double result = calculating(num1, num2);
            System.out.print("Результат равен ");
            System.out.printf("%.4f", result); // округление до 4-х знаков после запятой
        } else { // иначе запуск Поиска
            System.out.println("Вы выбрали Поиск максимального слова в массиве.");
            //Пользователь задает количество проверяемых слов
            int size = getArraySize();
            //Заполнение массива словами
            String[] words = setArray(size);
            //Вывод всех введенных слов
            System.out.println("Перечень введенных Вами слов:");
            for (String element : words) {
                System.out.println(element);
            }
            //Вывод самого длинного слова
            System.out.println("Самое длинное слово - " + searchingWords(size, words));
        }
    }

    /**
     * Функция считывает введеные дробные значения в консоли.
     * @return Возвращает введеное пользователем значение в консоли
     */
    public static double getDouble() {
        System.out.println("Пожалуйста, введите дробное число.");
        //Будем считывать введенные значения пока не получим дробное число
        while (!scanner.hasNextDouble()) {
            System.out.println("Введеное значение не является дробным! Повторите ввод.");
            scanner.next(); // Следующее значение
        }
        return scanner.nextDouble();
    }

    /**
     * Выбор исполняемой арифметической операции и ее реализация
     * @param num1 - первое значение введенное пользователем
     * @param num2 - второе значение введенное пользователем
     * @return Возвращает результат вычисления
     */
    public static double calculating(double num1, double num2) {
        double result;
        char operation;
        System.out.println("Выберите операцию:");
        System.out.println("'+' - сложение");
        System.out.println("'-' - вычитание");
        System.out.println("'*' - умножение");
        System.out.println("'/' - деление");
        //Считываем выбранную операцию и выполняем действие
        operation = scanner.next().charAt(0);
        switch (operation) {
            case '+':
                System.out.println(num1 + " + " + num2);
                result = num1 + num2;
                return result;
            case '-':
                System.out.println(num1 + " - " + num2);
                result = num1 - num2;
                return result;
            case '*':
                System.out.println(num1 + " * " + num2);
                result = num1 * num2;
                return result;
            case '/':
                System.out.println(num1 + " / " + num2);
                //выполним проверку деления на нуль
                try {
                    result = num1 / num2;
                } catch (ArithmeticException e) {
                    System.out.println("Делить на нуль нельзя!");
                    result = Double.parseDouble(null);
                }
                return result;
            default:
                System.out.println("Нераспознанная операция. Повторите ввод.");
                //рекурсивный вызов
                return calculating(num1, num2);
        }
    }

    /**
     * Старт программы начнется с выбора подпрограммы
     * @return в случае выбора Калькулятора возвращает 1, в случае Поиска - 2
     */
    public static int chooseProgram() {
        System.out.println("Нажмите 1 для запуска Калькулятора.");
        System.out.println("Нажмите 2 для запуска Поиск максимального слова в массиве.");
        while (!scanner.hasNextInt()) {
            System.out.println("Некорректный ввод! Повторите попытку.");
            scanner.next(); // Следующее значение
        }
        switch (scanner.nextInt()) {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                System.out.println("Некорректный ввод! Повторите попытку.");
                //рекурсивный вызов
                return chooseProgram();
        }
    }

    /**
     * Получение размера массива
     * @return Размер массива слов
     */
    public static int getArraySize() {
        System.out.println("Введите количество исследуемых слов.");
        while (!scanner.hasNextInt()) {
            System.out.println("Некорректный ввод! Вводите целое число.");
            scanner.next(); // Следующее значение
        }
        return scanner.nextInt();
    }

    /**
     * Заполнение массива словами с консоли
     * @param size - размер массива
     * @return Возвращает массив с заполненным пользователем значениями
     */
    public static String[] setArray(int size) {
        String[] words = new String[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Пожалуйста, введите слово.");
            words[i] = scanner.next();
        }
        return words;
    }

    /**
     * Поиск самого длинного слова
     * @param size - количество слов
     * @param array - массив слов
     * @return Возвращает самое длинное слово
     */
    public static String searchingWords(int size, String[] array) {
        String longestWord = "";// "Наиболее длинное слово", заданное по умолчанию
        //Каждое слово сравнивается с "самым длинным" и если встречается длиннее происходит замена
        for (int i = 0; i < size; i++) {
            if (array[i].length() > longestWord.length())
                longestWord = array[i];
        }
        return longestWord;
    }
}
