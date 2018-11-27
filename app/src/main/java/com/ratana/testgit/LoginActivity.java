package com.ratana.testgit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText EmailPhone,Password;
    private TextView ForgetPassword,Register;
    private ImageButton ibSignIn,ibSignInFB;
    private ImageView ivBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EmailPhone = findViewById(R.id.etxt_email_phone);
        Password = findViewById(R.id.etxtPassword);
        ForgetPassword  = findViewById(R.id.tvForgot_passw);
        ibSignIn = findViewById(R.id.ibSignIn);
        ivBack = findViewById(R.id.ivBack);
        ibSignInFB = findViewById(R.id.ibsingin_fb);
        Register = findViewById(R.id.tvRegister);

        Register.setOnClickListener(this);
        ibSignIn.setOnClickListener(this);
        ivBack.setOnClickListener(this);
        ForgetPassword.setOnClickListener(this);

    }
    public void login(String Email, String Phone, String Password){
        if((Email =="kkk")||(Phone == "098765432")&&(Password=="123")){
            Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
            startActivity(intent);

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivBack:
                onBackPressed();
                break;
            case R.id.tvRegister:
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
                break;
            case R.id.ibSignIn:
                break;
            case R.id.tvForgot_passw:
                break;
        }
    }
}
