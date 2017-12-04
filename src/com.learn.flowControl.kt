import org.omg.CORBA.Object
import sun.invoke.empty.Empty
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    println("---------  PROGRAM INITIATED! LETZ STUDY ---------")
    printUrls()
    println()
    println()
    println("---------  VAR VS VAl ---------")
    println("1) val is immutable. Seems like you are using final in java.")
    println("2) var is the an variable without final. ")

    val anVal = "I'm a variable VAL"
    var anVar = "I'm a variable VAR"

    println("$anVal and $anVar!")

    anVar = "I can be changed!"
    println("anVar says: $anVar!")

    println()
    println("var and val has types. We can inform doing like so:")
    //long
    val anVa01 = 10L
    //int
    val anVa02 = 10
    //floar
    val anVa03 = 10F
    //double
    val anVa04 = 10.30

    print("long: $anVa01; ")
    print("int: $anVa02; ")
    print("floar: $anVa03 ;")
    print("double: $anVa04 ")

    println()
    println("You can use underscores to make number constants more readable:")
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010

    println()
    print("oneMillion: $oneMillion; ")
    print("creditCardNumber: $creditCardNumber; ")
    print("socialSecurityNumber: $socialSecurityNumber; ")
    print("hexBytes: $hexBytes; ")
    print("bytes: $bytes; ")

    println()
    println("NOTE: Octal literals are not supported.")

    println()
    println()
    println("---------  LOOP CONDITIONS SAMPLES!  ---------")

    val numbersToTestWhen = 1..7
    println("This is a RANGE! $numbersToTestWhen")

    println("Begining an FOR")
    for (fVal in numbersToTestWhen) {
        print("$fVal,")
    }
    println("Range numbers was printed")

    println("This is an WHILE sample")
    var i = 10
    while (i != 0) {
        print("${i--},")
    }
    println()
    println()

    println("---------  WHEN CONDITIONS SAMPLES!  ---------")
    println("conditions WHEN seems like an switch case in java.")

    val randomZeroToTen = Random().nextInt(15)

    println("Result: " + when (randomZeroToTen) {
        1 -> "found it! The number is 1"
        2 -> "found it! The number is 2"
        3 -> "found it! The number is 3"
        4 -> "found it! The number is 4"
        in 5..8 -> "Found it in the range 5..8! $randomZeroToTen"
        else -> "The number $randomZeroToTen is not in any case"
    })
    println("but can be wrapped in a println for example")

    println()
    println()
    println("---------  IF CONTITIONS SAMPLES!  ---------")
    println("If is not a statement, it's a expression in kotlin")
    val ramdomNumIf = Random().nextInt(20)
    // i can print the expression if insite a println.
    val anIfTest = if (ramdomNumIf % 2 == 0) "i'ts an odd number" else "i's and even number"
    println("$anIfTest")

    println()
    println()
    println("---------  CLASS SAMPLES!  ---------")
    val person01 = Person("rafael", "rafadpedrosa@gmail.com", 1000000000)
    person01.printPersonCPFTestingtoken(123)
    val person02 = Person(email = "gest@gmail.com", cpf = 2000000000)
    println(person02.toString())
    val person03 = Person("Karol", "gest@gmail.com", 2000000000, 1000)
    println(person03.toString())

    val user1 = User<String>("User01","user1@gmail.com",199000000)
    println(user1.toString())
    user1.printData()

    var arrayInt: ArrayList<Int> = arrayListOf(1,2,3,4,5,6,7,8,9)
    val user2 = User<Int>("User02","user2@gmail.com",299000000,arrayInt)
    println(user2.toString())
    user2.printData()

    var arrayString: ArrayList<String> = arrayListOf("Karol","Rafael","fernanda","Marcos")
    val user3 = User<String>("User03","user3@gmail.com",399000000,arrayString)
    println(user3.toString())
    user3.printData()


    println()
    println()
    println("---------  OBJECTS SAMPLES!  ---------")
    println("The concepts of OBJECT is vere weird to me. But it's object... It's seems to be like structs like C#")
    println("but it's an instance, it's an java object indeed. Really good, but i can't see why and when use it, yet.")

    val animal01 = object {
        var name = "Mrs. Rogers"
        var type = "cat"
        fun bark():String{
            return "Wolf!"
        }
    }

    val animal02 = object {
        var name = "Mrs. Rogers"
        var type = "cat"
        override fun toString(): String {
            return "name: $name; type: $type"
        }
    }

    println("Animal01 is barking! ${animal01.bark()}")
    println("toString:  $animal01")
    println("Animal02: ${animal02.toString()}")

    println()
    println()
    println("---------  THE END  ---------")
    println()
    println()
    println("There is many many things that we can do with kotlin. I'll try to put a lot of things here but maybe you can serach in the right sites:")
    printUrls()

}

