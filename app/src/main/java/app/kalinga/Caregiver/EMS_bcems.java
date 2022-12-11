package app.kalinga.Caregiver;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import app.kalinga.R;

public class EMS_bcems extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ems_bcems);

        Button logIn = findViewById(R.id.bcems_back);
        logIn.setOnClickListener(x -> goBackToWelcome());

        TextView bcems_smart= findViewById(R.id.bcems_smart);
        bcems_smart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                callIntent.setData(Uri.parse("tel://09981885246"));
                startActivity(callIntent);
            }
        });

        TextView bcems_globe = findViewById(R.id.bcems_globe);
        bcems_globe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                callIntent.setData(Uri.parse("tel://09055551911"));
                startActivity(callIntent);
            }
        });

        TextView telephone_one = findViewById(R.id.bcems_telephoneone);
        telephone_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                callIntent.setData(Uri.parse("tel://0744421911"));
                startActivity(callIntent);
            }
        });

        TextView telephone_two = findViewById(R.id.bcems_telephonetwo);
        telephone_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                callIntent.setData(Uri.parse("tel://0744468619"));
                startActivity(callIntent);
            }
        });
    }

    public void goBackToWelcome() {
        Intent intent = new Intent(this, CaregiverHome.class);
        startActivity(intent);
    }
}
