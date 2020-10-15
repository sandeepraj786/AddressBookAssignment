public class Person {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNum;
    private String city;
    private String state;
    private String zip;



    public Person(String firstName,String lastName,String address,String city,String zip,String phoneNum,String state){
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.city=city;
        this.phoneNum=phoneNum;
        this.state=state;
        this.zip=zip;
    }

    public Person(String s, String s1, String s2, String s3, String zip, String s4) {
    }

    @Override
    public String toString() {
        return " "+firstName+" "+lastName+" "+address+" "+city+" "+phoneNum+" "+state+" "+zip;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastname(String lastName) {
        this.lastName=lastName;
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

    public String  getZipCode() {
        return zip;
    }

    public void setZipcode(String zip) {
        this.zip=zip;
    }

    public String getPhoneNumber() {
        return phoneNum;
    }

    public void setPhoneNumber(String phoneNum) {
        this.phoneNum=phoneNum;
    }

}


