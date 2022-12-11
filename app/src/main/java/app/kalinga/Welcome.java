package app.kalinga;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import app.kalinga.Caregiver.CaregiverHome;
import app.kalinga.Caregiver.CaregiverVerification;
import app.kalinga.Patient.PatientHome;
import app.kalinga.Patient.PatientVerification;

public class Welcome  extends AppCompatActivity {
    String userType = "";
    TextView caregiver;
    TextView patient;
    Button homeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_welcome);

        caregiver = findViewById(R.id.welcome_caregiver);
        patient = findViewById(R.id.welcome_patient);
        homeView = findViewById(R.id.welcome_next);

        caregiver.setOnClickListener(x -> changeColor("c"));
        patient.setOnClickListener(x -> changeColor("p"));
    }

    public void openHomeView(char userType) {

        if (userType == 'c') {
            Intent intent = new Intent(this, CaregiverVerification.class);
            startActivity(intent);
        } else if (userType == 'p') {
            Intent intent = new Intent(this, PatientVerification.class);
            startActivity(intent);
        }

    }

    public void changeColor(String key) {
        if (key.equals("c")) {
            LinearLayout layout = findViewById(R.id.c);
            layout.setBackgroundColor(Color.parseColor("#8FD14F"));
            homeView.setOnClickListener(x -> openHomeView('c'));
        } else {
            LinearLayout layout = findViewById(R.id.p);
            layout.setBackgroundColor(Color.parseColor("#8FD14F"));
            homeView.setOnClickListener(x -> openHomeView('p'));
        }
    }
}
