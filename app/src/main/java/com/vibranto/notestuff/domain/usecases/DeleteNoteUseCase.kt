package com.vibranto.notestuff.domain.usecases

import com.vibranto.notestuff.domain.model.Note
import com.vibranto.notestuff.domain.repository.NoteRepository

class DeleteNoteUseCase(
    private val  repository: NoteRepository
) {

    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }
}