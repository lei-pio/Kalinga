package app.kalinga;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import app.kalinga.Patient.PatientHome;

public class PaymentPart extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_part);

        EditText reqHrs = findViewById(R.id.required_hours);

        Button calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sTextFromET = reqHrs.getText().toString();
                int nIntFromET = Integer.parseInt(sTextFromET);
                int amount = nIntFromET * 90;
                TextView amntToPay = findViewById(R.id.amount_to_pay);
                amntToPay.setText(String.valueOf(amount));
            }
        });

        Button hire = findViewById(R.id.part_hire);
        hire.setOnClickListener(x -> hire());
    }


    public void hire() {
        Intent intent = new Intent(this, PatientHome.class);
        startActivity(intent);
    }
}
