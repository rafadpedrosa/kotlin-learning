fun main(args: Array<String>) {
    val car = Car("fusca", "wolks")

    println(car.toString())
    println("marca do car: ${car.marca}")

    for (v in 1..10)
        println(v)
}

class Car(var nome:String, var marca:String){
    fun printNomeAndMarca(): String {
        return "nome: $nome"
    }
}