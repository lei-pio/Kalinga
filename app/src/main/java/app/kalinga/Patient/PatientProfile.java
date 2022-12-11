package app.kalinga.Patient;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import app.kalinga.AccountDetails;
import app.kalinga.Caregiver.CaregiverHome;
import app.kalinga.R;

public class PatientProfile extends AppCompatActivity {
    EditText fName;
    EditText mName;
    EditText lName;
    EditText cNumber;
    EditText email;
    EditText address;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_profile);

        fName = findViewById(R.id.caregiver_firstname);
        mName = findViewById(R.id.caregiver_middlename);
        lName = findViewById(R.id.caregiver_lastname);
        cNumber = findViewById(R.id.caregiver_contactnumber);
        email = findViewById(R.id.caregiver_email);
        address = findViewById(R.id.caregiver_address);
        username = findViewById(R.id.caregiver_username);
        password = findViewById(R.id.caregiver_password);

        readData("currentUser.txt");

        Button editFields = findViewById(R.id.editDetails);
        editFields.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editFields.getHint().toString().equals("EDIT")) {
                    editFields.setHint("SAVE");
                    setFieldsEditable();
                } else if (editFields.getHint().toString().equals("SAVE")) {
                    editFields.setHint("EDIT");
                    setFieldsNotEditable();
                }
            }
        });

        Button logIn = findViewById(R.id.profile_back);
        logIn.setOnClickListener(x -> goBackToWelcome());
    }

    public void goBackToWelcome() {
        Intent intent = new Intent(this, PatientHome.class);
        startActivity(intent);
    }

    public void readData(String path) {
        ArrayList<AccountDetails> mLines = new ArrayList<>();

        AssetManager am = this.getAssets();

        try {
            InputStream is = am.open(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[11].equals("patient")) {
                    String address = data[7] + " " +  data[8] + " " + data[9] + " " + data[10];
                    AccountDetails newAcc = new AccountDetails(data[0], data[1], data[2], data[3], data[4], data[5], data[6], address,data[11]);
                    loadData(newAcc);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFieldsEditable() {
        fName.setEnabled(true);
        mName.setEnabled(true);
        lName.setEnabled(true);
        cNumber.setEnabled(true);
        address.setEnabled(true);
        username.setEnabled(true);
        email.setEnabled(true);
    }


    public void setFieldsNotEditable() {
        fName.setEnabled(false);
        fName.setSelection(0);
        mName.setEnabled(false);
        lName.setEnabled(false);
        cNumber.setEnabled(false);
        address.setEnabled(false);
        username.setEnabled(false);
        email.setEnabled(false);
    }

    public void loadData(AccountDetails acc) {
        fName.setText(acc.getFirstName());
        mName.setText(acc.getMiddleName());
        lName.setText(acc.getLastName());
        cNumber.setText(acc.getContactNumber());
        address.setText(acc.getAddress());
        username.setText(acc.getUsername());
        password.setText(acc.getPassword());
        email.setText(acc.getEmail());
    }
}
