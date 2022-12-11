import java.util.Scanner;

public class CalculateDeposit {

    double calculateComplexPercent(double depositAmount, double coefficient, int period) {
        double pay = depositAmount * Math.pow((1 + coefficient / 12), 12 * period);

        return calculateRound(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return calculateRound(amount + amount * yearRate * depositPeriod, 2);
    }

    double calculateRound(double value, int places) {
        double ScaLe = Math.pow(10, places);

        return Math.round(value * ScaLe) / ScaLe;
    }

    void doJob() {
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt( );

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double out = 0;

        if (action == 1) {
            out = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        } System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new CalculateDeposit().doJob();
    }
}
