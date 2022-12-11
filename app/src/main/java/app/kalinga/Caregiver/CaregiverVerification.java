package app.kalinga.Caregiver;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import app.kalinga.R;
import app.kalinga.Register_LogIn;
import app.kalinga.Welcome;

public class CaregiverVerification extends AppCompatActivity {

    CheckBox verification_policy;
    ImageView scan_image;
    Boolean isChecked = false;
    EditText filename;
    TextView new_file;
    ImageView x_con;
    Button proceed;
    Button back;
    LinearLayout new_file_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caregiver_verification);

        new_file_layout = findViewById(R.id.new_file_layout);
        new_file = findViewById(R.id.new_file_name_empty);
        x_con = findViewById(R.id.new_file_x_icon);
        filename = findViewById(R.id.verification_filename);
        verification_policy = findViewById(R.id.verification_checkbox);
        proceed = findViewById(R.id.verification_proceed);
        back = findViewById(R.id.verification_back);

        scan_image = findViewById(R.id.verification_scanimage);
        scan_image.setOnClickListener(x -> scan());

        proceed.setOnClickListener(x -> goBackToLogIn());
        back.setOnClickListener(x -> goBackToUserType());
    }

    public void goBackToLogIn() {
        TextView errMsg = findViewById(R.id.verification_errormsg);
        isChecked = verification_policy.isChecked();
        if (isChecked) {
            Intent intent = new Intent(this, Register_LogIn.class);
            startActivity(intent);
        } else {

            errMsg.setVisibility(View.VISIBLE);
        }

    }

    public void goBackToUserType() {
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);
    }

    public void scan() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
        new_file.setVisibility(View.VISIBLE);
        x_con.setVisibility(View.VISIBLE);
        new_file_layout.setVisibility(View.VISIBLE);
        new_file.setText(filename.getText());
        filename.setText("");
    }
}
