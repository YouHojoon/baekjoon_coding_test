fun main(){
    val map = HashMap<Char, Int>()

    for((i,c) in readLine()!!.withIndex()){
        if(map.containsKey(c))
            continue
        else
            map[c] = i
    }

    val builder = StringBuilder()

    for (c in 'a' .. 'z') {
        if (map.containsKey(c))
            builder.append("${map[c]} ")
        else
            builder.append("${-1} ")
    }
    
    print(builder.toString())
}


