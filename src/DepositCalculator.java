import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        return round(amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod), 2);
    }
    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int exponent) {
        double scale = Math.pow(10, exponent);
        return Math.round(value * scale) / scale;
    }

    void calculateDepositResult() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amountInRoubles = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        int periodInYears = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int depositTypeNumber = scanner.nextInt();
        double depositResult = 0;
        if (depositTypeNumber == 1)
            depositResult = calculateSimplePercent(amountInRoubles, 0.06, periodInYears);
        else if (depositTypeNumber == 2)
            depositResult = calculateComplexPercent(amountInRoubles, 0.06, periodInYears);
        System.out.println("Результат вклада: " + amountInRoubles + " за " + periodInYears + " лет превратятся в " + depositResult);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDepositResult();
    }
}
