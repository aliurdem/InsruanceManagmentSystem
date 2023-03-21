import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class HealthInsurance extends Insurance{
    public HealthInsurance(double cost) {
        super(1,"Sağlık sigortası",cost);
    }

    @Override
    public double calculate(Account account) {
        double fee;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Herhangi bir kronik rahatsızlığınız var mı ? Y/N : ");
        String answer = scanner.nextLine();
        if (answer.toUpperCase(Locale.ROOT).equals("Y")){
            fee = getCost()*0.1;
        }else{
            fee = 0 ;
        }

        if(account instanceof Individual){
            return (getCost()+fee + getCost()*((Individual) account).getProfit());
        }else{
           return (getCost()+ fee + getCost()*((Enterprise) account).getProfit());
        }
    }
}
