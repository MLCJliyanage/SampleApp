package com.example.Helpers;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.sampleapp.MainActivity;

public class WebViewHelp {

    public Context mContext;

    private String myname = null;

    public WebViewHelp(Context c) {
        mContext = c;
    }

    @JavascriptInterface
    public void gotoMain(String msg) {
        myname = msg;
        if (myname == null || myname.isEmpty()) {
            Toast.makeText(mContext, "Please Enter Your Name!", Toast.LENGTH_SHORT).show();
        } else {
            SharedPreferences sharedPreferences = mContext.getSharedPreferences("MyPref", 0);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Name", myname);
            editor.commit();
            Intent intent = new Intent(mContext, MainActivity.class);
            intent.putExtra("Name", myname);
            mContext.startActivity(intent);
        }
        
    }


    @JavascriptInterface
    public void showName(final String dialogMsg) {
        myname = dialogMsg;
        if (myname == null || myname.isEmpty()) {
            Toast.makeText(mContext, "Please Enter Your Name!", Toast.LENGTH_SHORT).show();
        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();
            alertDialog.setTitle("Welcome!");
            alertDialog.setMessage(dialogMsg);
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(mContext, "Dialog dismissed!", Toast.LENGTH_SHORT).show();
                }
            });
            alertDialog.show();
        }


    }


}
