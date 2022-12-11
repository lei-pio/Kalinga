package app.kalinga.Caregiver;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import app.kalinga.R;

public class EMS_911 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ems_911bakakengbaguio);

        Button logIn = findViewById(R.id.nineoneone_back);
        logIn.setOnClickListener(x -> goBackToWelcome());

        Button callButton = findViewById(R.id.contact_911);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                callIntent.setData(Uri.parse("tel://0744435678"));
                startActivity(callIntent);
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:0744435678"));
            }
        });
    }

    public void goBackToWelcome() {
        Intent intent = new Intent(this, CaregiverHome.class);
        startActivity(intent);
    }
}

