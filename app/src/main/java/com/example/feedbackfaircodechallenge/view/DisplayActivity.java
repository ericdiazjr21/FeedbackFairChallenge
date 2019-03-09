package com.example.feedbackfaircodechallenge.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.feedbackfaircodechallenge.R;
import com.example.feedbackfaircodechallenge.model.User;
import com.example.feedbackfaircodechallenge.view.fragments.UserListFragment;
import com.example.feedbackfaircodechallenge.viewModel.UsersViewModel;

public class DisplayActivity extends AppCompatActivity {

    private UsersViewModel usersViewModel;
    private User user;
    private TextView phoneTextView;
    private TextView emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        findViews();
        setViewModel();
        setUser();
        setViews();
        phoneOnClickListener();
        emailTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto",user.getEmail(), null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Welcome to Pursuit!");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Thanks for coming!");
                startActivity(Intent.createChooser(emailIntent, null));
            }
        });

    }

    private void findViews() {
        phoneTextView = findViewById(R.id.phone_text_view);
        emailTextView = findViewById(R.id.email_text_view);
    }

    private void setViewModel() {
        usersViewModel = ViewModelProviders.of(this).get(UsersViewModel.class);
    }

    private void setUser() {
        user = usersViewModel.getUser(getIntentExtra());
    }

    private void setViews() {
        phoneTextView.append(user.getPhone());
        emailTextView.append(user.getEmail());
    }

    private void phoneOnClickListener() {
        phoneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                String tel;
                if (user.getPhone().substring(0,2).equals("1-")) {
                    tel = user.getPhone().substring(0,15);
                }else{
                    tel = user.getPhone().substring(0,13);
                }
                intent.setData(Uri.parse("tel:" + tel));
                startActivity(intent);
            }
        });
    }

    private int getIntentExtra() {
        if(getIntent() != null){
            Intent intent = getIntent();
            return intent.getIntExtra(UserListFragment.POSITION, 0);
        }
        return -1;
    }
}
