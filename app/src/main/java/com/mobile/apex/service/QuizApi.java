package com.mobile.apex.service;


import com.mobile.apex.Models.QuizModel;

import retrofit2.Call;
import retrofit2.http.*;

public interface QuizApi {
    @GET("q/{size}")
    Call<QuizModel> getQuizBySubject(@Path("size") int size, @Query("subject") String subject);
}