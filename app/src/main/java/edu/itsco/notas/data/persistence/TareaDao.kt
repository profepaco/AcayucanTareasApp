package edu.itsco.notas.data.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TareaDao {
    @Query("SELECT * FROM tareas")
    fun getAllTareas(): List<Tarea>

    @Insert
    fun insertAll(vararg tareas: Tarea)

    /*
    @Update

    @Delete*/
}