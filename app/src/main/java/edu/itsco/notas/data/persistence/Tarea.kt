package edu.itsco.notas.data.persistence

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="tareas")
data class Tarea(
    @PrimaryKey(autoGenerate = true) val tareaId: Int,
    val titulo: String,
    val descripcion: String?,
    val idUsuario: Int
)



