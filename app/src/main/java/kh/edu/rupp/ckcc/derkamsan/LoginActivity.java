package kh.edu.rupp.ckcc.derkamsan;

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
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

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
            Intent intent = new Intent(this,ProfileActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        Register.setOnClickListener(this);
        ibSignIn.setOnClickListener(this);
        ivBack.setOnClickListener(this);
        ForgetPassword.setOnClickListener(this);
        btnLoginFB.setReadPermissions(Arrays.asList("public_profile", "email", "user_birthday", "user_friends"));
        callbackManager= CallbackManager.Factory.create();
        btnLoginFB.registerCallback(callbackManager ,new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(final LoginResult loginResult) {
                // Pass token to Firebase Auth to manage

                AuthCredential credential = FacebookAuthProvider.getCredential(loginResult.getAccessToken().getToken());
                FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d("Der_Kamsan", "Login with Firebase success.");

                            finish();

                        } else {
                            Log.d("Der_Kamsan", "Login with Firebase error: " + task.getException());
                        }
                    }
                });
//                GraphRequest request = GraphRequest.newMeRequest(
//                        loginResult.getAccessToken(),
//                        new GraphRequest.GraphJSONObjectCallback() {
//                            @Override
//                            public void onCompleted(JSONObject object, GraphResponse response) {
//                                Log.v("LoginActivity", response.toString());
//
//                                // Application code
//                                try {
//                                    String email = object.getString("email");
//                                    String birthday = object.getString("birthday"); // 01/31/1980 format
//
//                                    Gson gson = new Gson();
//                                    Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
//                                    String gsonLogin = gson.toJson(loginResult);
//                                    intent.putExtra("LoginResultData", gsonLogin);
//                                    Log.v("LoginActivity", email);
//                                    intent.putExtra("email",email);
//                                    startActivity(intent);
//                                    finish();
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//
//                            }
//                        });
//                Bundle parameters = new Bundle();
//                parameters.putString("fields", "id,name,email,gender,birthday");
//                request.setParameters(parameters);
//                request.executeAsync();

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
        Log.d("Der_Kamsan", "onActivityResult");

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
