package app.kalinga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import app.kalinga.Caregiver.CaregiverHome;
import app.kalinga.Patient.PatientHome;
import app.kalinga.Patient.PatientMenu;

public class Register_LogIn extends AppCompatActivity {
    static ArrayList<AccountDetails> accounts;
    static String filename;
    static AccountDetails currentAccount;
    EditText password;
    EditText username;
    Button logIn;
    Button signUp;
    TextView samp;
    String test = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_register_login);
        password = (EditText) findViewById(R.id.login_password);
        username = (EditText) findViewById(R.id.login_username);
        System.out.println(password.getText());

        filename = "userAccounts.txt";
        accounts = new ArrayList<>();
        currentAccount = null;
        readLine(filename);

        TextView status = findViewById(R.id.status);
        logIn = findViewById(R.id.log_in_button);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char res = logInOrLogOut(username.getText().toString(),  password.getText().toString());
                if (res == 'p') {
                    status.setText("");
                    logIn.setOnClickListener(x -> openHomeView("p"));
                } else if (res == 'c') {
                    logIn.setOnClickListener(x -> openHomeView("c"));
                } else {
                    status.setText("Invalid credentials. Try again");
                }
            }
        });


        signUp = findViewById(R.id.sign_up);
        signUp.setOnClickListener(v -> openSignUpView());
    }

    public void save(String FILE_NAME, String content) {
        try{
            File gpxfile = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), FILE_NAME);
            FileOutputStream fos = new FileOutputStream(gpxfile);
            fos.write(content.getBytes());
            fos.close();

        }catch (Exception e){

        }
    }

    public void readLine(String path) {
        ArrayList<AccountDetails> mLines = new ArrayList<>();

        AssetManager am = this.getAssets();

        try {
            InputStream is = am.open(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String address = data[7] + " " +  data[8] + " " + data[9] + " " + data[10];
                AccountDetails newAcc = new AccountDetails(data[0], data[1], data[2], data[3], data[4], data[5], data[6], address, data[11]);
                accounts.add(newAcc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void openSignUpView() {
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }

    public void openHomeView(String userTYpe) {
        if (userTYpe.equalsIgnoreCase("c")) {
            Intent intent = new Intent(this, CaregiverHome.class);
            startActivity(intent);
        }
        else if (userTYpe.equalsIgnoreCase("p")) {
            Intent intent = new Intent(this, PatientHome.class);
            startActivity(intent);
        }
    }





    public static void addAccount(AccountDetails newAcc) {
        accounts.add(newAcc);
    }

    public static boolean editAccountDetails(String username, AccountDetails modified) {
        int index = 0;
        for (AccountDetails acc : accounts) {
            if (acc.getUsername().equals(username)) {
                accounts.set(index, modified); // update account in list
                return true;
            }
            index++;
        }
        return false;
    }

    public char logInOrLogOut(String username, String password) {
        for (AccountDetails acc : accounts) {
            if (acc.getUsername().equals(username) && acc.getPassword().equals(password)) {
                if (acc.getUserType().equals("caregiver")) {
                    return 'c';
                } else if (acc.getUserType().equals("patient")) {
                    return 'p';
                }
            }
        }
        return 'x';
    }
}