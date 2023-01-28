package edu.itsco.notas.ui.pantallas.usuarios

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.itsco.notas.data.persistence.TareasDataBase
import edu.itsco.notas.data.persistence.Usuario
import edu.itsco.notas.data.repositories.UsuarioRepository

class UsuarioViewModel(application: Application): ViewModel() {

    val todosLosUsuarios: LiveData<List<Usuario>>
    private val reposititorio: UsuarioRepository

    init{
        val tareaDB: TareasDataBase = TareasDataBase.getInstance(application)
        reposititorio = UsuarioRepository(tareaDB.getUsuarioDao())

        todosLosUsuarios = reposititorio.todosLosUsuarios
    }

    fun insertarUsuario(usuario: Usuario){
        reposititorio.insertarUsuario(usuario)
    }

    fun actualizarUsario(usuario: Usuario){
        reposititorio.actualizarUsuario(usuario)
    }

    fun eliminarUsuario(usuario: Usuario){
        reposititorio.eliminarUsuario(usuario)
    }
}

class UsuarioViewModelFactory(val application: Application): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UsuarioViewModel(application) as T
    }
}