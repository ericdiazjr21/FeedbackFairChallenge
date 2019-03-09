package com.example.feedbackfaircodechallenge.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.feedbackfaircodechallenge.model.User;
import com.example.feedbackfaircodechallenge.repository.UsersRepository;

import java.util.List;

public final class UsersViewModel extends ViewModel {

    private final UsersRepository usersRepository;
    private LiveData<List<User>> usersResponseLiveData;

    public UsersViewModel() {
        this.usersRepository = UsersRepository.getSingleInstance();
        this.usersResponseLiveData = usersRepository.getUsersResponseMutableLiveData();
        usersRepository.makeRetrofitCall();
    }

    public LiveData<List<User>> getUsersResponseLiveData() {
        return usersResponseLiveData;
    }

    public User getUser (int position){
        return usersResponseLiveData.getValue().get(position);
    }

}
