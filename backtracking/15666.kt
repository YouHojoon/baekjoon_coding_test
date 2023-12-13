fun main(){
    val (n,m) = readLine()!!.split(" ").map{it.toInt()}
    val arr = readLine()!!.split(" ").map{it.toInt()}.sorted()
    val tmp = IntArray(m)
    val builder = StringBuilder()

    fun seq(depth: Int, prev: Int){
        if(depth == m){
            builder.appendLine(tmp.joinToString(" "))
            return
        }
        var p = -1
        for(i in 0 until n){
            if(p == arr[i] || prev > arr[i])
                continue

            p = arr[i]
            tmp[depth] = arr[i]
            seq(depth + 1, arr[i])
        }
    }

    seq(0, -1)
    print(builder)
}
