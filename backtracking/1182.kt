fun find(depth: Int, sum: Int, n: Int, s: Int, seq: IntArray): Int{
    if(n == depth){
        if (sum == s)
            return 1
        else
            return 0
    }
    return find(depth + 1, sum + seq[depth], n,s, seq) + find(depth + 1, sum, n,s, seq)
}

fun main(){
    val (n,s) = readLine()!!.split(" ").map{it.toInt()}
    val seq = readLine()!!.split(" ").map{it.toInt()}.toIntArray()
    var cnt = find(0,0,n,s,seq)
    
    if(s == 0)
        cnt--
    
    print(cnt)
}
