package edu.itsco.notas.data.persistence

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface UsuarioDao {

    @Query("SELECT * FROM usuarios")
    fun getAllUsuarios(): LiveData<List<Usuario>>

    @Query("SELECT * FROM usuarios WHERE nombre LIKE :nombre")
    fun getUsuarioPorNombre(nombre: String): Usuario

    @Query("SELECT * FROM usuarios WHERE idUsuario = :idUsuario")
    fun getUsuarioById(idUsuario: Int): Usuario

    @Insert
    fun insertAll(vararg usuarios: Usuario)

    /*
    @Insert
    fun insert(usurio:Usuario)
     */

    @Update
    fun actualizarUsuarios(vararg  usuarios: Usuario)

    @Delete
    fun deleteUsuario(usuario: Usuario)
}