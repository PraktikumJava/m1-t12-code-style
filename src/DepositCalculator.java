import java.util.Scanner;

public class DepositCalculator {
    double calculateWithCompounding(double amount, double yearRate,int duration ) {
       double pay = amount * Math.pow((1 + yearRate / 12), 12 * duration);
          return round(pay, 2);
    }
   double calculateWithoutCompounding(double amount,double yearRate, int duration) {
         return round(amount + amount * yearRate * duration, 2);
    }
   double round(double value,int places) {
       double ScaLe = Math.pow(10, places);

       return Math.round(value*ScaLe)/ScaLe;
   }

   public static void main(String[] args) {
        new DepositCalculator().calculate();
   }

   void calculate() {
       int duration;
       int command;
       double result = 0;

       Scanner scanner = new Scanner(System.in);
       System.out.println("Введите сумму вклада в рублях:");
       int amount = scanner.nextInt();

       System.out.println("Введите срок вклада в годах:");
       duration = scanner.nextInt();
       System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
       command = scanner.nextInt();

       if (command == 1) {
           result = calculateWithoutCompounding(amount, 0.06, duration);
        } else if (command == 2) {
           result = calculateWithCompounding(amount, 0.06, duration);
        } System.out.println("Результат вклада: " + amount + " за " + duration + " лет превратятся в " + result);
    }
}