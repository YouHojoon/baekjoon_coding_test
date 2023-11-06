// 범위 신경쓰기!
fun main(){
    val (k,n) = readLine()!!.split(" ").map{it.toInt()}
    val lines = IntArray(k)

    for (i in 0..<k) {
        lines[i] = readLine()!!.toInt()
    }

    var low = 1L
    var high = lines.max().toLong()

    while (low <= high){
        val mid: Long = (low + high) / 2
        val num = lines.fold(0){result, line -> result + (line / mid).toInt()}

        if (num >= n)
            low = mid + 1
        else
            high = mid - 1
    }

    println(high)
}
