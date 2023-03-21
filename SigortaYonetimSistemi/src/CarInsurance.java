import java.util.Scanner;

public class CarInsurance extends Insurance{
    public CarInsurance(double cost) {
        super(2,"Araba sigortası",cost);
    }

    @Override
    public double calculate(Account account) {
        Scanner scanner = new Scanner(System.in);
        double carAge;
        double carPrise;
        double fee;

        System.out.print("Araç Yaşını Giriniz : ");
        carAge = scanner.nextDouble();
        System.out.print("Aracınızın Fiyatını Giriniz : ");
        carPrise = scanner.nextDouble();
        fee = (carPrise / carAge) * 0.2;

        if(account instanceof Individual){
            return (getCost()+fee + getCost()*((Individual) account).getProfit());
        }else{
            return (getCost()+ fee + getCost()*((Enterprise) account).getProfit());
        }
    }
}
