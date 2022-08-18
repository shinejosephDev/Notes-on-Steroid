package com.vibranto.notestuff.domain.model

import com.vibranto.notestuff.domain.util.EntityMapper

class NoteMapper : EntityMapper<com.vibranto.notestuff.data.model.Note, Note> {
    override fun mapFromEntity(entity: com.vibranto.notestuff.data.model.Note?): Note? {
        if (entity != null) {
            return Note(
                title = entity.title,
                content = entity.content,
                timeStamp = entity.timeStamp,
                color = entity.color,
                id = entity.id
            )
        }
        return null
    }

    override fun maptoEntity(model: Note?): com.vibranto.notestuff.data.model.Note? {
        if (model != null) {
            return com.vibranto.notestuff.data.model.Note(
                title = model.title,
                content = model.content,
                timeStamp = model.timeStamp,
                color = model.color,
                id = model.id
            )
        }
        return null
    }
}