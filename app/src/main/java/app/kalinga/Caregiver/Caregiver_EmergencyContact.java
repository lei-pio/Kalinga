package app.kalinga.Caregiver;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import app.kalinga.R;

public class Caregiver_EmergencyContact extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caregiver_emergencycontact_home);

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
