package app.kalinga.Patient;

import android.content.Intent;
import android.os.Bundle;
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

public class PatientAddDocument extends AppCompatActivity {
    CheckBox patient_addoc_policy;
    ImageView scan_image;
    Boolean isChecked = false;
    EditText patient_addoc_filename;
    TextView new_file;
    ImageView x_con;
    Button back;
    LinearLayout new_file_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_add_document);

        new_file_layout = findViewById(R.id.patient_addoc_new_file_layout);
        new_file = findViewById(R.id.patient_addoc_new_file_name_empty);
        x_con = findViewById(R.id.patient_addoc_new_file_x_icon);
        patient_addoc_filename = findViewById(R.id.patient_addoc_filename);
        patient_addoc_policy = findViewById(R.id.patient_addoc_checkbox);

        scan_image = findViewById(R.id.patient_addoc__scanimage);
        scan_image.setOnClickListener(x -> scan());

    }

    public void goBackToLogIn() {
        TextView errMsg = findViewById(R.id.verification_errormsg);
        isChecked = patient_addoc_policy.isChecked();
        if (isChecked) {
            Intent intent = new Intent(this, Register_LogIn.class);
            startActivity(intent);
        } else {

            errMsg.setVisibility(View.VISIBLE);
        }

    }

    public void goBackToUserType() {
        Intent intent = new Intent(this, PatientDocumentHome.class);
        startActivity(intent);
    }

    public void scan() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
        new_file.setVisibility(View.VISIBLE);
        x_con.setVisibility(View.VISIBLE);
        new_file_layout.setVisibility(View.VISIBLE);
        new_file.setText(patient_addoc_filename.getText());
        patient_addoc_filename.setText("");
    }
}
