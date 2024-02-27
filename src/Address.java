public class Address {
    private String house;
    private String street;
    private String city;
    private String state;
    private String zip;
    public Address(String house, String street,String city,String state, String zip){
        this.house = house;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
    public Address(Address address){
        house = address.house;
        street = address.street;
        city = address.city;
        state = address.state;
        zip = address.zip;
    }
    public Address(String address){
        house = address.substring(0, address.indexOf(" "));
        address = address.substring(address.indexOf(" " )+ 1);
        street  = address.substring(0, address.indexOf(","));
        address  = address.substring(address.indexOf(",") + 2);
        city  = address.substring(0, address.indexOf(","));
        address  = address.substring(address.indexOf(",")+2);
        state = address.substring(0, address.indexOf(" "));
        address = address.substring(address.indexOf(" ")+1);
        zip = address;
    }
    public String toString(){
        return house  + " " + street + ", " + city + ", " + state + " " + zip;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
