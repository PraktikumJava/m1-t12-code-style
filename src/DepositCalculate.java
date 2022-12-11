import java.util.Scanner;
public class DepositCalculate {
    public static void main(String[] args) {
        printCalculate();
    }
    static double calculateComplexPercent(double amount, double yearRate, int deposit) {
        return round(amount * Math.pow((1 + yearRate / 12), 12 * deposit), 2);
    }
    static double calculateSimplePercent(double amount, double yearRate, int deposit) {
        return round(amount + amount * yearRate * deposit, 2);
    }
    static double round(double value, int places) {
        double scaLe = Math.pow(10, places);

        return Math.round(value * scaLe) / scaLe;
    }


    static void printCalculate() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();
        double out = 0;
        if (action == 1) {
            out = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }
}










