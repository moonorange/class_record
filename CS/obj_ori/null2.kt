//-3---181015-NullP-2.kt
// ?.演算子(safe call operator) と?:演算子(エルビス)
fun main(args: Array<String>){
    var a: String = "非Null"
    println(a.length) //非Null型の参照OK
    var b: String? = "null許容"
    println(b.length) //Null許容型を参照するとコンパイルエラー
    if(b != null){ //nullチェック
      println(b.length) //参照できる
    }
    //whenでnullチェックしても良い
    when{    b != null -> println(b.length) }
    // !!はNullableを強制的にNotNullに変換する操作　例:　b!!
    println("${b!!}")
    var d: String? = null 
    println(d?.length) //？．は「安全呼び出し」演算子(safe call )
    var e: String? = "null許容"
    println(e?.length) //文字数が表示される
/* ?:（エルビス）演算子は、「第1項がnullではない場合は第1項を、
nullの場合には第2項を返す」演算子 */
}