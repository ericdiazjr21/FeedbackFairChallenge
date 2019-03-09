package com.example.feedbackfaircodechallenge.view.fragments;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.feedbackfaircodechallenge.R;
import com.example.feedbackfaircodechallenge.adapter.UsersAdapter;
import com.example.feedbackfaircodechallenge.model.User;
import com.example.feedbackfaircodechallenge.viewModel.UsersViewModel;

import java.util.List;


public class UserListFragment extends Fragment {

    public static final String POSITION = "com.example.feedbackfaircodechallenge_position";
    private UsersViewModel usersViewModel;
    private View rootView;
    private RecyclerView userListRecyclerView;

    public UserListFragment(){}

    public static UserListFragment getInstance() {
        return new UserListFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_user_list, container, false);
        findViews();
        setUsersViewModel();
        return rootView;
    }

    private void findViews() {
        userListRecyclerView = rootView.findViewById(R.id.users_recycler_view);
    }

    private void setUsersViewModel() {
        usersViewModel = ViewModelProviders.of(this).get(UsersViewModel.class);
        usersViewModel.getUsersResponseLiveData().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> userResponse) {
                setRecyclerView(userResponse);
            }
        });
    }

    private void setRecyclerView(@Nullable List<User> userResponse) {
        userListRecyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        userListRecyclerView.setAdapter(new UsersAdapter(userResponse));
    }

}
