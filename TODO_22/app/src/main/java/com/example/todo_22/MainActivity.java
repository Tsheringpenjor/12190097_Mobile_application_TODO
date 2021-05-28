package com.example.todo_22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mBookInput;
    private TextView mTitleText, mAuthorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBookInput = findViewById(R.id.SearchInput);
        mTitleText = findViewById(R.id.Title);
        mAuthorText = findViewById(R.id.DisplayBook);
    }

    public void searchBook(View view) {
        String queryString = mBookInput.getText().toString();
        new FatchBook(mTitleText,mAuthorText).execute(queryString);

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;

        if (connectivityManager != null){
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }

        if(networkInfo != null && networkInfo.isConnected() && queryString.length() != 0){
            new FatchBook(mTitleText, mAuthorText).execute(queryString);
            mAuthorText.setText(" ");
            mTitleText.setText("Loading....");
        } else {
            if(queryString.length() == 0 ){
                mAuthorText.setText(" ");
                mTitleText.setText(" Please Enter a Search Term! ");
            } else {
                mAuthorText.setText(" ");
                mTitleText.setText(" Please Check Your Network Connection!");
            }
        }
    }
}