package com.vibranto.notestuff.di

import android.app.Application
import androidx.room.Room
import com.vibranto.notestuff.data.NoteDatabase
import com.vibranto.notestuff.data.repository.NoteRepositoryImpl
import com.vibranto.notestuff.domain.model.Note
import com.vibranto.notestuff.domain.model.NoteMapper
import com.vibranto.notestuff.domain.repository.NoteRepository
import com.vibranto.notestuff.domain.usecases.*
import com.vibranto.notestuff.domain.util.EntityMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesMapper(): NoteMapper {
        return NoteMapper()
    }

    @Provides
    @Singleton
    fun providesDatabase(application: Application): NoteDatabase {
        return Room.databaseBuilder(
            application,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesNotesRepository(db: NoteDatabase, mapper: NoteMapper): NoteRepository {
        return NoteRepositoryImpl(
            db.noteDao,
            mapper
        )
    }

    @Provides
    @Singleton
    fun providesNotesUseCases(repository: NoteRepository): NotesUseCases {
        return NotesUseCases(
            getNotesUseCase = GetNotesUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository),
            addNoteUseCase = AddNoteUseCase(repository),
            getNoteUseCase =  GetNoteUseCase(repository)
        )
    }


}