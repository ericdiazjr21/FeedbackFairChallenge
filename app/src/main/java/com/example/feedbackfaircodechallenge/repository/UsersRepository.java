package com.example.feedbackfaircodechallenge.repository;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.feedbackfaircodechallenge.model.User;
import com.example.feedbackfaircodechallenge.network.RetrofitSingleton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersRepository {

    private static UsersRepository singleInstance;
    private MutableLiveData<List<User>> usersResponseMutableLiveData;

    private UsersRepository(){
        usersResponseMutableLiveData = new MutableLiveData<>();
    }

    public static UsersRepository getSingleInstance(){
        if(singleInstance != null){
            return singleInstance;
        }else{
            singleInstance = new UsersRepository();
            return singleInstance;
        }
    }

    public void makeRetrofitCall(){
        RetrofitSingleton.getUsersServiceSingleInstance()
                .getResponse()
                .enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        usersResponseMutableLiveData.setValue(response.body());
                        Log.v("sasuke",response.toString());
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        Log.v("sasuke",t.toString());

                    }
                });
    }

    public MutableLiveData<List<User>> getUsersResponseMutableLiveData() {
        return usersResponseMutableLiveData;
    }
}
