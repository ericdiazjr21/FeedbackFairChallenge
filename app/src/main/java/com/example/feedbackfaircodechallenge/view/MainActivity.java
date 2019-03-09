package com.example.feedbackfaircodechallenge.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.feedbackfaircodechallenge.R;
import com.example.feedbackfaircodechallenge.view.fragments.UserListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, UserListFragment.getInstance())
                .commit();
    }
}
