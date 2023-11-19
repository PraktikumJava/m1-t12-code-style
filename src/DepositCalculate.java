import java.util.Scanner;

public class DepositCalculate {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);

        return roundNumber(pay, 2);
    }

    double calculateSimplePercent(double amount,
            double yearRate, int depositPeriod) {

        return roundNumber(amount + amount
                * yearRate * depositPeriod, 2);
    }

    double roundNumber(double value, int power) {
       double scale = Math.pow(10, power);

       return Math.round(value * scale) / scale;
    }

    void calculateProfitDeposit() {
        int period;
        int action;
        int amount;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, " +
                "1 - вклад с обычным процентом, " +
                "2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double sumDeposit = 0;

        if (action == 1) {
          sumDeposit = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
          sumDeposit = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: "
              + amount + " за " + period
              + " лет превратятся в " + sumDeposit);
    }

    public static void main(String[] args) {
        new DepositCalculate().calculateProfitDeposit();
    }
}
