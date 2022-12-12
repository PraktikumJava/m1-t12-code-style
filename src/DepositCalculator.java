import java.util.Scanner;

public class DepositCalculator {
    double findComplexPercent(double amount, double yearRate, int depositPeriod) {
        double totalAmount = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return getRounded(totalAmount, 2);
    }

    double findSimplePercent(double amount, double yearRate, int depositPeriod) {
        double totalAmount = amount + amount * yearRate * depositPeriod;
        return getRounded(totalAmount, 2);
    }

    double getRounded(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void getResultDeposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int userInput = scanner.nextInt();
        double result = 0;
        if (userInput == 1) {
            result = findSimplePercent(amount, 0.06, period);
        } else if (userInput == 2) {
            result = findComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }

    public static void main(String[] args) {
        new DepositCalculator().getResultDeposit();
    }
}
