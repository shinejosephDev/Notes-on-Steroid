package com.vibranto.notestuff.ui.notes.state

import com.vibranto.notestuff.domain.model.Note
import com.vibranto.notestuff.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder) : NotesEvent()
    data class DeleteNote(val note: Note) : NotesEvent()
    object RestoreNote : NotesEvent()
    object ToggleOrderSection : NotesEvent()
}