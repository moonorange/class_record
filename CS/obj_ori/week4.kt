class Rectangle(argheight : Double, argwidth : Double){
    var height : Double = argheight
    var width : Double = argwidth
    val cordinate : MutableList<Double> = mutableListOf(2.00,1.00)
    fun area():Double{
        return height * width
    }

}


fun main(args : Array<String>){
    val myRec = Rectangle(10.000,10.000)
    val area = myRec.area()
    var cordinate = myRec.cordinate
    println(area)
    println(cordinate)
}



