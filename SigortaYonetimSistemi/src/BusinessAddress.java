public class BusinessAddress implements IAddress{
    private String streetName;
    private String buildingNumber;
    private String cityName;
    private String countryName;
    public String postCode;
    private String companyName;
    private String addressType;


    public BusinessAddress(String streetName, String buildingNumber, String cityName, String countryName, String postCode, String companyName) {
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.cityName = cityName;
        this.countryName = countryName;
        this.postCode = postCode;
        this.companyName = companyName;
        this.addressType = "İş Adresi";
    }

    @Override
    public String showAddress() {
        return companyName+" "+streetName+"/"+"no "+buildingNumber+"/"+postCode+" "+cityName+"/"+countryName;

    }

    @Override
    public String getAddressType() {
        return this.addressType;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
