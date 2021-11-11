package com.midterm.hblx_02.View.Activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.midterm.hblx_02.Model.Custom_Row_Answer;
import com.midterm.hblx_02.Model.Question;
import com.midterm.hblx_02.R;
import com.midterm.hblx_02.View.Adapter.Custom_ListView_Answer;
import com.midterm.hblx_02.ViewModel.myResource;

import java.util.ArrayList;

public class LearningActivity extends AppCompatActivity implements View.OnClickListener{
    private DrawerLayout mDrawerLayout;
    private ListView listView_Nav,listView_Answer;
    private ArrayAdapter<String> adapter;
    private ActionBarDrawerToggle mToggle;
    private myResource myResource;
    private TextView description;
    private Question quesSelected;
    private int rowIndexSelected;
    private AdapterView adapterView;
    private int indexBegin, indexEnd;
    private ImageButton imgBack, imgNext;
    private ImageView imgView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learing);
        initWidget();
        try {
            indexBegin = (Integer.parseInt(getIntent().getStringExtra("begin")));
            indexEnd = (Integer.parseInt(getIntent().getStringExtra("end")));
            createListViewNavigation();
            createToggle();
            myResource=(new myResource(getResources(),R.raw.resource));
            createListViewAnswer(indexBegin);
        }catch (Exception e){
            Toast.makeText(this,e.toString(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
    private void initWidget(){
        this.listView_Nav = (ListView) findViewById(R.id.layout_learning_lvdrawer);
        this.listView_Answer = (ListView) findViewById(R.id.layout_learning_answer);
        this.description = (TextView) findViewById(R.id.learning_question);
        this.imgBack = (ImageButton) findViewById(R.id.learning_btnBack);
        this.imgNext = (ImageButton) findViewById(R.id.learning_btnNext);
        this.imgView = (ImageView) findViewById(R.id.learning_image_question);
    }

    private void createToggle(){
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_learning);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void createListViewNavigation() throws Exception{
        ArrayList<String> arrList = new ArrayList<>();
        for (int i=indexBegin; i<=indexEnd; i++){
            arrList.add("Câu "+(i+1));
        }
        String [] arr = arrList.toArray(new String[arrList.size()]);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arr);
        listView_Nav.setAdapter(adapter);
        listView_Nav.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    createListViewAnswer(indexBegin + position);
                } catch (Exception e) {
                    Toast.makeText(LearningActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                mDrawerLayout.closeDrawers();
            }
        });
    }
    private void createListViewAnswer(int index) throws Exception{
        ArrayList<Custom_Row_Answer> array = new ArrayList<>();
        Question question = myResource.getIndex(index);
        quesSelected=(question);

        for(String answer : question.getAnswer()){
            array.add(new Custom_Row_Answer(answer,false));
        }

        Custom_ListView_Answer adapter = new Custom_ListView_Answer(this,R.layout.custom_listview_learning,array);
        listView_Answer.setAdapter(adapter);

        listView_Answer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapterView = (parent);
                Custom_Row_Answer row = (Custom_Row_Answer) parent.getItemAtPosition(position);
                row.setBit(!row.isBit());
                Button btn = (Button) view.findViewById(R.id.lear_cus_btn);
                btn.setBackgroundResource(row.isBit()? R.color.colorAccent : R.color.white);
            }
        });
        rowIndexSelected = (index);
        // update layout
        updateLayout(index,question.getDescription());
    }

    private void updateLayout(int index, String des){

        imgBack.setVisibility(View.VISIBLE);
        imgNext.setVisibility(View.VISIBLE);

        if (index==indexBegin)
            imgBack.setVisibility(View.INVISIBLE);
        if(index==indexEnd)
            imgNext.setVisibility(View.INVISIBLE);

        getSupportActionBar().setTitle("Câu số "+(index+1));
        description.setText(des);
        loadImage(index);
    }
    private void loadImage(int index){
        try{
            String path = myResource.getIndex(index).getPathImage();
            Drawable drawable = myResource.getDrawable(getAssets(),"image/"+path);
            imgView.setImageDrawable(drawable);
            if (path.equals("")){
                imgView.setMaxHeight(0);
                imgView.setMinimumHeight(0);
            }
            else{
                imgView.setMinimumHeight(300);
                imgView.setMaxHeight(300);
            }
        }catch(Exception e){}
    }

    @Override
    public void onClick(View view) {

    }
}
