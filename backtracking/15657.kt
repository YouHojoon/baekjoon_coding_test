fun main(){
    val (n,m) = readLine()!!.split(" ").map{it.toInt()}
    val arr = readLine()!!.split(" ").map{it.toInt()}.sorted()
    val tmp = IntArray(m)
    val builder = StringBuilder()

    fun seq(depth:Int, index: Int){
        if(depth == m){
            builder.appendLine(tmp.joinToString(" "))
            return
        }

        for(i in index until n){
            tmp[depth] = arr[i]
            seq(depth + 1, i)
        }
    }

    seq(0,0)
    print(builder)
}
