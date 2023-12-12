import java.util.TreeSet

fun main(){
    val (n,m) = readLine()!!.split(" ").map{it.toInt()}
    val arr = readLine()!!.split(" ").map{it.toInt()}.sorted()
    val tmp = IntArray(m)
    val visited = BooleanArray(n)
    val builder = StringBuilder()

    fun seq(depth: Int){
        if(depth == m){
            builder.appendLine(tmp.joinToString(" "))
            return
        }
        var prev = -1
        for(i in 0 until n){
            if(visited[i] || prev == arr[i])
                continue
            
            visited[i] = true
            prev = arr[i]
            tmp[depth] = arr[i]
            seq(depth + 1)
            visited[i] = false
        }
    }

    seq(0)
    print(builder)
}
