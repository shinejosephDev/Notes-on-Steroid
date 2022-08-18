package com.vibranto.notestuff.ui.notes.state

import com.vibranto.notestuff.domain.model.Note
import com.vibranto.notestuff.domain.util.NoteOrder
import com.vibranto.notestuff.domain.util.OrderType

data class NoteState(
    val notes : List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible : Boolean = false
)
