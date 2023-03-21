import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeSet;

public class AccountManager {
    TreeSet<Account> accounts = new TreeSet<>(new Comparator<Account>() {
        @Override
        public int compare(Account o1, Account o2) {
            return o1.getUser().getEmail().compareTo(o2.getUser().getEmail());
        }
    });

    public Account login() throws InvalidAuthenticationException{
        Scanner scanner = new Scanner(System.in);
        boolean logged = false;
        Account account = null;

        System.out.print("E-mail giriniz : ");
        String email = scanner.nextLine();
        System.out.print("Şifre giriniz : ");
        String password = scanner.nextLine();

        for(Account ac : accounts){
            if(ac.getUser().getEmail().equals(email) && ac.getUser().getPassword().equals(password)){
                account = ac;
                account.setAu(AuthenticationStatus.SUCCESS);
                logged = true;
            }
        }
        if(!logged){
            throw new InvalidAuthenticationException("Kullanıcı adı veya şifre hatalı");
        }else{
            return account;
        }

    }
    public void addAccount(Account account){
        if(accounts.add(account)){
            System.out.println("Hesap eklendi");
        }else{
            System.out.println("Bu hesap zaten mevcut");
        }
    }



}
