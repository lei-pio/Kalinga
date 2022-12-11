package app.kalinga.Patient;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import app.kalinga.AccountDetails;
import app.kalinga.Caregiver.CaregiverHome;
import app.kalinga.PrivacyPolicy;
import app.kalinga.R;
import app.kalinga.TermsConditioons;

public class PatientInformation extends AppCompatActivity {
    EditText fName;
    EditText mName;
    EditText lName;
    EditText cNumber;
    EditText email;
    EditText patient_patinf_province;
    EditText patient_patinf_city;
    EditText patient_patinf_bar;
    EditText patient_patinf_land;
    EditText patient_patinf_zip;
    Button proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_patientinformation);

        fName = findViewById(R.id.patient_patinf_fname);
        mName = findViewById(R.id.patient_patinf_mname);
        lName = findViewById(R.id.patient_patinf_lname);
        cNumber = findViewById(R.id.patient_patinf_cnumber);
        email = findViewById(R.id.patient_patinf_email);
        proceed = findViewById(R.id.patient_info_proceed);
        proceed.setOnClickListener(x -> proceed());

        TextView terms = findViewById(R.id.patinf_terms_conditions);
        terms.setOnClickListener(x -> openTermsConditions());

        TextView privacy = findViewById(R.id.patinf_privacy_policy);
        privacy.setOnClickListener(x -> openPrivacyPolicy());

        readData("userAccounts.txt");

//        Button editFields = findViewById(R.id.editDetails);
//        editFields.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (editFields.getHint().toString().equals("EDIT")) {
//                    editFields.setHint("SAVE");
//                    setFieldsEditable();
//                } else if (editFields.getHint().toString().equals("SAVE")) {
//                    editFields.setHint("EDIT");
//                    setFieldsNotEditable();
//                }
//            }
//        });
    }

    public void openTermsConditions() {
        Intent intent = new Intent(this, TermsConditioons.class);
        startActivity(intent);
    }

    public void proceed() {
        Intent intent = new Intent(this, PatientDocumentHome.class);
        startActivity(intent);
    }

    public void openPrivacyPolicy() {
        Intent intent = new Intent(this, PrivacyPolicy.class);
        startActivity(intent);
    }

    public void goBackToWelcome() {
        Intent intent = new Intent(this, CaregiverHome.class);
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
        email.setEnabled(true);
    }


    public void setFieldsNotEditable() {
        fName.setEnabled(false);
        fName.setSelection(0);
        mName.setEnabled(false);
        lName.setEnabled(false);
        cNumber.setEnabled(false);
        email.setEnabled(false);
    }

    public void loadData(AccountDetails acc) {
        fName.setText(acc.getFirstName());
        mName.setText(acc.getMiddleName());
        lName.setText(acc.getLastName());
        cNumber.setText(acc.getContactNumber());
        email.setText(acc.getEmail());
    }
}
