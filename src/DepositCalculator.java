import java.util.Scanner;

public class DepositCalculator  {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return squaring(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return squaring(amount + amount * yearRate * depositPeriod, 2);
    }

    double squaring(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale)/ scale;
    }

    void calculatePersents() {
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double moneySum = 0;
        if (action == 1) {
            moneySum = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            moneySum = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + moneySum);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculatePersents();
    }


}
