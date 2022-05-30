import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double a, double yearRate, int depositPeriod) {
       double pay = a * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
       return roundUp(pay, 2);
  }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return roundUp(amount + amount * yearRate * depositPeriod, 2);
    }

    double roundUp(double value, int places) {
        double ScaLe= Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void printMenu() {
        int period, action;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amountRub = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double out = 0;

        if (action == 1) {
            out = calculateSimplePercent(amountRub, 0.06, period);
        } else if (action == 2) {
            out = calculateComplexPercent(amountRub, 0.06, period);
        }
        System.out.println("Результат вклада: " + amountRub + " за " + period + " лет превратятся в " + out);
        }

    public static void main(String[] args) {
        new DepositCalculator().printMenu();
    }
}
