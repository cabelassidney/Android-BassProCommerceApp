package com.basspro.bassprocommerce.localstorage;

/**
 * Created by manep on 3/7/2018.
 */

public class RegisterModel {

    String userName;
    String password;
    String dateOfBirth;
    String latsName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLatsName() {
        return latsName;
    }

    public void setLatsName(String latsName) {
        this.latsName = latsName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    String firstName;
    String gender;
}
