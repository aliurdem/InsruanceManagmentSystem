public class HomeAddress implements IAddress{
    private String streetName;
    private String buildingNumber;
    private String cityName;
    private String countryName;
    public String postCode;
    private String addressType;


    public HomeAddress(String streetName, String buildingNumber, String cityName, String countryName, String postCode) {
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.cityName = cityName;
        this.countryName = countryName;
        this.postCode = postCode;
        this.addressType = "Ev Adresi";
    }


    @Override
    public String showAddress() {
        return streetName+"/"+"no "+buildingNumber+"/"+postCode+" "+cityName+"/"+countryName;
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
    public String getAddressType() {
        return addressType;
    }
}
