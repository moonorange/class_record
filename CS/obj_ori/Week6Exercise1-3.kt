fun main(args: Array<String>) {
    val student1 = Student("keisuke","123456","pass1",1971)
    println(student1.age())
    println(student1.checkPassword("pass1"))
    student1.changePassword("pass2")
	 println(student1.checkPassword("pass1"))
     println(student1.checkPassword("pass2"))
}

class Student(val name : String, val ID : String, private var password : String, val birthYear : Int){
    fun age(): Int{
        return 2018 - birthYear
    }
    fun checkPassword(checkPass:String):Boolean{
        if (this.password == checkPass){
            return true
        }
        else{
            return false
        }
    }
    fun changePassword(changePass:String){
        this.password = changePass
    }
    
}