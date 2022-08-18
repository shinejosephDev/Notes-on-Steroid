package com.vibranto.notestuff.domain.model

import com.vibranto.notestuff.ui.utils.theme.*

data class Note(
    val title: String,
    val content: String,
    val timeStamp: Long,
    val color: Int,
    val id: Int? = null
){
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message :String) : Exception(message)