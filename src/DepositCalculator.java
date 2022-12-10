import java.util.Scanner;

public class DepositCalculator {

    public static void main(String[] args) {
        new DepositCalculator().findInputValue();
    }

    double calculateComplexPercent(double a, double y, int d) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return findRoundValue(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return findRoundValue(amount + amount * yearRate * depositPeriod, 2);
    }

    double findRoundValue(double base, int exponent) {
        double pow = Math.pow(10, exponent);
        return Math.round(base * pow) / pow;
    }

    void findInputValue() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = input.nextInt();
        System.out.println("Введите срок вклада в годах:");
        int period = input.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = input.nextInt();
        double result = 0;
        if (action == 1) {
            result = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            result = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }

}