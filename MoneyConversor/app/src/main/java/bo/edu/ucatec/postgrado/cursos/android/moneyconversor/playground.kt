package bo.edu.ucatec.postgrado.cursos.android.moneyconversor

import java.math.BigDecimal

fun main() {

    val calculo = 5.8 - 5.6

    println(calculo)

    val x = BigDecimal.valueOf(600)
    val y = BigDecimal.valueOf(6.96)
    println(x)
    val calculoCorrecto = x.divide(y, 3, BigDecimal.ROUND_HALF_UP)
    println(calculoCorrecto)

}