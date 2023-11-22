fun main(){
    val str = readLine()!!.uppercase()
    val map = HashMap<Char, Int>()
    
     for(c in str){
        map[c] = (map[c] ?: 0) + 1 
    }
    
    val maxValue = map.maxOf{it.value}
    val maxEntry = map.filter{it.value == maxValue}
    
    if(maxEntry.count() > 1)
        print("?")
    else
        print(maxEntry.keys.first())
}
