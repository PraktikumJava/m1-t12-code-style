import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double firstVal, double secondVal, int thirdVal) {   // тут бы я поменял имена параметров как в calculateSimplePercent
        double pay = firstVal * Math.pow((1 + secondVal / 12), 12 * thirdVal);
        return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return makeRound(amount + amount * yearRate * depositPeriod, 2);
    }

    double makeRound(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void doImportantJob() { // тут бы тоже сменил название метода на более подходящее
        int period, action;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double outVar = 0;

        if (action == 1)
            outVar = calculateSimplePercent(amount, 0.06, period);
        else if (action == 2) {
            outVar = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outDoubleVar); // вопрос: тут outDoubleVar, выше outVar. Не должно работать
    }

    public static void main(String[] args) {
        new DepositCalculator().doImportantJob();
    }
}
