/**
 * Clase Libreria con un diccionario de todos los libros y si están disponibles o los tiene alguien
 */
class Libreria {

    companion object {
        val libros = mutableMapOf<Libro, Usuario?>()

        /**
         * Agrega un libro al diccionario sin ningun usuario
         * y ya está en el libro imprimirá un mensaje avisando de ello
         */
        fun agregarLibro(libro: Libro) {
            if (libro !in libros) libros[libro] = null
            else println("Este libro ya está dentro de la librería.")
        }

        /**
         * Presta el libro si este no le pertenece a nadie y se lo asigna a esa persona
         * @return :Boolean indicando si se ha podido prestar o no
         */
        fun prestarLibros(libro: Libro, usuario: Usuario) : Boolean {
            if (libros[libro] == null) {
                libros[libro] = usuario
                return true
            } else return false
        }

        /**
         * Devuelve el libro que se le habia prestado a la persona,
         * si la persona no coincide con el libro dará un error
         */
        fun devolverLibros(libro: Libro, usuario: Usuario) {
            if (libros[libro] == usuario) {
                libros[libro] = null
                println("Libro devuelto correctamente")
            }
            else println("**ERROR** No se ha podido devolver el libro")
        }
    }
}