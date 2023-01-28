package edu.itsco.notas.ui.componentes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CajaDeTexto(
    etiqueta: String, textState: MutableState<String>,
    modifier: Modifier = Modifier, singleLine: Boolean = true,){
    OutlinedTextField(
        value = textState.value,
        onValueChange = { textState.value = it},
        label = {
            Text(text = etiqueta)
        },
        modifier = modifier.padding(6.dp).fillMaxWidth(),
        textStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        ),
        singleLine = singleLine
    )
}

@Composable
fun CajaDeTexto2(
    etiqueta: String, textState: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier, singleLine: Boolean = true,){
    OutlinedTextField(
        value = textState,
        onValueChange = { onTextChange(it)},
        label = {
            Text(text = etiqueta)
        },
        modifier = modifier.padding(6.dp).fillMaxWidth(),
        textStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        ),
        singleLine = singleLine
    )
}