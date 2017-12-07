package nyc.c4q.loopactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private static final String SHARED_PREFS_KEY = "sharedPrefs";
    private SharedPreferences registerPrefs;
    private EditText emailAddress;
    private EditText password;
    private Button submit;
    private CheckBox checkBox;
    private SharedPreferences login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = getIntent();
        registerPrefs = getApplicationContext().getSharedPreferences(intent.getStringExtra("testKey"), MODE_PRIVATE);

        emailAddress = (EditText) findViewById(R.id.emailEditText);
        password = (EditText) findViewById(R.id.passwordEditText);
        submit = (Button) findViewById(R.id.submitButton);
        checkBox = (CheckBox) findViewById(R.id.rememberMeCheckbox);

        login = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

        if (login.getBoolean("isChecked", false)) {
            emailAddress.setText(login.getString("emailAddress", null));
            password.setText(login.getString("password", null));
            checkBox.setChecked(login.getBoolean("isChecked", false));
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = registerPrefs.edit();
                if (emailAddress.getText() != null &&
                        password.getText() != null &&
                        password.getText() != null &&
                        password.getText().toString().equals(
                                password.getText().toString()
                        )) {
                    editor.putString("user" + emailAddress.getText().toString(), emailAddress.getText().toString());
                    editor.putString("password" + emailAddress.getText().toString(), password.getText().toString());
                    editor.commit();
                    finish();

                    if (checkBox.isChecked()) {
                        editor.putString("emailAddress", emailAddress.getText().toString());
                        editor.putString("password", password.getText().toString());
                        editor.putBoolean("isChecked", checkBox.isChecked());
                        editor.commit();
                    } else {
                        editor.putBoolean("isChecked", checkBox.isChecked());
                        editor.commit();
                    }

                    String checkEmail = "email" + emailAddress.getText().toString();
                    String checkPassword = "password" + password.getText().toString();

                    if (emailAddress.getText().toString().equalsIgnoreCase(login.getString(checkEmail, null))
                            && password.getText().toString().equals(login.getString(checkPassword, null))) {
                        Toast.makeText(getApplicationContext(), "Successful login", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
                        intent.putExtra("emailAddress", emailAddress.getText().toString());
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Your email address/password is incorrect. Please try again.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
