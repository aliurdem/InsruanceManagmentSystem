public class Main {
    public static void main(String[] args) {
        User user1 = new User("Ali","Ürdem","aliurdem@gmail.com","1234","Software Developer",21);

        Individual account1 = new Individual(user1);

        AccountManager accountManager = new AccountManager();
        AddressManager addressManager = new AddressManager();

        accountManager.addAccount(account1);

        InsuranceSystem ins = new InsuranceSystem(accountManager,addressManager);
        ins.welcomeScreen();


    }
}