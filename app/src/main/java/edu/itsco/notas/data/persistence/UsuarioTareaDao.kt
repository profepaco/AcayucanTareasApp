package edu.itsco.notas.data.persistence

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface UsuarioTareaDao {

    @Transaction
    @Query("SELECT * FROM usuarios")
    fun getUsuariosTareas(): List<UsuarioTarea>
}