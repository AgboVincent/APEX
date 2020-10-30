package com.mobile.apex.Screens;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textview.MaterialTextView;
import com.mobile.apex.Models.QuizModel;
import com.mobile.apex.Models.QuizQuestionModel;
import com.mobile.apex.Models.QuizQuestionOptionModel;
import com.mobile.apex.NoItemInternetImage;
import com.mobile.apex.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.TextViewCompat;

import com.mobile.apex.service.QuizApi;
import com.mobile.apex.service.RetrofitServiceBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizActivity extends AppCompatActivity {
    private TextView mtv_question;
    private TextView mtv_question_number;
    private RadioGroup options_group;
    private RadioButton option_a;
    private RadioButton option_b;
    private RadioButton option_c;
    private RadioButton option_d;
    private Button btn_next;
    private Toolbar quiz_toolbar;

    private int question_counter;
    private int question_total;
    private QuizQuestionModel current_question;
    List<QuizQuestionModel> questionModels;
    FrameLayout layoutGone;

    private int score;
    private long back_pressed;
    String subjectType;
    boolean doubleBackToExit = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_new);

        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {

        } else {
            Intent i = new Intent(this, NoItemInternetImage.class);
            startActivity(i);
        }

        quiz_toolbar = findViewById(R.id.quiz_toolbar);
        mtv_question = findViewById(R.id.mtv_question);
        mtv_question_number = findViewById(R.id.mtv_question_number);
        options_group = findViewById(R.id.options_group);
        option_a = findViewById(R.id.option_a);
        option_b = findViewById(R.id.option_b);
        option_c = findViewById(R.id.option_c);
        option_d = findViewById(R.id.option_d);
        btn_next = findViewById(R.id.btn_next);

        setSupportActionBar(quiz_toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("APEX Quiz");
        quiz_toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimaryDark));
        subjectType = getIntent().getStringExtra("subject_type");
        //Toast.makeText(this, "passed " + subjectType, Toast.LENGTH_LONG).show();

        quiz_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        layoutGone = findViewById(R.id.layout_gone);
        layoutGone.setVisibility(View.VISIBLE);

        fetchQuizzes(subjectType);
        final ProgressDialog progressDialog = new ProgressDialog(QuizActivity.this,
                R.style.BaseTheme);
        progressDialog.setIcon(R.mipmap.ic_launcher_round);
        progressDialog.setIndeterminate(true);
        progressDialog.setTitle("Loading...");
        progressDialog.setMessage("Please wait");
        progressDialog.show();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {

                        progressDialog.dismiss();
                    }
                }, 3000);

        btn_next.setOnClickListener(v -> next());

    }


    public void fetchQuizzes(String subject) {
        QuizApi quizApi = RetrofitServiceBuilder.getRetrofitInstance().create(QuizApi.class);

        Call<QuizModel> call = quizApi.getQuizBySubject(subject);
        call.enqueue(new Callback<QuizModel>() {
            @Override
            public void onResponse(Call<QuizModel> call, Response<QuizModel> response) {

                if (response.isSuccessful()) {
                    layoutGone.setVisibility(View.GONE);
                    btn_next.setVisibility(View.VISIBLE);
                    QuizModel res = response.body();
                    List<QuizQuestionModel> data = res.getData();
                    beginQuiz(data);
                }

            }

            @Override
            public void onFailure(Call<QuizModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void beginQuiz(List<QuizQuestionModel> questions) {
        question_total = questions.size();
        questionModels = questions;
        Collections.shuffle(questionModels);
        showNextQuestion();
    }

    public void next() {
        if (option_a.isChecked() || option_b.isChecked() || option_c.isChecked() || option_d.isChecked()) {
            //Check answer and show next question;
            checkAnswer();
        } else {
            Toast.makeText(this, "Kindly select an answer", Toast.LENGTH_LONG).show();
        }
    }

    private void showNextQuestion() {
        options_group.clearCheck();

        if (question_counter < question_total) {
            current_question = questionModels.get(question_counter);

            mtv_question.setText(current_question.getQuestion());
            option_a.setText("A. " + current_question.getOption().getA());
            option_b.setText("B. " + current_question.getOption().getB());
            option_c.setText("C. " + current_question.getOption().getC());
            option_d.setText("D. " + current_question.getOption().getD());

            question_counter++;
            mtv_question_number.setText("Question " + question_counter + "/" + questionModels.size());
            btn_next.setText("Next");
        } else {
            //Finish quiz.
            finishQuiz();
        }
    }

    private void checkAnswer() {
        switch (current_question.getAnswer()) {
            case "a":
                if (option_a.isChecked()) {
                    //Add to score and move on
                    score++;
                    Toast.makeText(this, "Correct !!!", Toast.LENGTH_LONG).show();
                    showNextQuestion();
                } else {
                    //Failed and move on after 2 seconds
                    Toast.makeText(this, "Option A was the correct answer", Toast.LENGTH_LONG).show();
                    new Handler().postDelayed(() -> showNextQuestion(), 2000);
                }
                break;
            case "b":
                if (option_b.isChecked()) {
                    //Add to score and move on
                    score++;
                    Toast.makeText(this, "Correct !!!", Toast.LENGTH_LONG).show();
                    showNextQuestion();
                } else {
                    //Failed and move on after 2 seconds
                    Toast.makeText(this, "Option B was the correct answer", Toast.LENGTH_LONG).show();
                    new Handler().postDelayed(() -> showNextQuestion(), 2000);
                }
                break;
            case "c":
                if (option_c.isChecked()) {
                    //Add to score and move on
                    score++;
                    Toast.makeText(this, "Correct !!!", Toast.LENGTH_LONG).show();
                    showNextQuestion();
                } else {
                    //Failed and move on after 2 seconds
                    Toast.makeText(this, "Option C was the correct answer", Toast.LENGTH_LONG).show();
                    new Handler().postDelayed(() -> showNextQuestion(), 2000);
                }
                break;
            case "d":
                if (option_d.isChecked()) {
                    //Add to score and move on
                    score++;
                    Toast.makeText(this, "Correct !!!", Toast.LENGTH_LONG).show();
                    showNextQuestion();
                } else {
                    //Failed and move on after 2 seconds
                    Toast.makeText(this, "Option D was the correct answer", Toast.LENGTH_LONG).show();
                    new Handler().postDelayed(() -> showNextQuestion(), 2000);
                }
                break;
        }
    }


    private void finishQuiz() {
        new AlertDialog.Builder(this)
                .setTitle("Quiz Results")
                .setMessage("Score: " + score)
                .setPositiveButton("Okay", (dialog, which) -> {
                    //Dismiss and go home
                    dialog.dismiss();
                    finish();
                }).
                setCancelable(false).show();
    }

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "Press back again to finish the quiz", Toast.LENGTH_LONG).show();
        }
        back_pressed = System.currentTimeMillis();
    }
}
