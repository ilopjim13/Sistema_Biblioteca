sealed class Usuario {

    class Estudiante(val id:String, val nombre:String, val carrera:String) :Usuario()
    class Profesor(val id:String, val nombre:String, val departamento:String) :Usuario()
    class Visitante(val id:String, val nombre:String) :Usuario()

}

fun aceptarUsuario(usuario:Usuario, libro:Libro) :String {
    return when (usuario) {
        is Usuario.Estudiante -> "Este usuario (${usuario.nombre}) puede tomar el libro (${libro.titulo})."
        is Usuario.Profesor -> "Este usuario (${usuario.nombre}) puede tomar el libro (${libro.titulo}) por más tiempo."
        is Usuario.Visitante -> "Este usuario (${usuario.nombre}) no puede tomar el libro (${libro.titulo})"
    }
}
