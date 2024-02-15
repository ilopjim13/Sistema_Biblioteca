/**
 * Clase sellada Usuario con las clases de estudiante, profesor y visitante
 */
sealed class Usuario {

    /**
     * Clase Estudiante dependiente de la clase Usuario
     * @property id: String identificador único para cada estudiante
     * @property nombre :String nombre del estudiante
     * @property carrera :String carrera que está estudiando el estudiante
     */
    class Estudiante(private val id:String, val nombre:String, private val carrera:String) :Usuario() {

        /**
         * Imprime por pantalla la información del estudiante
         * @return :String con la información del estudiante
         */
        override fun toString(): String {
            return "$nombre, estudiante con id: $id en la carrera de $carrera"
        }
    }

    /**
     * Clase Profesor dependiente de la clase Usuario
     * @property id :String identificador único para cada profesor
     * @property nombre :String nombre del profesor
     * @property despartamento :String departamento al que pertenece el profesor
     */
    class Profesor(private val id:String, val nombre:String, private val departamento:String) :Usuario() {

        /**
         * Imprime por pantalla la información del profesor
         * @return :String con la información del profesor
         */
        override fun toString(): String {
            return "$nombre, profesor con id $id del departamento $departamento"
        }
    }

    /**
     * Clase Visitante dependiente de la clase Usuario
     * @property id :String identificador único para cada visitante
     * @property nombre :String nombre del visitante
     */
    class Visitante(private val id:String, val nombre:String) :Usuario() {

        /**
         * Imprime por pantalla la información del visitante
         * @return :String con la información del visitante
         */
        override fun toString(): String {
            return "$nombre, visitante con id: $id"
        }
    }

}


/**
 * Acepta si un usuario puede tomar un libro dependiendo de si este esté libre
 * y dependiendo del usuario que pretenda tomar el libro
 * @return :String devuelve un texto indicando quien lo ha tomado y si ha podido tomar el libro o no
 */
fun aceptarUsuario(usuario:Usuario, libro:Libro) :String {
    return when (usuario) {
        is Usuario.Estudiante -> {
            if (Libreria.prestarLibros(libro, usuario)) "Este estudiante (${usuario.nombre}) ha tomado prestado el libro (${libro.titulo})."
            else "Este estudiante (${usuario.nombre}) no puede tomar el libro (${libro.titulo}) porque ya ha sido prestado."
        }
        is Usuario.Profesor ->{
            if (Libreria.prestarLibros(libro, usuario)) "Este profesor (${usuario.nombre}) ha tomado prestado el libro (${libro.titulo}) por más tiempo."
            else "Este profesor (${usuario.nombre}) no puede tomar el libro (${libro.titulo}) ya ha sido prestado."
        }
        is Usuario.Visitante -> "Este visitante (${usuario.nombre}) no puede tomar el libro (${libro.titulo})"
    }
}
