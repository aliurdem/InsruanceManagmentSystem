import java.util.ArrayList;
import java.util.TreeMap;

public abstract class Account {
    private User user;
    private TreeMap<Integer,Insurance> insuranceList;
    private AuthenticationStatus au;


    public Account(User user) {
        this.user = user;
        this.insuranceList = new TreeMap<>();
        this.au = AuthenticationStatus.FAIL;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TreeMap<Integer, Insurance> getInsuranceList() {
        return insuranceList;
    }

    public void setInsuranceList(TreeMap<Integer, Insurance> insuranceList) {
        this.insuranceList = insuranceList;
    }

    public AuthenticationStatus getAu() {
        return au;
    }

    public void setAu(AuthenticationStatus au) {
        this.au = au;
    }
    public boolean login(String password) throws InvalidAuthenticationException{
        if(this.user.getPassword().equals(password)){
            this.au = AuthenticationStatus.SUCCESS;
            return true;
        }else{
            this.au = AuthenticationStatus.FAIL;
            throw new InvalidAuthenticationException("Kullanıcı adı veya şifre hatalı");
        }
    }
    public void printInsuranceList(){
        if(insuranceList.size() != 0 ){
            System.out.format("-------------------------------------------------------------------------------------------------------%n");
            System.out.format("| %-5s | %-25s | %-25s | %-25s | %-25s |%n","ID","İsim","Başlangış Tarihi","Bitiş Tarihi","Maliyet");
            System.out.format("-------------------------------------------------------------------------------------------------------%n");

            for(Insurance ins : insuranceList.values()){
                System.out.format("| %-5s | %-25s | %-25s | %-25s | %-25s |%n", ins.getId(), ins.getName(),ins.getStartDate(),ins.getEndDate(),ins.getCost()+" TL");
                System.out.format("-------------------------------------------------------------------------------------------------------%n");
            }
        }else{
            System.out.println("Sigortanız bulunmamaktadır !");
        }
    }
    public void addInsurance(Insurance insurance){

    }
}
