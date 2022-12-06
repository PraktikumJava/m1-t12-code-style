import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double payment = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundDecimal(payment, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return roundDecimal(amount + amount * yearRate * depositPeriod, 2);
    }

    double roundDecimal(double value, int power) {
        double scale = Math.pow(10, power);
        return Math.round(value * scale) / scale;
    }

    void calculatePayment() {
        int depositPeriod;
        int depositType;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();

        double payment = 0;
        if (depositType == 1) {
            payment = calculateSimplePercent(amount, 0.06, depositPeriod);
        }
        else if (depositType == 2) {
            payment = calculateComplexPercent(amount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + payment);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculatePayment();
    }

}
