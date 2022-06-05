import java.util.Scanner;

public class CalculateDeposit {
    double calculateComplexPercent(double amount, double yearRate, int period ) {
        double value = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return calculateAmount(value, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int period) {
         return calculateAmount(amount + amount * yearRate * period, 2);
    }

    double calculateAmount(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe; // лучше использовать scale
    }

    void printMenu() {
        int period, action; // лучше перенести переменную на вторую строку
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt( );

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double outDoubleVar = 0; // лучше переименовать и дать говорящее название

        if (action ==1) {
            outDoubleVar = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            outDoubleVar = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outDoubleVar);
    }

    public static void main(String[] args) {
        new CalculateDeposit().printMenu();
    }
}
// правки незначительные, код красивый и читабельный