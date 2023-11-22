fun main(){
    val k = readLine()!!.toInt()
    val builder = StringBuilder()
    
    for(i in 0 until k){
        val (n,str) = readLine()!!.split(" ")

        
        for(c in str){
            for(j in 0 until n.toInt())
                builder.append(c)
        }
        builder.append("\n")
    }
    
    print(builder.toString())
}

