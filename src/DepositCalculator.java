import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double depositAmount, double yearRate, int depositPeriod) {
        double amount = depositAmount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);

        return calculateAmountWithPercents(amount, 2);
    }

    double calculateSimplePercent(double depositAmount, double yearRate, int depositPeriod) {
        return calculateAmountWithPercents(depositAmount + depositAmount * yearRate * depositPeriod, 2);
    }

    double calculateAmountWithPercents(double amount, int power) {
        return Math.round(amount * Math.pow(10, power)) / Math.pow(10, power);
    }

    void depositCalculation() {
        int depositPeriod;
        int command;
        int depositAmount;
        double amountWithPercents = 0;
        double yearRate = 0.06;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        depositAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        command = scanner.nextInt();
        if (command == 1) {
            amountWithPercents = calculateSimplePercent(depositAmount, yearRate, depositPeriod);
        } else if (command == 2) {
            amountWithPercents = calculateComplexPercent(depositAmount, yearRate, depositPeriod);
        }
        System.out.print("Результат вклада: " + depositAmount + " за " + depositPeriod);
        System.out.print(" лет превратятся в " + amountWithPercents);
    }

    public static void main(String[] args) {
        new DepositCalculator().depositCalculation();
    }
}