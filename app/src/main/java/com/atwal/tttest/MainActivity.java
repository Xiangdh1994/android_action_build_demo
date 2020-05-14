package com.atwal.tttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            PackageInfo pInfo = this.getPackageManager().getPackageInfo(getPackageName(), 0);
            String version = pInfo.versionName;
            int versionCode = pInfo.versionCode;

            String ret = "AppName: " + getString(R.string.app_name) + "\n\n"
                    + "VersionName: " + version + "\n\n"
                    + "VersionCode: " + versionCode;

            TextView tv = (TextView) findViewById(R.id.info);
            tv.setText(ret);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
