import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    Converter converter = new Converter();

    MonthData[] monthToData = new MonthData[12];
    int  goalByStepsPerDay = 10000;


    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Пожалуйста,введите номер  с  1 до 12  (включительно)");
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Пожалуйста,введите номер  с  1 до 30  (включительно)");
            return;
        }

        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();
        if (steps <= 0) {
            System.out.println("Пожалуйста,уверен Вы прошли больше 0 шагов,количество шагов должно быть положительным числом.");
            return;
        }

        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] += steps;
    }

    void changeStepGoal() {
        int newGoal = scanner.nextInt();
        System.out.println("Пожалуйста введите новую цель по шагам");
        if (newGoal <= 0) {
            System.out.println("Пожалуйста, введите цель больше  0");
        } else {
            goalByStepsPerDay = newGoal;
        }
    }

    void printStatistic() {
        System.out.println("Введите число месяца");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Пожалуйста,введите номер  с  1 до 12  (включительно)");
            return;
        }

        MonthData monthData = monthToData[month - 1];
        monthData.printDaysAndStepsFromMonth(); //  вывод общей статистики по дням
        System.out.println("Вывод суммы шагов за месяц " + monthData.sumStepsFromMonth());
        System.out.println("Вывод максимального пройденного количества шагов за месяц " + monthData.maxSteps());
        System.out.println("вывод среднего пройденного количества шагов за месяц " + monthData.sumStepsFromMonth() / monthData.days.length);        // вывод среднего пройденного количества шагов за месяц
        System.out.println("вывод пройденной за месяц дистанции в км " + converter.convertToKm(monthData.sumStepsFromMonth()));        // вывод пройденной за месяц дистанции в км
        System.out.println("вывод количества сожжённых килокалорий за месяц " + converter.convertStepsToKilocalories(monthData.sumStepsFromMonth()));        // вывод количества сожжённых килокалорий за месяц
        System.out.println("вывод лучшей серии " + monthData.bestSeries(goalByStepsPerDay));        // вывод лучшей серии
                System.out.println(); //дополнительный перенос строки
    }

}
