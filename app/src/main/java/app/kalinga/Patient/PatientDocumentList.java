package app.kalinga.Patient;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import app.kalinga.R;

public class PatientDocumentList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_documents);

        Button back = findViewById(R.id.patient_docs_back);
        back.setOnClickListener(x -> back());
    }

    public void back() {
        Intent intent = new Intent(this, PatientDocumentHome.class);
        startActivity(intent);
    }
}
