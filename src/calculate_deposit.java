import java.util.Scanner; 

public class calculate_deposit {
    double calculateComplexPercent(double a, double y,int d ) { // Привет, тут ты, наверное забыл пробел после запятой!))
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return rnd(pay, 2);// А тут в твой программе закралась не понятная переменная, было бы круто назвать ее по-другому
    }
    double calculateSimplePercent(double doubleAmount,double doubleYearRate, int depositPeriod) { // Тот же недочет, что и вперый раз
    return rnd(doubleAmount + doubleAmount * doubleYearRate * depositPeriod, 2); // Переменную лучше назвать round
    }
    double rnd(double value, int places) { // лучше назвать round 
        double scaLe= Math.pow(10, places);
        return Math.round(value * scaLe) / scaLe;
    }

    void doImportantJob( ) {
        int period;
        int action;
        Scanner abcdef = new Scanner(System.in); // Scanner scanner будет выглядеть лучше
        System.out.println("Введите сумму вклада в рублях:") ;

        int amount = abcdef.nextInt();
// лучше соеденить это пробелом
        System.out.println("Введите срок вклада в годах:") ; 
        period = abcdef.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = abcdef.nextInt();

        double outDoubleVar = 0;

        if (action ==1) outDoubleVar = calculateSimplePercent(amount, 0.06, period);
        else if (action == 2) {
            outDoubleVar = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outDoubleVar);
    }

    public static void main(String[] args) { // мейн лучше перенести в начало класса
        new calculate_deposit().doImportantJob();
    }
}
