fun main(args: Array<String>) {
    /* Ex3-1   
	println(myMax(listOf(1,3,2,8,1)))
 */
    /* Ex3-2
	val keyList = listOf("a","b","c")
    val valList = listOf(1,2,3)
    println(myZip(keyList,valList))
     */
	/* Ex 3-3
    println(mySort(listOf(1,3,2,8,1)))
    */
    /* Ex 3-4 
    println(myMatch(listOf("a","b","c"),"a"))
    println(myMatch(listOf("a","b","c"),"d"))
    */
    /* Ex 3-5
    val registIDs:Map<String, String> = mapOf("a" to "pass1", "b" to "pass2", "c" to "pass3")
    myCheckID(registIDs,"d","pass4")
    myCheckID(registIDs,"a","pass4")
    myCheckID(registIDs,"a","pass1")
    */
        /* Ex 3-5 ver2 
    val registIDs:Map<String, String> = mapOf("a" to "pass1", "b" to "pass2", "c" to "pass3")
    myCheckID2(registIDs,"d","pass4")
    myCheckID2(registIDs,"a","pass4")
    myCheckID2(registIDs,"a","pass1")
   */
    /* Ex 3-6 
    val recAUpperRight = listOf(4.0,4.0)
    val recALowerLeft = listOf(1.0,2.0)
    val recBUpperRight = listOf(1.0,8.0)
    val recBLowerLeft = listOf(-1.0,1.0)
    println(collisionDetect(recAUpperRight, recALowerLeft,recBUpperRight, recBLowerLeft))
    */
}

/* Ex3-1*/
fun myMax(argL : List<Int>):List<Int>{
    var maxIndex = 0
    var maxVal = argL[maxIndex]
    for (i in 0..argL.size-1){
        if(argL[i]> maxVal){
            maxIndex = i
            maxVal = argL[i]
        }
    }
    return listOf(maxVal, maxIndex)
}

/* Ex3-2 */
fun myZip(keyList: List<String>, valList: List<Int>):MutableMap<String,Int>{
	val mmap : MutableMap<String, Int> = mutableMapOf()
	for(i in 0..keyList.size-1){
    	mmap[keyList[i]] = valList[i] 
    }
    return mmap
}  

/* Ex3-3 */  
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
// Ex 3-4
fun myMatch(argList:List<String>, toMatch : String):Boolean{
    var matchFlag:Boolean = false
    for (elm in argList){
        if (elm==toMatch){
            matchFlag = true
            break
        }
    }
    return matchFlag
}
              
// Ex3-5
// MapのcontainsKey()を使えば一発で判定可，その他registID.keysでkeysのリストを作ってinで評価
// registID[checkID]のnull判定とregistID[checkID]==checkPassでパスワード一致評価の組合せ
fun myCheckID(registID:Map<String,String>, checkID: String, checkPass: String){
    var matchIDFlag : Boolean = false
    var matchPassFlag : Boolean = false
    for ((regID,regPass) in registID){
        if (regID == checkID ){
            matchIDFlag = true
            if (regPass == checkPass){
                matchPassFlag = true
            }
        }
    }
    if (matchPassFlag){
        println("login OK")        
    }
    else if(matchIDFlag){
        println("password unmatch")
    }
    else{
        println("not registered")
    }
}

// Ex3-5　別解
// registID[checkID]のnull判定とregistID[checkID]==checkPassでパスワード一致評価の組合せ
fun myCheckID2(registID:Map<String,String>, checkID: String, checkPass: String){
	if(registID[checkID] == checkPass){
        println("login ok")
    }
    else if (registID[checkID] == null){
        println("unregisted")
    }
    else{
        println("password unmatch")
    }
}

// Ex3-6
fun collisionDetect(recAUpperRight:List<Double>, recALowerLeft:List<Double>,recBUpperRight:List<Double>, recBLowerLeft:List<Double>):Boolean{
    var collisionX = false
    if (recAUpperRight[0] >= recBLowerLeft[0] && recALowerLeft[0] <= recBUpperRight[0]){
        collisionX = true
    }
    var collisionY = false
    if (recAUpperRight[1] >= recBLowerLeft[1] && recALowerLeft[1] <= recBUpperRight[1]){
        collisionY = true
    }
    return collisionX && collisionY    
}
    