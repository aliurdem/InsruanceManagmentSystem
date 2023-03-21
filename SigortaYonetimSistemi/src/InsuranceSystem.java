import java.util.*;

public class InsuranceSystem {
    private AccountManager accountManager;
    private AddressManager addressManager;
    private TreeMap<Integer,Insurance> insurances = new TreeMap();

    public InsuranceSystem(AccountManager accountManager,AddressManager addressManager) {
        this.accountManager = accountManager;
        this.addressManager = addressManager;
        insurances.put(1,new HealthInsurance(5000));
        insurances.put(2,new CarInsurance(5000));
        insurances.put(3 , new TravelInsurance(5000));
        insurances.put(4,new ResidenceInsurance(5000));
    }

    public void welcomeScreen(){
        while (true){
            try {
                Account ac =  accountManager.login();
                menu(ac);
                return;
            }catch (InvalidAuthenticationException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    public void menu(Account account){
       while(account.getAu() == AuthenticationStatus.SUCCESS){
           System.out.print("--------------------------------"+
                           "\n1-Kullanıcı bilgileri görüntüle" +
                            "\n2-Adres Listesi" +
                           "\n3-Sigorta listesini görüntüle" +
                           "\n4-Sigorta Poliçesi ekle" +
                           "\n5-Sigorta poliçesi kaldır" +
                           "\n6- Çıkış"+
                            "\n-------------------------------"+
                           "\nYapmak istediğini işlemi seçiniz : "
           );


           Scanner scanner = new Scanner(System.in);
           int chooice = scanner.nextInt();

           switch (chooice){
               case 1 :
                   account.getUser().showInfo();
                   break;
               case 2 :
                   account.getUser().listAdress();
                   addressOperataions(account.getUser());
               case 3 :
                   account.printInsuranceList();
                   break;
               case 4 :
                   insuranceMenu(account);
                   break;
               case 5 :
                   deleteInsurance(account);
                   break;
               case 6 :
                   account.setAu(AuthenticationStatus.FAIL);
                   break;
               default:
                   System.out.println("Geçersiz seçenek");

           }
       }

    }
    public void insuranceMenu(Account account){
        listInsurances();
        System.out.print("1-Sigorta hesaplatma"+
                "\n2-Çıkış"+
                "\nYapmak istediğiniz işlemi seçiniz : ");
    Scanner scanner = new Scanner(System.in);
    int chooice = scanner.nextInt();
    switch (chooice){
        case 1 :
            System.out.print("Hesaplatmak istediğiniz Sigortanın id sini giriniz : ");
            int insId = scanner.nextInt();
            calculateInsurance(insurances.get(insId), account);
        case 2 :
            break;
        default:
            System.out.println("Geçersiz bir işlem seçtiniz");

        }
    }
    public void listInsurances(){
        System.out.format("-----------------------------------------------------------------%n");
        System.out.format("| %-5s | %-25s | %-25s |%n","ID","İsim","Taban Fiyat");
        System.out.format("-----------------------------------------------------------------%n");

        for(Insurance ins : insurances.values()) {
            System.out.format("| %-5s | %-25s | %-25s |%n", ins.getId(), ins.getName(),ins.getCost()+" TL");
            System.out.format("-----------------------------------------------------------------%n");
        }
    }
    public void calculateInsurance(Insurance ins, Account account){
        Scanner scanner = new Scanner(System.in);
        double cost = ins.calculate(account);
        System.out.println("Size özel "+ins.getName()+ "Fiyatınız : " + cost+
                " Satın almak ister misiz ? Y/N");
        String chooice = scanner.nextLine();

        if(chooice.toUpperCase(Locale.ROOT).equals("Y")){
            switch (ins.getId()){
                case 1 :
                    ins  = new HealthInsurance(cost);
                    buyInsurance(ins,account);
                    break;
                case 2 :
                    ins = new CarInsurance(cost);
                    buyInsurance(ins,account);
                    break;
                case 3 :
                    ins = new TravelInsurance(cost);
                    buyInsurance(ins,account);
                    break;
                case 4 :
                    ins = new ResidenceInsurance(cost);
                    buyInsurance(ins,account);
                    break;
            }
        }

    }

    public void buyInsurance(Insurance ins,Account account){
        if(account.getInsuranceList().containsKey(ins.getId())){
            System.out.println(ins.getName() + " Zaten mevcut !");
        }else{
            account.getInsuranceList().put(ins.getId(), ins);
            System.out.println(ins.getName() + " Satın alındı !");
        }
    }

    public void deleteInsurance(Account account){
        if(account.getInsuranceList().size() != 0 ){
            System.out.format("---------------------------------------------------------------------------------------------%n");
            System.out.format("| %-5s | %-25s | %-25s | %-25s |%n","ID","İsim","Başlangış Tarihi","Bitiş Tarihi");
            System.out.format("---------------------------------------------------------------------------------------------%n");

            for(Insurance ins : account.getInsuranceList().values()){
                System.out.format("| %-5s | %-25s | %-25s | %-25s |%n", ins.getId(), ins.getName(),ins.getStartDate(),ins.getEndDate());
                System.out.format("---------------------------------------------------------------------------------------------%n");
            }
            Scanner scanner = new Scanner(System.in);
            System.out.print("Kaldırmak istediğiniz sigortanın id sini giriniz : ");
            int insId = scanner.nextInt();
            account.getInsuranceList().remove(insId);
        }else{
            System.out.println("Sigortanız bulunmamaktadır");
        }
    }
    public void listAddress(User user){
        Scanner scanner = new Scanner(System.in);
        user.listAdress();
        while (true){
            System.out.print("1 - Düzenle\n" +
                    "2 - Çıkış\n" +
                    "Yapmak istediğiniz işlemi seçiniz : ");
            int chooice = scanner.nextInt();
            if(chooice == 1 ){
                addressOperataions(user);
            }else{
                return;
            }
        }
    }

    public void addressOperataions(User user){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("---------------------------------------");
            System.out.println("1 - Adres ekle\n" +
                    "2 - Adres Çıkar\n" +
                    "3 - Çıkış");
            System.out.println("---------------------------------------");
            System.out.print("Yapmak istediğiniz işlemi seçin : ");
            int chooice = scanner.nextInt();

            switch (chooice){
                case  1 :
                    addressManager.addAddress(user);
                    break;
                case 2  :
                    if(user.getAddressList().size() != 0){addressManager.deleteAddress(user);}
                    else{
                        System.out.println("-----------------------------------------");
                        System.out.println("Kayıtlı adresiniz bulunmamakta ! ");
                        System.out.println("-----------------------------------------");
                    }
                    break;
                case 3 :
                    return;
                default:
                    System.out.println("Geçersiz seçenek ! ");
            }
            user.listAdress();
        }
    }
}
