import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double startDeposit, double yearRate, int depositPeriod) {
        double pay = startDeposit * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundFinalDeposit(pay, 2);
    }

    double calculateSimplePercent(double startDeposit, double yearRate, int depositPeriod) {
        return roundFinalDeposit(startDeposit + startDeposit * yearRate * depositPeriod, 2);
    }

    double roundFinalDeposit(double finalDeposit, int DecimalPlaces) {
        double scale = Math.pow(10, DecimalPlaces);
        return Math.round(finalDeposit * scale) / scale;
    }

    void calculationDepositInterest() {
        int depositPeriod;
        int depositType;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int startDeposit = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        double finalDeposit = 0;
        if (depositType == 1) {
            finalDeposit = calculateSimplePercent(startDeposit, 0.06, depositPeriod);
        } else if (depositType == 2) {
            finalDeposit = calculateComplexPercent(startDeposit, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + startDeposit + " за " + depositPeriod + " лет превратятся в "
                + finalDeposit);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculationDepositInterest();
    }
}
