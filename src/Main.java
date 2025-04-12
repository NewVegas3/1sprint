import java.util.Scanner;

@SuppressWarnings("InfiniteLoopStatement")
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();

            int i = scanner.nextInt();
            switch (i) {
                case 1 -> stepTracker.addNewNumberStepsPerDay();
                case 2 -> stepTracker.changeStepGoal();
                case 3 -> stepTracker.printStatistic();
                case 4 -> {
                    System.out.println("Пока");
                    scanner.close();
                }
                default -> System.out.println("Такой команды нет");
            }
        }
    }

    static void printMenu() {
        System.out.println("Введите команду от 1 до 4");
        System.out.println("1 - Ввод количества шагов за день");
        System.out.println("2 - Изменить цель по количеству шагов за день");
        System.out.println("3 - Напечатать статистику за опеределенный месяц");
        System.out.println("4 - Выйти из приложения");
    }
}