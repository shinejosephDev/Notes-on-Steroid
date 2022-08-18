package com.vibranto.notestuff.domain.usecases

import com.vibranto.notestuff.domain.model.InvalidNoteException
import com.vibranto.notestuff.domain.model.Note
import com.vibranto.notestuff.domain.repository.NoteRepository

class AddNoteUseCase(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title cannot be empty.")
        }

        if (note.content.isBlank()) {
            throw InvalidNoteException("The content cannot be empty.")
        }


        repository.insertNote(note)
    }
}