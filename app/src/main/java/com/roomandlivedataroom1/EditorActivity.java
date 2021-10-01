package com.roomandlivedataroom1;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.roomandlivedataroom1.Database.NoteEntity;
import com.roomandlivedataroom1.ViewModels.EditViewModel;
import com.roomandlivedataroom1.ViewModels.NoteViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;

public class EditorActivity extends AppCompatActivity {

    private EditViewModel editViewModel;

    @BindView(R.id.editorEditText)
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initViewModel();
    }

    private void initViewModel() {
        Observer<NoteEntity> noteObserver = new Observer<NoteEntity>() {
            @Override
            public void onChanged(NoteEntity noteEntity) {

            }
        };
        editViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(EditViewModel.class);
    }
}