package com.example.feedbackfaircodechallenge.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitSingleton  {

    private static Retrofit singleInstance;
    private static UsersService usersServiceSingleInstance;

    private RetrofitSingleton(){}

    private static Retrofit getSingleInstance(){
        if(singleInstance != null){
            return singleInstance;
        }else{
            singleInstance = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return singleInstance;
        }
    }

    public static UsersService getUsersServiceSingleInstance(){
        if(usersServiceSingleInstance == null){
            usersServiceSingleInstance = getSingleInstance().create(UsersService.class);
            return usersServiceSingleInstance;
        }else{
            return usersServiceSingleInstance;
        }
    }
}