fun printUrls() {
    println("Docs: https://kotlinlang.org/docs/reference/")
    println("Samples & try onlie: https://try.kotlinlang.org")
}

// SPECIFIC function - Whe use : String for typeing the return
fun printArraySec(values: Array<String>): String {
    println("SPECIFIC printArray called to show some vales")
//    values.forEach {
//        println(values)
//    }
    return ""
}

// Generic function
fun <T> printArrayGen(values: Array<T>) {
    println("GENERIC printArray called to show some vales")
    for (v in values)
        println(v)
}

//normal class
open class Person(var name: String = "UNKNOW PERSON", var email: String, val cpf: Int) : PersonI {
    //an way to create variable without using constructor. the val forces it to have just a getter and private to encapslate it.
    private val token = 123
    var number = 0;
    // companion objects are linked to the class. It acts like an static attribute but it's not.
    // If i want to grant that i need to use the @JvmStatic for it
    //XXX need mor effort to understand this
    companion object {
        const val test = false // only accepts VAL behave like a static but has to be immutable
        @JvmStatic
        private var initPrinted = false
    }

    //Number have to be created like this, creating an var and insert it on constructor? I think so, the compiler is warning me.
    constructor(name: String, email: String, cpf: Int, number: Int) : this(name, email, cpf){
        this.number = number
    }

    init {
        if (!Person.initPrinted) {
            println("Person.initPrinted before: ${Person.initPrinted}")
            println("this method acts like a constructor. But i'ts not it, it's a initialize we have access to the variables $name and $email")
            println("is a little weird but when we do an class like so, it creates the get and set already. But we can specify")
            println("the get and set like is written down here")

            Person.initPrinted = !Person.initPrinted
            println("Person.initPrinted after: ${Person.initPrinted}")
        }
    }

    //to override methods use the override clause
    override fun toString(): String {
        return "name: $name email: $email cpf: $cpf number: $number"
    }

    //i'm making a comparsion. I need to specify that token is from the same type for the person token
    override fun printPersonCPFTestingtoken(token: Int): String {
        return if (token == this.token) "Person: $name is $cpf  " else "Wrong token!"
    }
}

//The person class forces you to use one of his constructors. Wrapping/merging/mixing all constructors attributes,
// we still need to create a constructor with all these fields: name, email and cpf. Because it's forcing us to it.
// PS: I had many problems to understand and create that generic <T> thing.
// i had to read about immutable and mutable lists - the curse i'v done don't talk about it! - and it was good
// know... Kotlin is a a good language to functional e probably to threads. the concepts of mutable and immutable
// is everywhere.
class User<T>(name: String = "UNKNOW USER", email: String, cpf: Int) : Person(name, email,cpf){

    var data = mutableListOf<T>()

    constructor(name: String = "UNKNOW USER", email: String, cpf: Int, data:ArrayList<T>): this(name, email,cpf){
        this.data = data
    }

    fun printData() {
        if (!data.isEmpty()){
            for (d in data)
                println(d)
        }else{
            println("Data Array is empty!")
        }
    }

    //overriding it again
    override fun toString(): String {
        return "this is the user toString: ${super.toString()}"
    }
}

interface PersonI {
    fun printPersonCPFTestingtoken(token: Int): String
}