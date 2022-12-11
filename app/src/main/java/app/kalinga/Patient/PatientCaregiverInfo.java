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
import app.kalinga.R;

public class PatientCaregiverInfo extends AppCompatActivity {

    EditText fullName;
    EditText cNumber;
    EditText email;
    EditText address;
    Button hire;
    Button pat_careinf_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_caregiverinfo);

        fullName = findViewById(R.id.patient_careinf_fullname);
        cNumber = findViewById(R.id.patient_careinf_contactnumber);
        email = findViewById(R.id.patient_careinf_email);
        address = findViewById(R.id.patient_careinf_address);
        pat_careinf_back = findViewById(R.id.pat_careinf_back);
        pat_careinf_back.setOnClickListener(x -> goBackToWelcome());
        hire = findViewById(R.id.patient_hire);
        hire.setOnClickListener(x -> hire());

        readData("currentUser.txt");
    }

    public void goBackToWelcome() {
        Intent intent = new Intent(this, PatientHome.class);
        startActivity(intent);
    }

    public void hire() {
        Intent intent = new Intent(this, PatientInformation.class);
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
                if (data[11].equals("caregiver")) {
                    String address = data[7] + " " +  data[8] + " " + data[9] + " " + data[10];
                    AccountDetails newAcc = new AccountDetails(data[0], data[1], data[2], data[3], data[4], data[5], data[6], address,data[11]);
                    loadData(newAcc);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void loadData(AccountDetails acc) {
        fullName.setText(acc.getFirstName() + " " + acc.getMiddleName() + " " + acc.getLastName());
        cNumber.setText(acc.getContactNumber());
        address.setText(acc.getAddress());
        email.setText(acc.getEmail());
    }
}
