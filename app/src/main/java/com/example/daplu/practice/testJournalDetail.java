package com.example.daplu.practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class testJournalDetail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_journal_detail);
    }
    public void BackJournal(View view){
        Intent intent = new Intent(testJournalDetail.this,MainActivity.class);
        startActivity(intent);

    }
}
