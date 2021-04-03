fun main(args: Array<String>){
 
 println(mySort(listOf(1,3,2,8,1)))
 
}



fun mySort(argList : List<Int>):List<Int>{
    val sorted:MutableList<Int> = mutableListOf()
    var rest = argList.toMutableList()
    while (rest.size > 0){
        val maxPair:List<Int> = myMax(rest)
        sorted.add(maxPair[0])
        rest.removeAt(maxPair[1])        // rest.remove(maxPair[0]) でもよい 
    }
    return(sorted)
}