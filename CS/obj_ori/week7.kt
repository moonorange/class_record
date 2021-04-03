
fun main(args: Array<String>){
    var nullOK:String? = "null"
    var b:String = "notNull"
    
    println("${nullOK?.length}")
    println("${nullOK!!.length}")
    println("${nullOK.length}")
    
   
}