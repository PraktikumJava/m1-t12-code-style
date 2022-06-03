import java.util.Scanner;

public class DepositCalculator {

    public static void main(String[] args) {
        new DepositCalculator().selectDepositOptions();
    }

    void selectDepositOptions() {
        int amount;
        int period;
        int command;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        command = scanner.nextInt();
        double income = 0;
        if (command == 1) {
            income = calculateSimplePercent(amount,0.06, period);
        } else if (command == 2) {
            income = calculateComplexPercent(amount,0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + income);
    }

    double calculateSimplePercent(double amount, double yearRate, int period) {
        return calculateIncome(amount + amount * yearRate * period,2);
    }

    double calculateComplexPercent(double amount, double yearRate, int period) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return calculateIncome(pay,2);
    }

    double calculateIncome(double value, int places) {
        double Scale = Math.pow(10, places);
        return Math.round(value * Scale) / Scale;
    }
}
