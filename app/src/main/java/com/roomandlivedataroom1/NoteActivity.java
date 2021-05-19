
package com.roomandlivedataroom1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.roomandlivedataroom1.Models.NoteAdapter;
import com.roomandlivedataroom1.Models.NoteEntity;
import com.roomandlivedataroom1.Utils.SampleDataProvider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoteActivity extends AppCompatActivity {
    @BindView(R.id.noteRecyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.fabAdd)
    FloatingActionButton floatingActionButton;

    @OnClick(R.id.fabAdd)
    void onFabClicked(View view){
        Intent editorActivityStartIntent=new Intent(NoteActivity.this,EditorActivity.class);
        startActivity(editorActivityStartIntent);
    }

    @OnClick(R.id.fabAdd)
    void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    List<NoteEntity> noteEntityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        noteEntityList= SampleDataProvider.getSampleData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView.hasFixedSize();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        NoteAdapter noteAdapter=new NoteAdapter(noteEntityList,this);
        recyclerView.setAdapter(noteAdapter);
    }
}