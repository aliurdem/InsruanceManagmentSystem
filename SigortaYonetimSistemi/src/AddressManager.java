import java.util.Scanner;

public class AddressManager {
    public void addAddress(IAddress address ,User user){
        user.getAddressList().add(address);
    }
    public void addAddress(User user){
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------");
        System.out.println("1 - Ev Adersi\n"+
                "2 - İş Adresi");
        System.out.println("------------------------");
        System.out.print("Adres tipi seçiniz : ");
        int chooice = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Sokak adı : ");
        String streetName = scanner.nextLine();
        System.out.print("Bina no : ");
        String buildingNumber = scanner.nextLine();
        System.out.print("Şehir : ");
        String cityName = scanner.nextLine();
        System.out.print("Ülke : ");
        String countryName = scanner.nextLine();
        System.out.print("Posta kodu : ");
        String postCode = scanner.nextLine();

        switch (chooice){
            case 1 :
                IAddress address = new HomeAddress(streetName,buildingNumber,cityName,countryName,postCode);
                user.getAddressList().add(address);
                break;
            case 2 :
                System.out.print("Şirket : ");
                String companyName = scanner.nextLine();
                IAddress address1 = new BusinessAddress(streetName,buildingNumber,cityName,countryName,postCode,companyName);
                user.getAddressList().add(address1);
                break;
        }
    }



    public void deleteAddress(Integer no ,User user){
        user.getAddressList().remove(no-1);
    }
    public void deleteAddress(User user){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Silmek istediğiniz adresin numarasını giriniz : ");
        int no = scanner.nextInt();

        user.getAddressList().remove(no-1);
    }
}
