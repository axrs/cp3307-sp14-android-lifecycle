package com.cadcoder.LifeCycle;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class LifeCycleActivity extends Activity {

    private static final String TAG = "LifeCycleActivity";

    /**
     * Fires a notification to the system
     *
     * @param message
     */
    private void notify(String message) {

        Toast t = new Toast(getApplicationContext());
        t.setText(message);
        t.notify();

        Log.d(TAG, message);
    }

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        notify("onCreate");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        notify("onRestoreInstanceState");
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        notify("onPostCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        notify("onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        notify("onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        notify("onResume");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        notify("onPostResume");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        notify("onNewIntent");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        notify("onSaveInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        notify("onPause");
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        notify("onUserLeaveHint");
    }

    @Override
    public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        notify("onCreateThumbnail");
        return super.onCreateThumbnail(outBitmap, canvas);
    }

    @Override
    public CharSequence onCreateDescription() {
        notify("onCreateDescription");
        return super.onCreateDescription();
    }

    @Override
    protected void onStop() {
        notify("onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        notify("onDestroy");
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        notify("onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }
}
