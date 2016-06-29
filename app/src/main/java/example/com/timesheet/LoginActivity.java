package example.com.timesheet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import example.com.timesheet.utils.Constants;
import example.com.timesheet.utils.TimeOkHttp;
import okhttp3.OkHttpClient;



public class LoginActivity extends AppCompatActivity {
    public static String LOG_TAG = LoginActivity.class.getSimpleName();
    final OkHttpClient okHttpClient = new OkHttpClient();
    Button button;
    TextView txtPassword, txtUserName, tvForgotPassword;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtPassword = (TextView)findViewById(R.id.editText2);
        txtUserName = (TextView)findViewById(R.id.editText);

        button = (Button) findViewById(R.id.button_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                intent = new Intent(LoginActivity.this, InternHomeActivity.class);

                startActivity(intent);

                intent = new Intent(LoginActivity.this, InternHomeActivity.class);
                */


                loginEmployee();

            }

        });

        tvForgotPassword = (TextView) findViewById(R.id.forgot_password);
        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });


        //this.getEmployeeList();

    }

    public void getEmployeeList() {

        String cry = "";
        try {
            cry = new JSONObject()
                    .put(Constants.requestType,Constants.GET_EMP_LIST)
                    .put(Constants.companyID,"1")
                    .toString();
        } catch (JSONException e) {
            Log.e("Ygritte = " + LOG_TAG, e.getMessage());
        }

        Log.i("Ygritte - Payload ", cry);
        final TimeOkHttp timeOkHttp = new TimeOkHttp();

        final String url = Constants.TimeSheetUrl;
        final String vero = cry;

            Thread thread = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        //Your code goes here
                        String response = timeOkHttp.post(url + "?JSON=" + vero, vero);
                        Log.i("Ygritte - Response ", response);

                        JSONObject res = new JSONObject(response);
                        JSONArray employes = res.getJSONArray("employeelist");

                        for ( int i = 0; i < employes.length(); i++) {
                            int emp_no = i+1;
                            JSONObject employee = employes.getJSONObject(i);
                            Log.i("Ygritte", employee.getString("empName"));
                            Log.i("Ygritte - Emp : "+emp_no, employes.get(i).toString());
                        }

                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });

            thread.start();


    }



    public void loginEmployee(){


        String json_payload = "";
        String username = txtUserName.getText().toString();
        String password = txtPassword.getText().toString();
//{"requestType":11,"EmpEmail":"Sell01@gmail.com","EmpPassword":"689521"}
        try {
            json_payload = new JSONObject()
                    .put(Constants.requestType,Constants.LOGIN_EMP)
                    .put(Constants.EmpEmail,username)
                    .put(Constants.EmpPassword,password)
                    .toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.i("Ygritte",json_payload);

        final String json_pay = json_payload;

         final TimeOkHttp timeOkHttp = new TimeOkHttp();

        Log.i("Ygrite", "You know nothing Jon Snow!!");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("Ygritte", Constants.TimeSheetUrl);
                Log.i("Ygritte", json_pay);

                try {
                    String res = timeOkHttp.post(Constants.TimeSheetUrl+"?JSON="+json_pay,json_pay);

                    JSONObject jsonObject = new JSONObject (res);
                    String message;
                    message = jsonObject.getString("requestType").toString();
                    Log.i("sello",message);

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        /*(Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Log.i("Ygritte", Constants.TimeSheetUrl);
                    Log.i("Ygritte", json_pay);

                    String res = timeOkHttp.post(Constants.TimeSheetUrl + "?JSON=" + json_pay, json_pay);

                    Log.i("Login",res);




                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        thread.start();*/

    }

    }

