import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double depositAmount, double yearRate, int depositPeriod ) {
       double payment = depositAmount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);

       return round(payment, 2);
    }


    double calculateSimplePercent(double doubleAmount, double yearRate,
                                  int depositPeriod) {
        return round(doubleAmount+doubleAmount * yearRate
                * depositPeriod, 2);
    }

    double round(double value, int places) {
       double scale = Math.pow(10, places);

       return Math.round(value * scale) / scale;
    }

    void startCalculator( ) {
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt( );

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом," +
                            " 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double payment = 0;

        if (action == 1) {
            payment = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            payment = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period +
                " лет превратятся в " + payment);
    }

    public static void main(String[] args) {
        new DepositCalculator().startCalculator();
    }

}
