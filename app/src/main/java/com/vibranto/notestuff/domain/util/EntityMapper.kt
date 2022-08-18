package com.vibranto.notestuff.domain.util

interface EntityMapper <Entity, DomainModel>{

    fun mapFromEntity(entity: Entity?) : DomainModel?

    fun maptoEntity(model: DomainModel?) : Entity?
}