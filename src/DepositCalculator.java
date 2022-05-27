import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double annualRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + annualRate / 12), 12 * depositPeriod);

        return roundAmount(pay, 2);
    }

    double calculateSimplePercent(double amount, double annualRate, int depositPeriod) {
        return roundAmount(amount + amount * annualRate * depositPeriod, 2);
    }

    double roundAmount(double amount, int places) {
        double scale = Math.pow(10, places);

        return Math.round(amount * scale) / scale;
    }

    void workWithDeposit() {
        int depositPeriod;
        int action;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double resultAmount = 0;

        if (action == 1) {
            resultAmount = calculateSimplePercent(amount, 0.06, depositPeriod);
        } else if (action == 2) {
            resultAmount = calculateComplexPercent(amount, 0.06, depositPeriod);
        }

        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + resultAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().workWithDeposit();
    }

}