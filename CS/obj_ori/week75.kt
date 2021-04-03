open class Aclass1{
  fun pr1(){
    println("Aclass1のメソッドpr1")
  }
} 
//こいつはoverrideできる

private class Aclass2: Aclass1(){
  public fun pr2(){
      // pr1("Aclass2内で pr1()")
    var a = Aclass2()
    a.pr1()
    print("Aclass2のインスタンス,aにpr1()を作用:")
    println("pr2()の中で") 
      }
    } 
//こいつは外から呼び出すことができる
fun main(args:Array<String>){ 
  var a2 = Aclass2()
  a2.pr1() 
  a2.pr2()
 }

