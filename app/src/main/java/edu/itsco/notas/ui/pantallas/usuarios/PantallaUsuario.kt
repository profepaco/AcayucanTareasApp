package edu.itsco.notas.ui.pantallas.usuarios

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import edu.itsco.notas.data.persistence.Usuario
import edu.itsco.notas.navegacion.Pantallas

@Composable
fun PantallaUsuarios(
    viewModel: UsuarioViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier
){

    val todosLosUsuarios: List<Usuario> by viewModel.todosLosUsuarios.observeAsState(listOf())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Lista de Usuarios", style = MaterialTheme.typography.h6) }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                icon = {
                       Icon(
                           imageVector = Icons.Filled.Add,
                           contentDescription = "icono fab"
                       )
                },
                text = {
                       Text("Nuevo Usuario")
                },
                onClick = {
                          navController.navigate(
                              route = Pantallas.PantallaNuevoUsuario.ruta
                          )
                },
                backgroundColor = MaterialTheme.colors.primary
            )
        },
        floatingActionButtonPosition = FabPosition.Center
    ) {
        LazyColumn(
            modifier
                .padding(it)
                .fillMaxWidth()) {
           items(todosLosUsuarios) { usuario ->
               TarjetaUsuario(nombreUsuario = usuario.nombre)
           }
        }
    }
}


@Composable
fun TarjetaUsuario(
    nombreUsuario: String,
    modifier: Modifier = Modifier
){
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Row(
            modifier
                .background(MaterialTheme.colors.secondary)
                .padding(8.dp)
        ) {
            Text(
                text = nombreUsuario,
                style = MaterialTheme.typography.h5,
                modifier = modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
            )
            IconButton(
                onClick = { /*TODO*/ },
                modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = Icons.Filled.ExpandMore,
                    contentDescription = "icono"
                )
            }
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun TarjetaUsuarioPreview(){
    PantallaUsuarios()
}
 */