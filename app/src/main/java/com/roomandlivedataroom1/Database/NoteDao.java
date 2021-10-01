package com.roomandlivedataroom1.Database;

import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
//basically for one note entity there could be at most one dao but you can have more than that as well, implementations are done by room

@Dao
public interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) void insertNote(NoteEntity noteEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE) void insetAllNotes(List<NoteEntity> noteEntityList);

    @Delete void deleteNote(NoteEntity noteEntity);

    @Query("SELECT * FROM notes WHERE id=:id") NoteEntity getNoteById(int id);

    @Query("SELECT * FROM notes ORDER BY date DESC")
    LiveData<List<NoteEntity>> getAllNotes();

    @Query("DELETE FROM notes") int deleteAllNotes();

    @Query("SELECT COUNT(*) FROM notes") int getCountOfNotes();
}
