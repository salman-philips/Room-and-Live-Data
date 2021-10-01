package com.roomandlivedataroom1.ViewModels;

import android.app.Application;


import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.roomandlivedataroom1.Database.NoteEntity;
import com.roomandlivedataroom1.Database.NoteRepository;


public class EditViewModel extends AndroidViewModel {

    public MutableLiveData<NoteEntity> mutableNoteEntity;
    private NoteRepository noteRepository;

    public EditViewModel(@NonNull Application application) {
        super(application);
        noteRepository = NoteRepository.getInstance(application.getApplicationContext());

    }
}
