fun main(){
    val (n,m) = readLine()!!.split(" ").map{it.toInt()}
    val arr = readLine()!!.split(" ").map{it.toInt()}.sorted()
    val tmp = IntArray(m)
    val builder = StringBuilder()
    val visited = BooleanArray(n)

    fun seq(index: Int, depth: Int){
        if(depth == m){
            builder.appendLine(tmp.joinToString(" "))
            return
        }

        var prev = 0
        for(i in index until arr.size){
            if(visited[i] || prev == arr[i])
                continue

            prev = arr[i]
            visited[i] = true
            tmp[depth] = prev
            seq(i + 1, depth + 1)
            visited[i] = false
        }
    }

    seq(0,0)
    print(builder)
}
