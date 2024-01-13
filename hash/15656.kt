fun main(){
    val (n,m) = readLine()!!.split(" ").map{it.toInt()}
    val arr = readLine()!!.split(" ").map{it.toInt()}.sorted()
    val builder = StringBuilder()
    val res = IntArray(m)

    fun seq(arr:List<Int>, depth: Int){
        if(depth == m){
            builder.appendLine(res.joinToString(" "))
            return
        }

        for(i in arr){
            res[depth] = i
            seq(arr, depth + 1)
        }
    }

    seq(arr, 0)
    print(builder)
}
