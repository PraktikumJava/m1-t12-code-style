import java.util.Scanner;

public class DepositCalculator {
    double calculateTheComplexPercent(double amount, double yearRate, int depositPeriod) {
        double income = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);

        return roundTheNumber(income, 2);
    }
    double calculateTheSimplePercent(double amount, double yearRate, int depositPeriod) {
        return roundTheNumber(amount + amount * yearRate * depositPeriod, 2);
    }
    double roundTheNumber(double value, int accuracy) {
        double ScaLe = Math.pow(10, accuracy);
        return Math.round(value * ScaLe) / ScaLe;
    }
    void calculateInterestIncome() {
        int depositTerm;
        int typeOfDeposit;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        depositTerm = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        typeOfDeposit = scanner.nextInt();

        double totalIncome = 0;

        if (typeOfDeposit == 1) {
            totalIncome = calculateTheSimplePercent(amount, 0.06, depositTerm);
        } else if (typeOfDeposit == 2) {
            totalIncome = calculateTheComplexPercent(amount, 0.06, depositTerm);
        }
        System.out.println("Результат вклада: " + amount + " за " + depositTerm + " лет превратятся в " + totalIncome);
    }
    public static void main (String[] args) {
        new DepositCalculator().calculateInterestIncome();
    }
}