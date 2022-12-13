package Practicum;

import java.util.Scanner;

public class DepositCalculator {
    double calculateDepositWithCapitalization(double amount1, double yearRate1, int period1) {
        double pay = amount1 * Math.pow((1 + yearRate1 / 12), 12 * period1);
        return calculationMathematical(pay, 2);
    }

    double calculateDepositTheUsualPercentage(double amount2, double yearRate2, int period2) {
        return calculationMathematical(amount2 + amount2 * yearRate2 * period2, 2);
    }

    double calculationMathematical(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void processingUserEnteredData() {
        int period, action;
        Scanner abcdef = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = abcdef.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = abcdef.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = abcdef.nextInt();
        double resultDeposit = 0;
        if (action == 1) {
            resultDeposit = calculateDepositTheUsualPercentage(amount, 0.06, period);
        } else if (action == 2) {
            resultDeposit = calculateDepositWithCapitalization(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + resultDeposit);
    }

    public static void main(String[] args) {
        new DepositCalculator().processingUserEnteredData();
    }
}