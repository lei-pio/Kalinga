package app.kalinga.Patient;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import app.kalinga.PaymentFull;
import app.kalinga.PaymentPart;
import app.kalinga.R;

public class PaymentHome extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_home);

        Button hire_part_time = findViewById(R.id.hire_part_time);
        hire_part_time.setOnClickListener(x -> part());
        Button hire_full_time = findViewById(R.id.hire_full_time);
        hire_full_time.setOnClickListener(x -> full());
    }

    private void full() {
        Intent intent = new Intent(this, PaymentFull.class);
        startActivity(intent);
    }


    private void part() {
        Intent intent = new Intent(this, PaymentPart.class);
        startActivity(intent);
    }
}
