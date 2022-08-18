package com.vibranto.notestuff.data.repository

import com.vibranto.notestuff.data.dao.NoteDao
import com.vibranto.notestuff.domain.model.Note
import com.vibranto.notestuff.domain.model.NoteMapper
import com.vibranto.notestuff.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteRepositoryImpl(
    private val dao: NoteDao,
    private val mapper: NoteMapper
) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes().map { it.map {
            Note(
                title = it.title,
                content = it.content,
                timeStamp = it.timeStamp,
                color = it.color,
                id = it.id
            )
        } }
    }

    override suspend fun getNoteById(id: Int): Note? {
        return mapper.mapFromEntity(dao.getNoteById(id))
    }

    override suspend fun insertNote(note: Note) {
        mapper.maptoEntity(note)?.let { dao.insertNote(it) }
    }

    override suspend fun deleteNote(note: Note) {
        mapper.maptoEntity(note)?.let { dao.deleteNote(it) }

    }
}