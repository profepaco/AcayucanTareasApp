package edu.itsco.notas.data.repositories

import androidx.lifecycle.LiveData
import edu.itsco.notas.data.persistence.Usuario
import edu.itsco.notas.data.persistence.UsuarioDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsuarioRepository(private val usuarioDao: UsuarioDao) {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    val todosLosUsuarios: LiveData<List<Usuario>> = usuarioDao.getAllUsuarios()

    fun insertarUsuario(usuario: Usuario){
        coroutineScope.launch(Dispatchers.IO) {
            usuarioDao.insertAll(usuario)
        }
    }

    fun actualizarUsuario(usuario: Usuario){
        coroutineScope.launch(Dispatchers.IO) {
            usuarioDao.actualizarUsuarios(usuario)
        }
    }

    fun eliminarUsuario(usuario: Usuario){
        coroutineScope.launch(Dispatchers.IO) {
            usuarioDao.deleteUsuario(usuario)
        }
    }
}
