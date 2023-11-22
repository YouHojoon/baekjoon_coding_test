fun main(){
    val regex = Regex("^(100+1+|01)+$")
    for (t in 0 until readLine()!!.toInt()){
        if(readLine()!!.matches(regex))
            println("YES")
        else
            println("NO")
    }
    
}
