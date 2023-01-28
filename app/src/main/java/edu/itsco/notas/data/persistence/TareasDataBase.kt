package edu.itsco.notas.data.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Usuario::class, Tarea::class], version = 1)
abstract class TareasDataBase: RoomDatabase() {

    //Todos los daos definidos
    abstract fun getUsuarioDao(): UsuarioDao
    abstract fun getTareaDao(): TareaDao
    abstract fun getUsuarioTareaDao(): UsuarioTareaDao

    //Singleto de la BD
    companion object{
        private var INSTANCE: TareasDataBase? = null

        fun getInstance(context: Context): TareasDataBase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TareasDataBase::class.java,
                        "tareas_bd"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}