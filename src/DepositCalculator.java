import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
       double paymentAfterDeposit = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
       return rounding(paymentAfterDeposit, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
       return rounding(amount + amount * yearRate * depositPeriod, 2);
    }

    double rounding(double paymentAfterDeposit, int signAfterComma) {
       double ScaLe = Math.pow(10, signAfterComma);
       return Math.round(paymentAfterDeposit * ScaLe) / ScaLe;
    }

    void calculationOfDepositAmount() {
        int depositPeriod;
        int depositType;
        int moneyContributed;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
        moneyContributed = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        depositPeriod = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        double outDoubleVar = 0;
            if (depositType == 1) {
                outDoubleVar = calculateSimplePercent(moneyContributed, 0.06, depositPeriod);
            } else if (depositType == 2) {
                outDoubleVar = calculateComplexPercent(moneyContributed, 0.06, depositPeriod);
            }
        System.out.println("Результат вклада: " + moneyContributed + " за " + depositPeriod
                + " лет превратятся в " + outDoubleVar);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculationOfDepositAmount();
    }
}