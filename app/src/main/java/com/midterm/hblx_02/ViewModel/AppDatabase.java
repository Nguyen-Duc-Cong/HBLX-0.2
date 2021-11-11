package com.midterm.hblx_02.ViewModel;//package com.midterm.hblx;
//
//import android.content.Context;
//
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//
//import com.midterm.hblx.Model.DAO.TypeOfQuestionDAO;
//import com.midterm.hblx.Model.TypeOfQuestion;
//
//@Database(entities = {TypeOfQuestion.class}, version = 1)
//
//public abstract class AppDatabase extends RoomDatabase {
//    public abstract TypeOfQuestionDAO typeOfQuestionDAO();
//
//    private static AppDatabase instance;
//
//    public static AppDatabase getInstance(Context context){
//        if(instance == null){
//            instance = Room.databaseBuilder(context, AppDatabase.class,"TypeOfQuestion").build();
//        }
//        return instance;
//    }
//}

