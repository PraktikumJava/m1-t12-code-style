import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().calculateIncome();
    }

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void calculateIncome() {
        Scanner scanner = new Scanner(System.in);
        int period, action;
        int amount = scanner.nextInt();
        double total = 0;
        period = scanner.nextInt();
        action = scanner.nextInt();

        if (action == 1) {
            total = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            total = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Введите сумму вклада в рублях:");
        System.out.println("Введите срок вклада в годах:");
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        System.out.println("Результат вклада: " + amount + " за " + period
            + " лет превратятся в " + total);
    }


}
