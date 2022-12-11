package app.kalinga.Patient;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import app.kalinga.R;

public class PatientDocumentHome extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_document_home);

        LinearLayout viewDoc = findViewById(R.id.patient_view_documents);
        viewDoc.setOnClickListener(x -> viewDoc());

        LinearLayout addoc = findViewById(R.id.patient_add_document);
        addoc.setOnClickListener(x -> addoc());

        LinearLayout prescription = findViewById(R.id.patient_prescription);
        prescription.setOnClickListener(x -> pres());

        Button back = findViewById(R.id.patient_document_home_back);
        back.setOnClickListener(x -> home());


        Button proceed = findViewById(R.id.patient_document_home_proceed);
        proceed.setOnClickListener(x -> proceed());
    }

    private void proceed() {
        Intent intent = new Intent(this, PaymentHome.class);
        startActivity(intent);
    }

    private void viewDoc() {
        Intent intent = new Intent(this, PatientDocumentList.class);
        startActivity(intent);
    }

    private void home() {
        Intent intent = new Intent(this, PatientHome.class);
        startActivity(intent);
    }


    private void addoc() {
        Intent intent = new Intent(this, PatientAddDocument.class);
        startActivity(intent);
    }

    private void pres() {
        Intent intent = new Intent(this, PatientPrescriptionHome.class);
        startActivity(intent);
    }
}
