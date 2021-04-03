//-2---181015-NullP-1.kt
fun main(args: Array<String>){
    var a_nullOK:String? ="null許容"
    var b:String = "非Null（Nullだめ）"
    //println("Null許容だとー＞＋${a_nullOK.length}")
    /*Null許容型を参照するとコンパイルエラーとなり、先に
    進めない
    */
    println("Null許容だと... ${a_nullOK?.length}")
    println("Null許容だと... ${a_nullOK!!.length}")
    println(b.length)
    println("Null非許容のｂでは...${b.length}")
}


