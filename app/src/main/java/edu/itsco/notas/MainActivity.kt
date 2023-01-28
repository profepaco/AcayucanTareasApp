package edu.itsco.notas

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import edu.itsco.notas.navegacion.SetupNavGraph
import edu.itsco.notas.ui.pantallas.usuarios.PantallaUsuarios
import edu.itsco.notas.ui.pantallas.usuarios.UsuarioViewModel
import edu.itsco.notas.ui.pantallas.usuarios.UsuarioViewModelFactory
import edu.itsco.notas.ui.theme.TareasAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TareasAppTheme {
                val propietario = LocalViewModelStoreOwner.current

                val navController: NavHostController = rememberNavController()
                propietario?.let{
                    val viewModel: UsuarioViewModel = viewModel(
                        it,
                        "UsuarioViewModel",
                        UsuarioViewModelFactory(
                            LocalContext.current.applicationContext as Application
                        )
                    )
                    SetupNavGraph(viewModel = viewModel, navController = navController)
                    //PantallaUsuarios(viewModel = viewModel, navController = navController)
                }
            }
        }
    }
}