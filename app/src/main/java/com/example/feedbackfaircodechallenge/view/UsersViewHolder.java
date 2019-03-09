package com.example.feedbackfaircodechallenge.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.feedbackfaircodechallenge.R;
import com.example.feedbackfaircodechallenge.model.User;

import static com.example.feedbackfaircodechallenge.view.fragments.UserListFragment.POSITION;

public final class UsersViewHolder extends RecyclerView.ViewHolder {

    private TextView nameTextView;


    public UsersViewHolder(@NonNull View itemView) {
        super(itemView);
        findViews(itemView);
    }

    private void findViews(@NonNull View itemView) {
        nameTextView = itemView.findViewById(R.id.name_text_view);
    }

    public void onBind(User user) {
        nameTextView.setText(user.getName());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(), DisplayActivity.class);
                intent.putExtra(POSITION,getAdapterPosition());
                v.getContext().startActivity(intent);
            }
        });
    }


}
