package com.cc.infiniteunitcircle;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class DonationPage extends Activity {

    private static final String TAG = "In app billing";
    private String amortize = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4JRh9YcaIwgSddA35U1P27+X5DqXLG2U3ppJLnPOLjdIstK+bHia//TVc1QfLUDSqvI/EvnlV";
    private String diagonal = "+vjFcn0gXBN4IKhi5mQqc1zHc49oYsESkkQIDAQAB";
    private IabHelper mHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String base64EncodedPublicKey;
        base64EncodedPublicKey = amortize+UnitCircle.build+MyActivity.corner+diagonal;
       mHelper = new IabHelper(this, base64EncodedPublicKey);
        mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
            public void onIabSetupFinished(IabResult result) {
                if (!result.isSuccess()) {
                    // Oh noes, there was a problem.
                    Log.d(TAG, "Problem setting up In-app Billing: " + result);
                    Toast.makeText(getApplicationContext(), "Startup Failed", Toast.LENGTH_LONG).show();
                }else{
                    Log.d(TAG,"In app billing is set up ok");
                    mHelper.enableDebugLogging(true, TAG);
                }
                // Hooray, IAB is fully set up!
            }
        });
        getActionBar().hide();
        setContentView(R.layout.activity_donation_page);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_about_me, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void backButton(View e){
        Intent goToNextActivity = new Intent(this, MyActivity.class);
        startActivity(goToNextActivity);
    }

    public void webButton(View e){
        Uri uri = Uri.parse("http://www.cabreramath.weebly.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    public void donations(View e){

        mHelper.flagEndAsync();
        mHelper.launchPurchaseFlow(this, "donations", 100, mPurchaseFinishedListener, "donation");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mHelper != null) mHelper.dispose();
        mHelper = null;
    }

    IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener() {
        public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
            if (result.isFailure() || !purchase.getSku().equals("donations") || !purchase.getDeveloperPayload().equals(100)) {
                Log.d(TAG, "Error purchasing: " + result);
                Toast.makeText(getApplicationContext(), "Error Purchasing", Toast.LENGTH_LONG).show();
                return;
            } else {
                Toast.makeText(getApplicationContext(), "Start purchase successful", Toast.LENGTH_LONG).show();
                mHelper.consumeAsync(purchase,mConsumeFinishedListener);
            }
        }
    };

    IabHelper.OnConsumeFinishedListener mConsumeFinishedListener =
            new IabHelper.OnConsumeFinishedListener() {
                public void onConsumeFinished(Purchase purchase, IabResult result) {
                    int messageResId;
                    if (result.isSuccess()) {
                        messageResId = R.string.donate_success;
                    }
                    else {
                        messageResId = R.string.donate_fail;;
                    }
                    Toast.makeText(getApplicationContext(), messageResId, Toast.LENGTH_LONG).show();
                    messageResId = R.string.donate_default;
                }
            };
}
