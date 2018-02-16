package eu.escapeadvisor.eainfo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToWebsite (View view) {
        goToUrl("https://www.esccapeadvisor.eu");

    }

    public void sendEmail (View view) {
        @// TODO: 17/02/2018 intent for sending email to info@escapeadvisor.eu. Define: receiver + text

    }

    public void shareTheLove (View view) {
        @// TODO: 17/02/2018 implicit intent for sharing the about and the image 

    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}
