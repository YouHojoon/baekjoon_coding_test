fun main(){
    val (n,m) = readLine()!!.split(" ").map{it.toInt()}
    val nameToIndex = HashMap<String, Int>()
    val indexToName = mutableListOf<String>()
    val regex = "[0-9]+".toRegex()

    for(i in 0 until n) {
        val name = readLine()!!
        nameToIndex[name] = i + 1
        indexToName.add(name)
    }

    val builder = StringBuilder()
    for(i in 0 until m){
        val str = readLine()!!

        if(str.matches(regex)){
            builder.appendLine(indexToName[str.toInt() - 1])
        }
        else{
            builder.appendLine(nameToIndex[str])
        }
    }
    print(builder)
}
