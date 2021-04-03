class Aisatsu(val name: String){
    fun aisatsu() {
        println("Hello, ${name}");
    }
}

fun main(args: Array<String>) {
    //Aisatsu(args[0]).aisatsu()
    for(nam in args){
        println("Hello, ${nam}")
    }
}
