package app.kalinga.Caregiver;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import app.kalinga.AccountDetails;
import app.kalinga.R;
import app.kalinga.Register_LogIn;


public class CaregiverHome extends AppCompatActivity{

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caregiver_home);

        LinearLayout appointment = findViewById(R.id.appoitmentsButton);
        appointment.setOnClickListener(v -> appointments());

        LinearLayout profile = findViewById(R.id.profileButton);
        profile.setOnClickListener(v -> profile());

        LinearLayout documents = findViewById(R.id.documentsButtons);
        documents.setOnClickListener(v -> documents());

        Button logout = findViewById(R.id.logoutButton);
        logout.setOnClickListener(v -> logout());


        LinearLayout emergency = findViewById(R.id.deliveryButtons);
        emergency.setOnClickListener(v -> emergency());

        TextView welcomeMessage = findViewById(R.id.welcomeMessage);

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        DateFormat dtf = new SimpleDateFormat("dd, yyyy");
        String time = dtf.format(new Date()).toString();
        YearMonth month = YearMonth.from(LocalDate.now());
        String dayToday = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime()) + "," +
                month.getMonth().name()+ " " +time;

        String userName = readData("currentUser.txt");

        // WELCOME TO KALINGA! GREETINGS,  JUAN SAN CARLOS. HAVE A GREAT DAY. MONDAY, AUGUST 29, 2022
        String greetins = "WELCOME TO KALINGA! " + userName.toUpperCase() + ". HAVE A GREAT DAY. " +
                dayToday.toUpperCase();

        welcomeMessage.setText(greetins);

        // WELCOME TO KALINGA! GREETINGS,  JUAN SAN CARLOS. HAVE A GREAT DAY. MONDAY, AUGUST 29, 2022
    }

    public String readData(String path) {
        ArrayList<AccountDetails> mLines = new ArrayList<>();

        AssetManager am = this.getAssets();

        try {
            InputStream is = am.open(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[11].equals("caregiver")) {
                    return data[2] + " " + data[3] + " " +  data[4];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private void emergency() {
        Intent intent = new Intent(this, Caregiver_EmergencyContact.class);
        startActivity(intent);
    }

    private void prescription() {
        Intent intent = new Intent(this, Prescription.class);
        startActivity(intent);
    }

    private void home() {
        Intent intent = new Intent(this, CaregiverHome.class);
        startActivity(intent);
    }

    private void appointments() {
        Intent intent = new Intent(this, CaregiverAppointment.class);
        startActivity(intent);
    }


    private void chats() {
        Intent intent = new Intent(this, CaregiverHome.class);
        startActivity(intent);
    }


    private void documents() {
        Intent intent = new Intent(this, CaregiverDocument.class);
        startActivity(intent);
    }


    private void profile() {
        Intent intent = new Intent(this, Caregiver_Profile.class);
        startActivity(intent);
    }

    private void logout() {
        Intent intent = new Intent(this, Register_LogIn.class);
        startActivity(intent);
    }
}
