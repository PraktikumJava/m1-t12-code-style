import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double depositAmount, double yearRate, int depositPeriod) {
        double result = depositAmount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(result, 2);
    }

    double calculateSimplePercent(double depositAmount, double yearRate, int depositPeriod) {
        return round(depositAmount + depositAmount * yearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateSimpleOrComplexPercent() {
        int depositAmount;
        int depositPeriod;
        int userAction;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму вклада в рублях: ");
        depositAmount = scanner.nextInt();

        System.out.print("Введите срок вклада в годах: ");
        depositPeriod = scanner.nextInt();

        System.out.print("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией: ");
        userAction = scanner.nextInt();

        double income = 0;

        if (userAction == 1) {
            income = calculateSimplePercent(depositAmount, 0.06, depositPeriod);
        } else if (userAction == 2) {
            income = calculateComplexPercent(depositAmount, 0.06, depositPeriod);
        }

        System.out.println("Результат вклада: " + depositAmount + " за " + depositPeriod + " лет превратятся в " + income);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateSimpleOrComplexPercent();
    }
}