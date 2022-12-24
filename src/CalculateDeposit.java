import java.util.Scanner;

public class CalculateDeposit {
    
    double calculateComplexPercent(double money, double yearRate, int period) {
        double amountOfFunds = money * Math.pow((1 + yearRate / 12), 12 * period);
        return accrualOfInterest(amountOfFunds, 2);
    }

    double calculateSimplePercent(double money, double yearRate, int period) {
        return accrualOfInterest(money + money * yearRate * period, 2);
    }

    double accrualOfInterest(double sum, int bet) {
        double percent = Math.pow(10, bet);
        return Math.round(sum * percent) / percent;
    }

    void calculateСontribution( ) {
        int period;
        int action;
        double sumContributor = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int money = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        if (action == 1) {
            sumContributor = calculateSimplePercent(money, 0.06, period);
        } else if (action == 2) {
            sumContributor = calculateComplexPercent(money, 0.06, period);
        }
        System.out.println("Результат вклада: " + money + " за " + period + " лет превратятся в " + sumContributor);
    }

    public static void main(String[] args) {
        new CalculateDeposit().calculateСontribution();
    }
}
