package app.kalinga.Patient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import app.kalinga.Caregiver.CaregiverInfo;
import app.kalinga.R;

public class PatientHome extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_home);

        ImageView menus = findViewById(R.id.patient_menu);
        menus.setOnClickListener(x -> menu());

        LinearLayout user = findViewById(R.id.user);
        user.setOnClickListener(x -> info());
    }

    private void menu() {
        Intent intent = new Intent(this, PatientMenu.class);
        startActivity(intent);
    }

    private void info() {
        Intent intent = new Intent(this, PatientCaregiverInfo.class);
        startActivity(intent);
    }


}
