package com.vibranto.notestuff.data.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vibranto.notestuff.ui.utils.theme.Purple200
import com.vibranto.notestuff.ui.utils.theme.Purple700
import com.vibranto.notestuff.ui.utils.theme.Teal200

@Entity
data class Note(
    val title: String,
    val content: String,
    val timeStamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(Purple200, Teal200, Purple700)
    }
}
