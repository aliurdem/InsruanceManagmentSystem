import java.time.LocalDate;
import java.util.ArrayList;

public class User {
    private String name;
    private String surName;
    private String email;
    private String password;
    private String job;
    private int age;
    private ArrayList<IAddress> addressList;
    private LocalDate lastLogin;

    public User(String name, String surName, String email, String password, String job, int age) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.password = password;
        this.job = job;
        this.age = age;
        this.addressList = new ArrayList<>();
        this.lastLogin = LocalDate.ofEpochDay(0000-00-00);
    }
    public void showInfo(){
        System.out.format("-----------------------------------------------------------------%n");
        System.out.format("| %-25s | %-25s | %-5s |%n","İsim","Meslek","Yaş");
        System.out.format("-----------------------------------------------------------------%n");
        System.out.format("| %-25s | %-25s | %-5s |%n",name+" "+surName,job,age);
        System.out.format("-----------------------------------------------------------------%n");
    }
    public void listAdress(){
        if(addressList.size() != 0 ){
            int no = 1;
            System.out.println("Adres listesi");
            System.out.format("-------------------------------------------------------------------------------------%n");

            System.out.format("| %-5s | %-25s | %-45s |%n","No","Adres tipi","Adres");
            for(IAddress address : addressList){
                System.out.format("-------------------------------------------------------------------------------------%n");
                System.out.format("| %-5s | %-25s | %-45s |%n",no,address.getAddressType(),address.showAddress());
                no++;
            }
            System.out.format("-------------------------------------------------------------------------------------%n");
        }else{
            System.out.println("---------------------------------------");
            System.out.println("Kayıtlı adresiniz bulunmamakta !");
            System.out.println("---------------------------------------");
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<IAddress> getAddressList() {
        return addressList;
    }

    public void setAddressList(ArrayList<IAddress> addressList) {
        this.addressList = addressList;
    }

    public LocalDate getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
    }
}
