package com.ratana.testgit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText UserName, Email, Password, ConfirmPassw;
    private ImageButton ibSignUp, ibCancel;
    private FirebaseAuth firebaseAuth;
    private TextInputLayout tilPass;
    private ImageView ivBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        UserName = findViewById(R.id.etUsername);
        Email = findViewById(R.id.et_email_phone);
        Password = findViewById(R.id.etPassword);
        ConfirmPassw  = findViewById(R.id.etConfirm_Password);
        ibSignUp = findViewById(R.id.ibSignUp);
        ibCancel = findViewById(R.id.ibCancel);
        tilPass = findViewById(R.id.tilPass);
        ivBack = findViewById(R.id.ivBack);
        firebaseAuth = FirebaseAuth.getInstance();

        ibCancel.setOnClickListener(this);
        ivBack.setOnClickListener(this);
        ConfirmPassw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        ibSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(signup()){
                   //upload data to database
                   String user_email = Email.getText().toString().trim();
                   String user_password = Password.getText().toString().trim();

                   firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){

                                Toast.makeText(SignUpActivity.this,"Sign Up Success!",Toast.LENGTH_LONG).show();
                                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
                            }else {
                                Toast.makeText(SignUpActivity.this,"sign Up Fail!",Toast.LENGTH_LONG).show();
                            }
                       }
                   });
               }
            }
        });

    }
    public boolean signup(){
        boolean result = false;

        String name = UserName.getText().toString();
        String email = Email.getText().toString();
        String password  = Password.getText().toString();
        String confirmPass = ConfirmPassw.getText().toString();

        if(name.isEmpty() && email.isEmpty()&& password.isEmpty()){
            Toast.makeText(this,"Please enter all the detail!",Toast.LENGTH_SHORT).show();
        }else if (password.equals(confirmPass)){

             result = true;
        }
        return result;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivBack:
            onBackPressed();
            break;
           case R.id.ibCancel:
                onBackPressed();
                break;



        }
        }
    }


