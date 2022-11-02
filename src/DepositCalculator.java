import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double annualInterestRate, int years) {
        double pay = amount * Math.pow((1 + annualInterestRate / 12), 12 * years);
        return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double annualInterestRate, int years) {
        return round(amount + amount * annualInterestRate * years, 2);
    }

    double round(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void calculateIncomeOnADeposit() {
        int years;
        int action;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");

        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        years = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double investmentResult = 0.0;
        if (action == 1) {
            investmentResult = calculateSimplePercent(amount, 0.06, years);
        } else if (action == 2) {
            investmentResult = calculateComplexPercent(amount, 0.06, years);
        }
        System.out.println("Результат вклада: " + amount + " за " + years + " лет превратятся в " + investmentResult);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateIncomeOnADeposit();
    }
}
