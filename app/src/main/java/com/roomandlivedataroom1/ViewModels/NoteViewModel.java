package com.roomandlivedataroom1.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.roomandlivedataroom1.Database.NoteEntity;
import com.roomandlivedataroom1.Utils.SampleDataProvider;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
   public List<NoteEntity> noteEntityList = SampleDataProvider.getSampleData();

    public NoteViewModel(@NonNull Application application) {
        super(application);
    }

}
