package com.example.todo_8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    public static final String tag = MainActivity.class.getName();

    private EditText mEdittextwebsite, mEdittextLocation, mEdittextText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdittextwebsite = findViewById(R.id.editTextTextPersonName);
        mEdittextLocation = findViewById(R.id.editTextTextPersonName2);
        mEdittextText = findViewById(R.id.editTextTextPersonName3);


    }


    public void openwebsite(View view) {
        String url = mEdittextwebsite.getText().toString();

        if (!TextUtils.isEmpty(url)) {
            Uri webpage = Uri.parse(url);
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(webIntent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void openlocation(View view) {
        String loc = mEdittextLocation.getText().toString();

        if (!TextUtils.isEmpty(loc)) {
            Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
            Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void opentext(View view) {
        String txt = mEdittextText.getText().toString();

        ShareCompat.IntentBuilder
                .from(this)
                .setType("text/plain")
                .setChooserTitle("Share this text with: ")
                .setText(txt)
                .startChooser();
    }

}