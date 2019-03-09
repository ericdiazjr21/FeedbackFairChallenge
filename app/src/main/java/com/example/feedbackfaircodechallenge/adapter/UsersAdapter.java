package com.example.feedbackfaircodechallenge.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.feedbackfaircodechallenge.R;
import com.example.feedbackfaircodechallenge.model.User;
import com.example.feedbackfaircodechallenge.view.UsersViewHolder;

import java.util.List;

public final class UsersAdapter extends RecyclerView.Adapter<UsersViewHolder> {

    private List<User> userList;

    public UsersAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_item_view, viewGroup, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder usersViewHolder, int i) {
        usersViewHolder.onBind(userList.get(i));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

}
