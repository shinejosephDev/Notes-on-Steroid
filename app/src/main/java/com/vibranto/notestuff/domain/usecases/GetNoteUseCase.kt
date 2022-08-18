package com.vibranto.notestuff.domain.usecases

import com.vibranto.notestuff.domain.model.Note
import com.vibranto.notestuff.domain.repository.NoteRepository

class GetNoteUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}