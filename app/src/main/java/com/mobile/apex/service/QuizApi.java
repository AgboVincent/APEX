package com.mobile.apex.service;


import com.mobile.apex.Models.QuizModel;

import retrofit2.Call;
import retrofit2.http.*;

public interface QuizApi {
    @GET("q/20")
    Call<QuizModel> getQuizBySubject(@Query("subject") String subject);
}