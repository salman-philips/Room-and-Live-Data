package com.roomandlivedataroom1.Database;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.roomandlivedataroom1.Utils.SampleDataProvider;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class NoteRepository {

    private NoteRepository noteRepositoryInstance;

    public LiveData<List<NoteEntity>> noteEntityList;
    private Executor databaseExecutorThreadInPending = Executors.newSingleThreadExecutor();
    private ApplicationDatabase applicationDatabase;

    //simple singleton class
    NoteRepository(Context context) {
        applicationDatabase = ApplicationDatabase.getInstance(context);
        noteEntityList = getAllNotes();
    }

    public static NoteRepository getInstance(Context context) {
        return new NoteRepository(context);
    }

    public void getSampleDataByFirstInsertingItInDb() {
        databaseExecutorThreadInPending.execute(() -> applicationDatabase.noteDao().insetAllNotes(SampleDataProvider.getSampleData()));
    }

    private LiveData<List<NoteEntity>> getAllNotes() {
        return applicationDatabase.noteDao().getAllNotes();
    }

    public void deleteData() {
        databaseExecutorThreadInPending.execute(() -> applicationDatabase.noteDao().deleteAllNotes());
    }
}
