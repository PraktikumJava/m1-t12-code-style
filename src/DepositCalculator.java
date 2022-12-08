import java.util.Scanner;

public class DepositCalculator {
    double CalculateComplexPercent(double a, double y, int d) {
    double pay = a * Math.pow((1 + y / 12), 12 * d);
    return roundUp(pay, 2);
    }

    double CalculateSimplePercent(double amount, double yearRate,
    int depositPeriod) {
    return roundUp(amount+amount * yearRate * depositPeriod, 2);
    }

    double roundUp(double value, int places) {
    double scaLe = Math.pow(10, places);
    return Math.round(value * scaLe) / scaLe;
    }

    void countDepositAmount() {
    int period, action;

    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите сумму вклада в рублях:");
    int amount = scanner.nextInt();

    System.out.println("Введите срок вклада в годах:");
    period = scanner.nextInt();

    System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
    action = scanner.nextInt();
    double depositAmount = 0;

    if (action == 1) {
        depositAmount = CalculateSimplePercent(amount, 0.06, period);
    } else if (action == 2) {
        depositAmount = CalculateComplexPercent(amount, 0.06, period);
    }

    System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в "
    + depositAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().countDepositAmount();
    }
}
