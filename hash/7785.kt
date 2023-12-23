fun main(){
    val hash = HashMap<String, Boolean>()
    
    for(i in 0 until readLine()!!.toInt()){
        val (name, state) = readLine()!!.split(" ")
        if(state == "enter")
            hash[name] = true
        else
            hash[name] = false
    }
    
    hash.filter{it.value}.keys.sortedDescending().forEach{println(it)}
}
