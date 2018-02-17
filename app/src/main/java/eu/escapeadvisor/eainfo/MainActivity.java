package eu.escapeadvisor.eainfo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent mail;
    String website;
    String business;
    String address1;
    String about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail = new Intent(Intent.ACTION_SENDTO);
        website = "http://www.escapeadvisor.eu";
        business = "Escape Advisor";
        address1 = "Always open";
        about = "Lorem ipsum";

    }

    public void goToWebsite(View view) {
        goToUrl(website);

    }

    public void sendEmail(View view) {
        mail.setData(Uri.parse("mailto:"));
        mail.putExtra(Intent.EXTRA_TEXT, business + "\n"+ address1 + "\n" + about);
        mail.putExtra(Intent.EXTRA_SUBJECT, (getString((R.string.email_subject))));
        if (mail.resolveActivity(getPackageManager()) != null) {
            startActivity(mail);
        }

    }

    public void shareTheLove(View view) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, business + "\n"+ address1 + "\n" + about);
        if (sharingIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(sharingIntent,"Share you love using"));
        }
    }

    private void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}
