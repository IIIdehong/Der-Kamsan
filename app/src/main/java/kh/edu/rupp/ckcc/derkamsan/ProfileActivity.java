package kh.edu.rupp.ckcc.derkamsan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.login.LoginResult;
import com.google.gson.Gson;

import org.json.JSONObject;


public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView  Name,phoneNumber_eamil,gender;
    private SimpleDraweeView Cover;
    private ImageButton Back;
    private SimpleDraweeView imgProfile;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);

        Back = findViewById(R.id.ibBack);
        Name = findViewById(R.id.tvName);
        Cover = findViewById(R.id.ivCover);
        imgProfile = findViewById(R.id.ivProfile);
        phoneNumber_eamil = findViewById(R.id.tvPH_email);
        gender = findViewById(R.id.tvGender);

        Back.setOnClickListener(this);
        Intent intent = getIntent();
        String loginResultData = intent.getStringExtra("LoginResultData");
        String email = intent.getStringExtra("email");
        phoneNumber_eamil.setText(email);
        Gson gson = new Gson();
        LoginResult loginResult = gson.fromJson(loginResultData,LoginResult.class);
        setFacebookData(loginResult);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibBack:
                onBackPressed();
                break;

        }
    }
    private void setFacebookData(LoginResult loginResult) {
        com.facebook.Profile profile = com.facebook.Profile.getCurrentProfile();
        Name.setText(profile.getName());
        imgProfile.setImageURI(profile.getProfilePictureUri(500,500));



    
    }
}
