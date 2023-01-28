package edu.itsco.notas.data.persistence

import androidx.room.Embedded
import androidx.room.Relation

data class UsuarioTarea(
    @Embedded val usuario: Usuario,
    @Relation(
        parentColumn = "usuarioId",
        entityColumn = "tareaId"
    )
    val tareas: List<Tarea>
)
