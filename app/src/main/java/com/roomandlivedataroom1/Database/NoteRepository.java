package com.roomandlivedataroom1.Database;

import android.content.Context;

import com.roomandlivedataroom1.Utils.SampleDataProvider;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class NoteRepository {

    private NoteRepository noteRepositoryInstance;

    public List<NoteEntity> noteEntityList;
    private Executor databaseExecutorThreadInPending = Executors.newSingleThreadExecutor();
    private ApplicationDatabase applicationDatabase;

    //simple singleton class
    NoteRepository(Context context) {
        noteEntityList = SampleDataProvider.getSampleData();
        applicationDatabase = ApplicationDatabase.getInstance(context);
    }

    public static NoteRepository getInstance(Context context) {
        return new NoteRepository(context);
    }

    public void getSampleDataByFirstInsertingItInDb() {
        databaseExecutorThreadInPending.execute(() -> applicationDatabase.noteDao().insetAllNotes(noteEntityList));
    }
}
