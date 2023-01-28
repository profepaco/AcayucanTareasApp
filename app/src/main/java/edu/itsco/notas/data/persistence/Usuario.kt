package edu.itsco.notas.data.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
data class Usuario(
    @PrimaryKey(autoGenerate = true) val usuarioId: Int,
    val nombre: String,
    val puesto: String,
    @ColumnInfo(name = "correo_electronico") val correoElectronico: String
    //@Ignore val imagen: Bitmap
)
