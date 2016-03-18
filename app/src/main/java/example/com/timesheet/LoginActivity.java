package example.com.timesheet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
Button button;
TextView txtPassword, txtUserName, tvForgotPassword;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = (Button) findViewById(R.id.button_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // if( "Bongi".equals(txtUserName) &&  "123".equals(txtPassword))
               // {
                     intent = new Intent(LoginActivity.this, InternHomeActivity.class);
                    startActivity(intent);
              //  }
              //  else
              //  {
                    intent = new Intent(LoginActivity.this,InternHomeActivity.class);
                }

        });

        tvForgotPassword = (TextView) findViewById(R.id.forgot_password);
        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent (LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });



    }
}