package app.kalinga;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import app.kalinga.Caregiver.CaregiverVerification;

public class CreateAccount extends AppCompatActivity {

    EditText pass;
    EditText rPass;
    TextView status;
    EditText fName;
    EditText mName;
    EditText lName;
    EditText cNumber;
    EditText email;
    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_create_account);

        pass = findViewById(R.id.password);
        rPass = findViewById(R.id.repeat_password);
        status = findViewById(R.id.cAccount_status);
        fName = findViewById(R.id.cAccount_fname);
        mName = findViewById(R.id.cAccount_mname);
        lName = findViewById(R.id.cAccount_lname);
        cNumber = findViewById(R.id.cAccount_cnumber);
        email = findViewById(R.id.cAccount_email);
        cNumber = findViewById(R.id.cAccount_cnumber);
        username = findViewById(R.id.cAccount_email);
        CheckBox policy = findViewById(R.id.policy_checkbox);
        Button proceed = (Button) findViewById(R.id.sign_up);

        TextView terms = findViewById(R.id.terms_conditions);
        terms.setOnClickListener(x -> openTermsConditions());

        TextView privacy = findViewById(R.id.privacy_policy);
        privacy.setOnClickListener(x -> openPrivacyPolicy());



        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean validatePasswordInputs = isPasswordSame(pass.getText().toString(), rPass.getText().toString());

                if (!validatePasswordInputs  && !policy.isChecked()  && fName.getText().toString().equals("") && mName.getText().toString().equals("")
                && lName.getText().toString().equals("") && cNumber.getText().toString().equals("") && email.getText().toString().equals("") && username.getText().toString().equals("")) {
                    status.setText("Please fill out all fields. Passwords must be same");
                } else {
                    proceed.setOnClickListener(x -> chooseUserType());
                }
            }
        });

        TextView t2 = (TextView) findViewById(R.id.log_in);
        t2.setOnClickListener(v -> openLogInView());
    }

    public void openTermsConditions() {
        Intent intent = new Intent(this, TermsConditioons.class);
        startActivity(intent);
    }

    public void openPrivacyPolicy() {
        Intent intent = new Intent(this, PrivacyPolicy.class);
        startActivity(intent);
    }

    public boolean isPasswordSame(String password, String otherPassword) {
        if (password.equals(otherPassword)) {
            return true;
        }
        return false;
    }

    public void openLogInView() {
        Intent intent = new Intent(this, Register_LogIn.class);
        startActivity(intent);
    }

    public void returnToLogin() {
        Intent intent = new Intent(this, Register_LogIn.class);
        startActivity(intent);
    }

    public void chooseUserType() {
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);
    }



}
