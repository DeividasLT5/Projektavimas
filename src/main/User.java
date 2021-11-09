package main;

public class User{

    private String first_name;
    private String last_name;
    private String number;
    private String email;
    private String address;
    private String password;

    public User(String fname, String lname, String num, String email, String addr, String pass){
        this.first_name = fname;
        this.last_name  = lname;
        this.number     = num;
        this.email      = email;
        this.address    = addr;
        this.password   = pass;
    }

    public User() {
        this.first_name = "";
        this.last_name  = "";
        this.number     = "";
        this.email      = "";
        this.address    = "";
        this.password   = "";
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}