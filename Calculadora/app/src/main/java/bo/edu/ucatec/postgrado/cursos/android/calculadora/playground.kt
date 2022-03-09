package bo.edu.ucatec.postgrado.cursos.android.calculadora


fun main() {
    // Enumeraciones

    val masculino = "M"
    val femenino = "F"

    val generoJuan = Genero.M

    if (generoJuan == Genero.M) {}

    val docExp = ExpDocumento.LPZ
}

enum class Genero {
    M,
    F
}

enum class ExpDocumento {
    CBA,
    LPZ,
    SCZ,
    ORU
}