package bo.edu.ucatec.postgrado.cursos.android.labsemana1.ejemplos

// Strings

fun main() {
    val nombre = "Juan Perales"

    println(nombre.length)
    println(nombre.lastIndex)
    println(nombre.uppercase())
    println(nombre.lowercase())

    // Indices
    println(nombre[0])
    println(nombre[nombre.lastIndex])
    println(nombre[nombre.length - 1])
    // Búsqueda
    val refran: String = "No hay peor ciego que el que no quiere ver"

    println(refran.lastIndexOf("ciego"))

    // Ranges
    println("** Ranges **")
    for (x in 1..10) {
        println(x)
    }

    // Tabla de multiplicar del 9
    println("Tabla de Multiplicar")
    val mul = 4
    for (x in 1..10) {
        println("$mul x $x = ${mul * x}")
    }

    for (x in 10 downTo 1) {
        println("$mul x $x = ${mul * x}")
    }

    //
    val constitucion = arrayOf("Bolivia", "derecho", "carta", "articulo", "ley", "derecho")


    var c = 0
    for (palabra in constitucion) {
        if (palabra == "derecho") {
            c++
        }
    }

    println("se encontro $c coincidencias")

    // Funciones
    println("Funciones")

    println(areaTriangulo(3.0, 4.0))

    println(areaCirculo(3.5))
}


fun areaTriangulo(b: Double, h: Double): Double {
    return (b * h) / 2
}

fun areaCirculo(r: Double): Double = 3.14159 * r * r

