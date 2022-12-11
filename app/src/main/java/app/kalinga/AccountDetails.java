package app.kalinga;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AccountDetails extends Account {

    String firstName;
    String middleName;
    String lastName;
    String contactNumber;
    String email;
    String userType;
    String address;
    Context context;


    public AccountDetails(Context cont) {
        context = cont;
    }


    public AccountDetails(String username, String password, String firstName, String middleName,
                          String lastName, String contactNumber, String email, String address,String userType) {
        super(username,password);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.userType = userType;
    }


    public void setContext(Context context) {
        this.context = context;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return  username + ',' +
                password + ',' +
                firstName + ',' +
                middleName + ',' +
                lastName + ',' +
                contactNumber + ',' +
                email;
    }
}
