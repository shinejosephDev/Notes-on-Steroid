package com.vibranto.notestuff.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vibranto.notestuff.data.dao.NoteDao
import com.vibranto.notestuff.data.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase : RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "note_db"
    }
}