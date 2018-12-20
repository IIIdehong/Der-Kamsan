package com.ratana.testgit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText EmailPhone,Password;
    private TextView ForgetPassword,Register;
    private ImageButton ibSignIn;
    private LoginButton btnLoginFB;
    private ImageView ivBack;

    private CallbackManager callbackManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        EmailPhone = findViewById(R.id.etxt_email_phone);
        Password = findViewById(R.id.etxtPassword);
        ForgetPassword  = findViewById(R.id.tvForgot_passw);
        ibSignIn = findViewById(R.id.ibSignIn);
        ivBack = findViewById(R.id.ivBack);
        Register = findViewById(R.id.tvRegister);
        btnLoginFB = findViewById(R.id.btnFacebookLogin);

        // Check login status with Firebase
        if(FirebaseAuth.getInstance().getCurrentUser()!= null){
            Intent intent = new Intent(this,SignUpActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        Register.setOnClickListener(this);
        ibSignIn.setOnClickListener(this);
        ivBack.setOnClickListener(this);
        ForgetPassword.setOnClickListener(this);
        callbackManager= CallbackManager.Factory.create();
        btnLoginFB.registerCallback(callbackManager ,new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // Pass token to Firebase Auth to manage
                AuthCredential credential = FacebookAuthProvider.getCredential(loginResult.getAccessToken().getToken());
                FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d("ckcc", "Login with Firebase success.");
                            Intent intent = new Intent(LoginActivity.this, com.ratana.testgit.MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Log.d("ckcc", "Login with Firebase error: " + task.getException());
                        }
                    }
                });
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
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
