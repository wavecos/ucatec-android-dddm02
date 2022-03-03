package bo.edu.ucatec.postgrado.cursos.android.labsemana1.ejemplos

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.util.*


@RequiresApi(Build.VERSION_CODES.O)
fun main() {

    // Como creamos (instanciamos) un objeto a partir de una clase
    val autoA = Automovil()
    autoA.marca = "Hyundai"
    autoA.modelo = "Tucson"
    autoA.anio = 2021

    println(autoA.modelo)

    println("--------")
    val autoB = Automovil()
    autoB.marca = "Toyota"
    autoB.modelo = "Land Cruiser"

    println(autoB.anio)

    // Empleados

    val fecha = LocalDate.of(2015,1,17)
    println(fecha)

    println("*** EMPLEADOS ***")
    val maria = Empleado(  5700.50, LocalDate.of(2003,3,27), "Maria Perales", "4512665", "+1 7524544474")
    val ramiro = Empleado( 6832.0, LocalDate.of(2019,12,4), "ramiro Cuevas", "5245117", "70625419")
    val juan = Empleado(3645.20, LocalDate.of(2008, 6, 9), "Juan Rodriguez", "8545236", "67587412")

    val empleados = listOf(maria, ramiro, juan)

    var total = 0.0
    for (emp in empleados) {
        println("${emp.nombre} - ${emp.documento} - Sueldo: ${emp.sueldo} - Antiguedad: ${emp.antiguedadEnAnios()} años - Bono: ${emp.calculoDeBono()}")
        total += emp.sueldo
    }

    println("El total de la planilla es : $total Bs.")

    // Clientes
    val clienteClaudia = Cliente('V', "clau@gmail.com", "7412545010","Claudia Rosales", "4565778", "44785254")
    println(clienteClaudia.generarCodigo())

    println(ramiro.generarCodigo())



}

// como definimos clases en Kotlin
class Automovil {
    // Propiedades
    var modelo: String = ""
    var marca: String = "clavesecreta"
    var anio: Int = 0
}

open class Persona(var nombre: String, var documento: String, val numeroTelefono: String) {
    fun generarCodigo(): String {
        return "${nombre.uppercase().get(0)}-$documento"
    }
}

class Cliente(var status: Char, email: String, nit: String,
              nombre: String,
              documento: String,
              numeroTelefono: String
): Persona(nombre, documento, numeroTelefono)

class Empleado(var sueldo: Double, var fechaIngreso: LocalDate,
               nombre: String,
               documento: String,
               numeroTelefono: String
): Persona(nombre, documento, numeroTelefono) {

    @RequiresApi(Build.VERSION_CODES.O)
    fun antiguedadEnAnios(): Int {
        val fechaActual = LocalDate.now()
        return fechaActual.year - fechaIngreso.year
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun calculoDeBono(): Double {
        val antiguedad = antiguedadEnAnios()
        var bono = 0.0
        if (antiguedad > 5) {
            bono = sueldo * 0.20
        } else if (antiguedad > 10) {
            bono = sueldo * 0.35
        } else {
            bono = sueldo * 0.05
        }

        return bono
    }

}


class OrdenDePedido {

}