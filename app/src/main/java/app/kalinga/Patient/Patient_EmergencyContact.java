package app.kalinga.Patient;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import app.kalinga.Caregiver.EMS_911;
import app.kalinga.Caregiver.EMS_bcems;
import app.kalinga.Caregiver.EMS_ems;
import app.kalinga.R;

public class Patient_EmergencyContact extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_emergencycontact_home);

        LinearLayout ems = findViewById(R.id.ems);
        ems.setOnClickListener(x -> showEmsContacts());

        LinearLayout nineoneone = findViewById(R.id.nineoneone);
        nineoneone.setOnClickListener(x -> show911Contacts());

        LinearLayout bcems = findViewById(R.id.bcems);
        bcems.setOnClickListener(x -> showBcemsContacts());
    }

    public void showEmsContacts() {
        Intent intent = new Intent(this, EMS_ems.class);
        startActivity(intent);
    }

    public void show911Contacts() {
        Intent intent = new Intent(this, EMS_911.class);
        startActivity(intent);
    }

    public void showBcemsContacts() {
        Intent intent = new Intent(this, EMS_bcems.class);
        startActivity(intent);
    }
}

