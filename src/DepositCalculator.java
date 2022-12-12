import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().makeCalculation();
    }

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return getRound(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return getRound(amount + amount * yearRate * depositPeriod, 2);
    }

    double getRound(double amount, int places) {
        double scale = Math.pow(10, places);
        return Math.round(amount * scale) / scale;
    }

    void makeCalculation() {
        int period;
        int input;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        input = scanner.nextInt();
        double outDoubleVar = 0;
        if (input == 1) {
            outDoubleVar = calculateSimplePercent(amount, 0.06, period);
        } else if (input == 2) {
            outDoubleVar = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outDoubleVar);
    }
}
