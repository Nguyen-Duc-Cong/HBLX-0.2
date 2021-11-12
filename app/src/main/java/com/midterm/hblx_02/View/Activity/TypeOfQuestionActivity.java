package com.midterm.hblx_02.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.midterm.hblx_02.R;

public class TypeOfQuestionActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
//            case R.id.layout_question_20:
//                intent = new Intent(this,LearningDetail.class);
//                intent.putExtra("begin","0");
//                intent.putExtra("end","74");
//                break;
            case R.id.layout_question_KNVQT:
                intent = new Intent(this, LearningActivity.class);
                intent.putExtra("begin","0");
                intent.putExtra("end","74");
                break;
            case R.id.layout_question_VHDDLX:
                intent = new Intent(this, LearningActivity.class);
                intent.putExtra("begin","75");
                intent.putExtra("end","79");
                break;
//            case R.id.layout_question_KTLX:
//                intent = new Intent(this,LearningDetail.class);
//                intent.putExtra("begin","0");
//                intent.putExtra("end","74");
//                break;
            case R.id.layout_question_BBDB:
                intent = new Intent(this, LearningActivity.class);
                intent.putExtra("begin","80");
                intent.putExtra("end","115");
                break;
            case R.id.layout_question_SH:
                intent = new Intent(this, LearningActivity.class);
                intent.putExtra("begin","116");
                intent.putExtra("end","149");
                break;
        }
        try{
            startActivity(intent);
        }catch (Exception e){}
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_of_questions);
        customActionbar();
    }

    private void customActionbar(){
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.activity_bar, null);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
        mTitleTextView.setText("Học Luật");
        ImageButton imgbHome = (ImageButton) mCustomView.findViewById(R.id.actionbar_btnHome);

        imgbHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TypeOfQuestionActivity.this,MainActivity.class);
                startActivity(intent);
                TypeOfQuestionActivity.this.overridePendingTransition( R.anim.righttoleft, R.anim.stable );
            }
        });

        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
    }


}
