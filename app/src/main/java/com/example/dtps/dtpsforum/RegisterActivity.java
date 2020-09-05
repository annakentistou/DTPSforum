package com.example.dtps.dtpsforum;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    /*EditText edtName ,edtAge ,edtUsername, edtPassword;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        /*final EditText edtName = (EditText) findViewById(R.id.edtName);*/
        final EditText edtUsername = (EditText) findViewById(R.id.edtUsername);
        final EditText edtPassword = (EditText) findViewById(R.id.edtPassword);
        final EditText edtEmail = (EditText) findViewById(R.id.edtEmail);

        final Button bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                /*final String name = edtName.getText().toString();*/
                final String username = edtUsername.getText().toString();
                final String password = edtPassword.getText().toString();
                final String email = edtEmail.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {

                                String username = jsonResponse.getString("username");
                                String password = jsonResponse.getString("user_password");
                                String email = jsonResponse.getString("user_email");

                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(username,password,email,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }

        });
    }
}
