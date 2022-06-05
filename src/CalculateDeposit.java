import java.util.Scanner;

public class CalculateDeposit {
    double calculateComplexPercent(double amount, double yearRate, int period) {
        double value = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return calculateAmount(value, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int period) {
        return calculateAmount(amount + amount * yearRate * period, 2);
    }

    double calculateAmount(double value, int places) {
        double scaLe = Math.pow(10, places);
        return Math.round(value * scaLe) / scaLe;
    }

    void printMenu() {
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double savings = 0;

        if (action == 1) {
            savings = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            savings = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + savings);
    }

    public static void main(String[] args) {
        new CalculateDeposit().printMenu();
    }
}
