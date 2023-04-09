import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
       double savings = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
       return round(savings, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
         return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int decimalPlaces) {
       double scale = Math.pow(10, decimalPlaces);
       return Math.round(value * scale) / scale;
    }

    void calculateDeposit() {
        int period;
        int typeOfDeposit;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        typeOfDeposit = scanner.nextInt();

        double savingsAmount = 0;
        if (typeOfDeposit == 1) {
            savingsAmount = calculateSimplePercent(amount, 0.06, period);
        } else if (typeOfDeposit == 2) {
            savingsAmount = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + savingsAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }
}
