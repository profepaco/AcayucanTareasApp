package edu.itsco.notas.navegacion

sealed class Pantallas(val ruta: String){
    object PantallaUsuarios: Pantallas(ruta = "pantalla_usuarios")
    object PantallaNuevoUsuario: Pantallas(ruta = "pantalla_nuevo_usuario")
}
