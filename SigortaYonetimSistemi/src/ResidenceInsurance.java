import java.util.Scanner;

public class ResidenceInsurance extends Insurance{
    public ResidenceInsurance(double cost) {
        super(4, "Konut Sigortası", cost);
    }

    @Override
    public double calculate(Account account) {
        Scanner scanner = new Scanner(System.in);
        double fee;
        int houseAge;
        System.out.print("Evinizin yaşını giriniz : ");
        houseAge = scanner.nextInt();
        fee = (houseAge / getCost()) * 1000;

        if(account instanceof Individual){
            return (getCost()+fee + getCost()*((Individual) account).getProfit());
        }else{
            return (getCost()+ fee + getCost()*((Enterprise) account).getProfit());
        }
    }
}
