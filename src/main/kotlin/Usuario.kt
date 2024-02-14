sealed class Usuario {

    class Estudiante(val id:String, val nombre:String, val carrera:String) :Usuario()
    class Profesor(val id:String, val nombre:String, val departamento:String) :Usuario()
    class Visitante(val id:String, val nombre:String) :Usuario()

}

fun aceptarUsuario(usuario:Usuario, libro:Libro) :String {
    when (usuario) {
        is Usuario.Estudiante -> {
            return if (libro.estado == "Libre") {
                libro.estado = "Ocupado"
                "Este usuario (${usuario.nombre}) puede tomar el libro (${libro.titulo})."
            } else "Este libro (${libro.titulo}) ya ha sido prestado."
        }
        is Usuario.Profesor ->{
            return if (libro.estado == "Libre") {
                libro.estado = "Ocupado"
                "Este usuario (${usuario.nombre}) puede tomar el libro (${libro.titulo}) por más tiempo."
            } else "Este libro (${libro.titulo}) ya ha sido prestado."
        }
        is Usuario.Visitante -> "Este usuario (${usuario.nombre}) no puede tomar el libro (${libro.titulo})"
    }
    return ""
}
