package com.nov.datequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<QuizModal> quizModalArrayList;
    Random random;
    int currentScore=0, questionsAttempted=0, currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionTV = findViewById(R.id.TVquestion);
        questionNumberTV = findViewById(R.id.idTVquestionsAttempted);
        option1Btn = findViewById(R.id.radio_button1);
        option2Btn = findViewById(R.id.radio_button2);
        option3Btn = findViewById(R.id.radio_button3);
        option4Btn = findViewById(R.id.radio_button4);
        quizModalArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestions(quizModalArrayList);
        currentPos = random.nextInt(quizModalArrayList.size());
        setDataToViews(currentPos);

        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionsAttempted++;

                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                else
                {showBottomSheet();}
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);

            }
        });


        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionsAttempted++;

                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                else
                {  showBottomSheet();}
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
                }
        });


        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                questionsAttempted++;
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                else
                {showBottomSheet(); }
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);

            }
        });


        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionsAttempted++;

                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                else
                {showBottomSheet();}
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);

            }
        });
    }

    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(QuizActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTVScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your score is \n" +currentScore);
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
                questionsAttempted = 0;
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

    }





private void setDataToViews(int currentPos){



            questionNumberTV.setText("Questions Attempted" + questionsAttempted);
            questionTV.setText(quizModalArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModalArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModalArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizModalArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModalArrayList.get(currentPos).getOption4());








}

    private void getQuizQuestions(ArrayList<QuizModal> quizModalArrayList) {
        quizModalArrayList.add(new QuizModal("Day of the date 12/06/21","Monday","Sunday","Saturday","Tuesday","Saturday"));
        quizModalArrayList.add(new QuizModal("Day of the date 13/06/21","Friday","Tuesday","Saturday","Sunday","Sunday"));
        quizModalArrayList.add(new QuizModal("Day of the date 14/06/21","Monday","Tuesday","Saturday","Wednesday","Monday"));
        quizModalArrayList.add(new QuizModal("Day of the date 15/06/21","Wednesday","Tuesday","Saturday","Sunday","Tuesday"));
        quizModalArrayList.add(new QuizModal("Day of the date 16/06/21","Thursday","Tuesday","Saturday","Wednesday","Wednesday"));
        quizModalArrayList.add(new QuizModal("Day of the date 17/06/21","Friday","Tuesday","Saturday","Thursday","Thursday"));
        quizModalArrayList.add(new QuizModal("Day of the date 18/06/21","Saturday","Friday","Monday","Thursday","Friday"));
        quizModalArrayList.add(new QuizModal("Day of the date 11/06/21","Tuesday","Friday","Saturday","Thursday","Friday"));
        quizModalArrayList.add(new QuizModal("Day of the date 10/06/21","Thursday","Friday","Wednesday","Sunday","Thursday"));
        quizModalArrayList.add(new QuizModal("Day of the date 09/06/21","Wednesday","Friday","Saturday","Monday","Wednesday"));
        quizModalArrayList.add(new QuizModal("Day of the date 08/06/21","Sunday","Friday","Wednesday","Tuesday","Tuesday"));
        quizModalArrayList.add(new QuizModal("Day of the date 07/06/21","Sunday","Friday","Monday","Thursday" +
                "","Monday"));


    }
}