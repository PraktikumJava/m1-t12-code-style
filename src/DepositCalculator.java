import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().calculatePercent();
    }

    void calculatePercent() {
        int depositPeriod;
        int depositType;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int initialDepositAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        double finalDepositAmount = 0;
        if (depositType == 1) {
            finalDepositAmount = calculateSimplePercent(initialDepositAmount, 0.06, depositPeriod);
        } else if (depositType == 2) {
            finalDepositAmount = calculateComplexPercent(initialDepositAmount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + initialDepositAmount + " за " + depositPeriod + " лет превратятся в "
            + finalDepositAmount);
    }

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double finalAmount = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(finalAmount, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int exponent) {
        double scale = Math.pow(10, exponent);
        return Math.round(value * scale) / scale;
    }
}