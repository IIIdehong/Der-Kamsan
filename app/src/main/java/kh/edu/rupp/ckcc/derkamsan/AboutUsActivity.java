package kh.edu.rupp.ckcc.derkamsan;

import android.content.Intent;
import android.icu.util.RangeValueIterator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.util.Linkify;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import org.w3c.dom.Element;

public class AboutUsActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar aboutUS;
    private ImageView Close;

    private TextView logo,Hok,Moka,Kheang,Ratana,Hemail,Memail,Khemail,Remail;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
        aboutUS = findViewById(R.id.tvAbout_us);
        Close = findViewById(R.id.ivClose);
        Hok = findViewById(R.id.tvHok);
        Moka = findViewById(R.id.tvMoka_fb);
        Ratana = findViewById(R.id.tvRatana_fb);
        Kheang = findViewById(R.id.tvKheang_fb);
        Hemail = findViewById(R.id.mail_hok);
        Memail = findViewById(R.id.Moka_mail);
        Khemail = findViewById(R.id.Kheang_mail);
        Remail = findViewById(R.id.Ratana_mail);
        linkClickable();

    }

    private void linkClickable(){
        Kheang.setText("Link my Link:fb.me/chhoem.sokheang.3");
        Linkify.addLinks(Kheang,Linkify.WEB_URLS);
        Khemail.setText("Mail:sokheangchhoem0408@gmail.com");

        Hok.setText("Link my Link:Fb:fb.me/de.hong.5");
        Linkify.addLinks(Hok,Linkify.WEB_URLS);
        Hemail.setText("Mail: hokhacker@gmail.com");

        Moka.setText("Link my Link:https:fb.me/molyka.19.07");
        Linkify.addLinks(Moka,Linkify.WEB_URLS);
        Memail.setText("Mail: sovannmolyka79@gmail.com");

        Ratana.setText("Link my Link:fb.me/ratana.chhorm");
        Linkify.addLinks(Ratana,Linkify.WEB_URLS);
        Remail.setText("Mail:chhormratana@gmail.com");
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivClose:
                onBackPressed();
                break;
            case R.id.tvKheang_fb:
                break;

        }
    }
}
