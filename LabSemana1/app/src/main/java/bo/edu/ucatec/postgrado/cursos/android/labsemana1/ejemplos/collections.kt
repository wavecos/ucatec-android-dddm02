package bo.edu.ucatec.postgrado.cursos.android.labsemana1.ejemplos

import android.os.Build
import androidx.annotation.RequiresApi


@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    // Lista Inmutable
    val temperaturas = listOf(21.3f, 20.7f, 22.4f, 21.1f, 19.8f)

    var suma = 0.0f
    for (t in temperaturas) {
        suma += t
    }

    val promedio = suma / temperaturas.size

    println("Temperatura promedio $promedio grados centigrados")

    // Listas Mutables
    val empleados = mutableListOf("Juan", "Maria", "Pedro", "Pablo")

    println(empleados)
    empleados.add("Ramiro")
    println(empleados)
    empleados.add(1, "Ursula")
    println(empleados)
    empleados.add("Juan")
    println(empleados)
    // empleados.remove("Juan") // empleados.removeAt(0)

    for (emp in empleados) {
        if (emp == "Pablo"){
            break
        }
        println(emp)
    }

    println("----------")
    for (emp in empleados) {
        if (emp.length == 5) {
            continue
        }
        println(emp)
    }

    println("---------- todos los empleados cuyo nombre empiece con P y terminen con la letra a --------")
    for (emp in empleados) {
        if (emp[0] == 'P' || emp[emp.length - 1] == 'a') {
            println(emp)
        }
    }

    // Sets
    println("--- SETS ---")
    val planetas = mutableSetOf("Mercurio", "Urano", "Tierra", "Venus", "Marte") // Inmutable con setOf()

    for (planeta in planetas) {
        println(planeta)
    }

    val salida = planetas.add("Tierra")

    println(planetas)

    val salida2 = planetas.add("Saturno")

    println(planetas)

    planetas.clear()

    if (planetas.isEmpty()) {
        println("no existen planetas")
    }

    // Mapas o Diccionario
    println("--- MAPS ---")
    val asegurados = mutableMapOf(4512 to "Juan Capriles", 7845 to "Pedro Velasco", 1374 to "Victor Paz") // Mapa Inmutable con mapOf()

    println(asegurados)

    println("Hay ${asegurados.size} asegurados")

    for ( (llave, valor) in asegurados ) {
        println(valor)
    }

    println("------------")
    val senor = asegurados.get(7845)

    println(senor)

    println("------------")
    asegurados.put(9861, "Alcides Arguedas")

    println(asegurados)
    asegurados.replace(1374, "Victor Pex")

    println(asegurados)
}




