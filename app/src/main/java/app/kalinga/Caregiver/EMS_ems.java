package app.kalinga.Caregiver;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import app.kalinga.R;

public class EMS_ems  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.em_ems);

        Button logIn = findViewById(R.id.ems_back);
        logIn.setOnClickListener(x -> goBackToWelcome());

        TextView ems_smart = findViewById(R.id.ems_smart);
        ems_smart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                callIntent.setData(Uri.parse("tel://09981885246"));
                startActivity(callIntent);
            }
        });

        TextView ems_globe = findViewById(R.id.ems_globe);
        ems_globe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                callIntent.setData(Uri.parse("tel://09055551911"));
                startActivity(callIntent);
            }
        });

        TextView telephone_one = findViewById(R.id.telephone_one);
        telephone_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                callIntent.setData(Uri.parse("tel://4437089"));
                startActivity(callIntent);
            }
        });

        TextView telephone_two = findViewById(R.id.telephone_two);
        telephone_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                callIntent.setData(Uri.parse("tel://4421901"));
                startActivity(callIntent);
            }
        });

        //
    }

    public void goBackToWelcome() {
        Intent intent = new Intent(this, CaregiverHome.class);
        startActivity(intent);
    }
}
