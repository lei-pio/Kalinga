package app.kalinga.Patient;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import app.kalinga.R;
import app.kalinga.Register_LogIn;

public class PatientMenu extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.patient_menu);

            Button home = findViewById(R.id.patient_home);
            home.setOnClickListener(x -> home());


            Button emergency = findViewById(R.id.patient_emergency);
            emergency.setOnClickListener(x -> emergency());


            Button documents = findViewById(R.id.patient_documents);
            documents.setOnClickListener(x -> documents());



            Button profile = findViewById(R.id.patient_profile);
            profile.setOnClickListener(x -> profile());



            Button logout = findViewById(R.id.patient_logout);
            logout.setOnClickListener(x -> logout());

    }

    private void home() {
        Intent intent = new Intent(this, PatientHome.class);
        startActivity(intent);
    }

    private void profile() {
        Intent intent = new Intent(this, PatientProfile.class);
        startActivity(intent);
    }



    private void emergency() {
        Intent intent = new Intent(this, Patient_EmergencyContact.class);
        startActivity(intent);
    }


    private void logout() {
        Intent intent = new Intent(this, Register_LogIn.class);
        startActivity(intent);
    }


    private void documents() {
        Intent intent = new Intent(this, PatientDocumentHome.class);
        startActivity(intent);
    }
}