fun main() {

    val libro = Libro("El señor de los anillos", "JK Rowling", 2000)
    val libro2 = Libro("Titulo1", "desconocido", 2000)
    val libro3 = Libro("Titulo2", "desconocido", 2000)
    val libro4 = Libro("Titulo3", "desconocido", 2000)

    val estudiante = Usuario.Estudiante("00002", "Antonio", "Derecho")

    val profesor = Usuario.Profesor("0003", "Joselito", "2A")


    println("Se agregan los libros a la librería...")
    Libreria.agregarLibro(libro)
    Libreria.agregarLibro(libro2)
    Libreria.agregarLibro(libro2)
    Libreria.agregarLibro(libro3)
    Libreria.agregarLibro(libro4)

    println("\nAlgunos usuarios vienen a por libros y otros a devolver...")


    println(aceptarUsuario(estudiante, libro))

    println(aceptarUsuario(profesor, libro))
    println(aceptarUsuario(profesor, libro2))

    Libreria.devolverLibros(libro, estudiante)

    println(aceptarUsuario(profesor, libro))


    println("\nEstos son los libros de la librería:")

    Libreria.libros.forEach {
        if (it.value == null) println("Este libro (${it.key.titulo}) no ha sido prestado aún.")
        else println("Este libro (${it.key.titulo}) ha sido prestado a ${it.value}.")
    }


}