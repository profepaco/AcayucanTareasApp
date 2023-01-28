package edu.itsco.notas.navegacion

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.itsco.notas.ui.pantallas.usuarios.PantallaNuevoUsuario
import edu.itsco.notas.ui.pantallas.usuarios.PantallaUsuarios
import edu.itsco.notas.ui.pantallas.usuarios.UsuarioViewModel


@Composable
fun SetupNavGraph(
    viewModel: ViewModel,
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Pantallas.PantallaUsuarios.ruta
    ){
        composable(
            route = Pantallas.PantallaUsuarios.ruta
        ){
            PantallaUsuarios(
                viewModel = viewModel as UsuarioViewModel,
                navController = navController
            )
        }
        composable(
            route = Pantallas.PantallaNuevoUsuario.ruta
        ){
            PantallaNuevoUsuario(
                viewModel = viewModel as UsuarioViewModel,
                navController = navController)
        }
    }
}