import java.util.Arrays;
import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double a, double y, int d) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return getRandom(pay, 2);
    }

    double calculateSimplePercent(double doubleAmount, double double_year_rate, int deposit_period) {
        return getRandom(doubleAmount + doubleAmount * double_year_rate * deposit_period, 2);
    }

    double getRandom(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void calculateDeposit() {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double totalAmount = 0;
        if (action == 1) {
            totalAmount = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            totalAmount = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + totalAmount);

        System.out.println("period = " + period);
        System.out.println();
        for (Object o : ) {

        }


    }

    public static void main(String[] args) {
        System.out.println("DepositCalculator.main");
        System.out.println("args = " + Arrays.deepToString(args));
        if (args == null) {

        }
        for (String arg : args) {


        }

        
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }
}
