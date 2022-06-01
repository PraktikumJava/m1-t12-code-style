import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double a, double y, int d ) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return calculatePercent(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return calculatePercent(amount + amount * yearRate * depositPeriod, 2);
    }

    double calculatePercent(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void printMenu() {
        Scanner scanner = new Scanner(System.in);

        int period;
        int action;
        double calculateAmount = 0;

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        if (action == 1) {
            calculateAmount = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            calculateAmount = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + calculateAmount);
        }

    public static void main(String[] args) {
        new DepositCalculator().printMenu();
    }
}
