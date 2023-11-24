import kotlin.math.max
fun main(){
    val (n,q) = readLine()!!.split(" ").map{it.toInt()}
    val aList = readLine()!!.split(" ").map{it.toInt()}
    val builder = StringBuilder()
    for(t in 0 until q){
        val (x,y) = readLine()!!.split(" ").map{it.toInt() - 1}

        var low = 0
        var high = n

        while(low < high){
            val mid = (low + high) / 2
            if(aList[mid] >= x + 1)
                low = mid + 1
            else
                high = mid
        }

        val ySum = max(high - y, 0)
        val xSum = max(aList[y] - x - 1, 0)

        builder.append("${xSum + ySum}\n")
    }

    print(builder)
}
