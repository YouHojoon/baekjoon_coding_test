fun main(){
    val (n,m) = readLine()!!.split(" ").map{it.toInt()}
    val arr = readLine()!!.split(" ").map{it.toInt()}.sorted()
    val tmp = IntArray(m)
    val builder = StringBuilder()
    
    fun seq(depth: Int){
        if(depth == m){
            builder.appendLine(tmp.joinToString(" "))
            return
        }
        var prev = 0
        for(i in arr){
            if(prev == i)
                continue
            prev = i
            tmp[depth] = i
            seq(depth + 1)
        }
    }
    
    seq(0)
    print(builder)
}
