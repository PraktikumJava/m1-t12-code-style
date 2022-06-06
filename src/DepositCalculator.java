import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double rateYear, int period) {
        double value = amount * Math.pow((1 + rateYear / 12), 12 * period);
        return roundingValue(value, 2);
    }
    double calculateSimplePercent(double amount, double rateYear, int period) {
        return roundingValue(amount + amount * rateYear * period, 2);
    }
    double roundingValue(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
    void depositManager() {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях: ");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах: ");
        period = scanner.nextInt();

        System.out.println(
                "Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией: ");
        action = scanner.nextInt();

        double out = 0;

        if (action == 1) {
            out = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new DepositCalculator().depositManager();
    }

}
