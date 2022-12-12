package app.kalinga;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import app.kalinga.Patient.PatientHome;

public class PaymentFull extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_full);

        TextView contract = findViewById(R.id.contract_full);
        contract.setOnClickListener(x -> contract());

        Button hire = findViewById(R.id.full_hire);
        hire.setOnClickListener(x -> hire());

    }

    public void contract() {
        Intent intent = new Intent(this, Contract.class);
        startActivity(intent);
    }

    public void hire() {
        Intent intent = new Intent(this, PaymentFull.class);
        startActivity(intent);
    }
}
