package sample;

public class Address {
    int houseNo, postalZipCode;
    String roadName;
    String district;

    public Address() {}

    public Address(int houseNo, int postalZipCode, String roadName, String district) {
        this.houseNo = houseNo;
        this.postalZipCode = postalZipCode;
        this.roadName = roadName;
        this.district = district;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public int getPostalZipCode() {
        return postalZipCode;
    }

    public void setPostalZipCode(int postalZipCode) {
        this.postalZipCode = postalZipCode;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
