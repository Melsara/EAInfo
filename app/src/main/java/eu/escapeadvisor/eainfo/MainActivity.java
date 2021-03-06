package eu.escapeadvisor.eainfo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String website;
    String business;
    String address1;
    String about;
    String object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        website = getString(R.string.website);
        business = getString(R.string.cardview3_business);
        address1 = getString(R.string.cardview3_address1);
        object = getString(R.string.email_object);
        about = getString(R.string.cardview3_about);

    }

    /*    This method is used in card1 to go to EA website*/

    public void goToWebsite(View view) {
        goToUrl(website);

    }

    /*    This method is used in card3 to send email to EA mail recipient*/

    public void sendEmail(View view) {
        Intent mail = new Intent(Intent.ACTION_SENDTO);
        mail.setData(Uri.parse("mailto:"));
        mail.putExtra(Intent.EXTRA_TEXT, object);
        mail.putExtra(Intent.EXTRA_SUBJECT, (getString((R.string.email_subject))));
        mail.putExtra(Intent.EXTRA_EMAIL, new String[]{getString(R.string.email_recipient)});
        if (mail.resolveActivity(getPackageManager()) != null) {
            startActivity(mail);
        }

    }

    /*    This method is used in card3 to share info about EA*/

    public void shareTheLove(View view) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, business + "\n" + address1 + "\n" + about);
        if (sharingIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(sharingIntent, "Share you love using"));
        }
    }

    /*    This method is used in goToWebsite*/

    private void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}
