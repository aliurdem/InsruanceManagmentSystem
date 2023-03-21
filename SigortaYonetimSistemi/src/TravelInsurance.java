import java.time.LocalDate;
import java.util.Scanner;

public class TravelInsurance extends Insurance{
    public TravelInsurance(double cost) {
        super(3, "Seyehat sigortası", 5000);
    }

    @Override
    public double calculate(Account account) {
        Scanner scanner = new Scanner(System.in);
        double fee;
        int travelDay;
        System.out.println("Seyahat edeceğiniz gün sayısını giriniz : ");
        travelDay = scanner.nextInt();
        fee  = (travelDay / getCost()) * 100;

        if(account instanceof Individual){
            return (getCost()+fee + getCost()*((Individual) account).getProfit());
        }else{
            return (getCost()+ fee + getCost()*((Enterprise) account).getProfit());
        }
    }

}
