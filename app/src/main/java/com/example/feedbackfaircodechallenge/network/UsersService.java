package com.example.feedbackfaircodechallenge.network;

import com.example.feedbackfaircodechallenge.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsersService {

    @GET("users")
    Call<List<User>> getResponse();
}
