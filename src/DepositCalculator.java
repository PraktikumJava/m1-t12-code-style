import java.util.Scanner;
public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().showProfit();
    }
    double calculateComplexPercent(double amount, double yearRate, int period) {  //лучше указать другое название переменных, например, "amount"
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return calculateRandom(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {  //как здесь:)
        return calculateRandom(amount + amount * yearRate * depositPeriod, 2);
    }

    double calculateRandom(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void showProfit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();  //как здесь:)
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