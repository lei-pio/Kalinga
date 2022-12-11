package app.kalinga.Caregiver;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import app.kalinga.Patient.PatientInformation;
import app.kalinga.R;

public class CaregiverAppointment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caregiver_appointment);

        Button logIn = findViewById(R.id.appointment_back);
        logIn.setOnClickListener(x -> goBackToHome());

        TextView see_more = findViewById(R.id.see_more);
        see_more.setOnClickListener(x -> viewInfo());

        LinearLayout documents = findViewById(R.id.appointment_document);
        documents.setOnClickListener(x -> viewDocuments());

        LinearLayout prescriptions = findViewById(R.id.appointment_prescription);
        prescriptions.setOnClickListener(x -> viewPrescriptions());


        Button timein = findViewById(R.id.timein_button);
        Button timeout = findViewById(R.id.timeout_button);

        timein.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                DateFormat dtf = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
                String time = dtf.format(new Date()).toString();
                TextView timeintext = findViewById(R.id.timein_text);
                timeintext.setText(time);
                timeout.setEnabled(true);
            }
        });


        timeout.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                DateFormat dtf = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
                String time = dtf.format(new Date()).toString();
                TextView timeouttext = findViewById(R.id.timeout_text);
                timeouttext.setText(time);
            }
        });
    }

    public void viewDocuments() {
        Intent intent = new Intent(this, CaregiverDocument.class);
        startActivity(intent);
    }

    public void viewPrescriptions() {
        Intent intent = new Intent(this, Prescription.class);
        startActivity(intent);
    }

    public void goBackToHome() {
        Intent intent = new Intent(this, CaregiverHome.class);
        startActivity(intent);
    }

    public void viewInfo() {
        Intent intent = new Intent(this, PatientInformation.class);
        startActivity(intent);
    }
}
