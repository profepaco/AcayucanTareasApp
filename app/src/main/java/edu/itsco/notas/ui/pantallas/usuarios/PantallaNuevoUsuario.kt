package edu.itsco.notas.ui.pantallas.usuarios

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import edu.itsco.notas.data.persistence.Usuario
import edu.itsco.notas.navegacion.Pantallas
import edu.itsco.notas.ui.componentes.CajaDeTexto
import edu.itsco.notas.ui.componentes.TopBarPersonalizado

@Composable
fun PantallaNuevoUsuario(
    viewModel: UsuarioViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier){
    val nombre = rememberSaveable{ mutableStateOf("")}
    val puesto = rememberSaveable{ mutableStateOf("") }
    val email = rememberSaveable{ mutableStateOf("") }
    Scaffold(
        topBar = {
            TopBarPersonalizado(titulo = "Nuevo usuario")
        }
    ) {
        Column(modifier.padding(it)) {
            CajaDeTexto("Nombre",nombre)
            CajaDeTexto("Puesto",puesto)
            CajaDeTexto("Correo Electrónico",email)
            Button(
                onClick = {
                        viewModel.insertarUsuario(
                              Usuario(
                                  usuarioId = 0,
                                  nombre = nombre.value,
                                  puesto = puesto.value,
                                  correoElectronico = email.value
                              )
                        )
                        navController.navigate(
                            route = Pantallas.PantallaUsuarios.ruta
                        )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar usuario")
            }
        }
    }
}

@Composable
fun BotonGuardar(){
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Guardar")
    }
}


/*
@Preview(showBackground = true)
@Composable
fun PreviewPantallaNuevoUsuario(){
    PantallaNuevoUsuario()
}
*/