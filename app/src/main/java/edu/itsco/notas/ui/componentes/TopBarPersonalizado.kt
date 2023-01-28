package edu.itsco.notas.ui.componentes

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun TopBarPersonalizado(titulo: String){
    TopAppBar(
        title = { Text(text = titulo, style = MaterialTheme.typography.h6) }
    )
}