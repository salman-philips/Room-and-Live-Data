package com.roomandlivedataroom1.Database;

import com.roomandlivedataroom1.Utils.SampleDataProvider;

import java.util.List;

public class NoteRepository {

    private static final NoteRepository noteRepositoryInstance = new NoteRepository();

    public List<NoteEntity> noteEntityList;
//simple singleton class
    NoteRepository() {
        noteEntityList = SampleDataProvider.getSampleData();
    }

    public static NoteRepository getInstance(){
        return noteRepositoryInstance;
    }


}
