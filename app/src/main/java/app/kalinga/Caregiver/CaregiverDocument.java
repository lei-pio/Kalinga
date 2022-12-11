package app.kalinga.Caregiver;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import app.kalinga.R;

public class CaregiverDocument extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caregiver_document);

        ImageView btr = findViewById(R.id.blood_test_icon);
        btr.setOnClickListener(x -> see_result());

        TextView btr2 = findViewById(R.id.blood_test_text);
        btr2.setOnClickListener(x -> see_result());

        Button back = findViewById(R.id.caregiver_document_back);
        back.setOnClickListener(x -> back());

    }

    private void back() {
        Intent intent = new Intent(this, CaregiverHome.class);
        startActivity(intent);
    }

    private void see_result() {
        Intent intent = new Intent(this, Report.class);
        startActivity(intent);
    }
}
