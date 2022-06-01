import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double percent = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(percent, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int exponent) {
        double scale = Math.pow(10, exponent);
        return Math.round(value * scale) / scale;
    }

    void calculateDeposit() {
        int period;
        int typeOfDeposit;
        int amount;

        Scanner userInput = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
            amount = userInput.nextInt();

        System.out.println("Введите срок вклада в годах:");
            period = userInput.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
            typeOfDeposit = userInput.nextInt();

        double income = 0;

        if (typeOfDeposit == 1) {
            income = calculateSimplePercent(amount, 0.06, period);
        } else if (typeOfDeposit == 2) {
            income = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + income);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }
}
