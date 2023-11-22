import java.util.Scanner;

public class CalculateDeposit {
    double calculateComplexPercent(double a, double y, int d ) {
       double pay = a * Math.pow((1 + y / 12), 12 * d);

       return round(pay, 2);
    }

    double calculateSimplePercent(double doubleAmount, double doubleYearRate, int depositPeriod) {
         return round(doubleAmount + doubleAmount * doubleYearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
       double scale = Math.pow(10, places);

       return Math.round(value * scale) / scale;
    }

    void startCalculateDeposit() {
      Scanner scanner = new Scanner(System.in);

      System.out.println("Введите сумму вклада в рублях:");
      int amount = scanner.nextInt();
      System.out.println("Введите срок вклада в годах:");
      int period = scanner.nextInt();
      System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
      int action = scanner.nextInt();
      double outValue = 0;

      if (action == 1) {
          outValue = calculateSimplePercent(amount, 0.06, period);
      } else if (action == 2) {
          outValue = calculateComplexPercent(amount, 0.06, period);
      }
      System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outValue);
    }

    public static void main(String[] args) {
        new CalculateDeposit().startCalculateDeposit();
    }
}
