import kotlin.math.min

fun main(){
    readLine()!!.toInt()
    val money = readLine()!!.split(" ").map{it.toInt()}.sorted()
    val m = readLine()!!.toInt()

    var low = 0
    var high = money.last()

    while(low <= high){
        val mid = (low + high) / 2
        val total = money.map{ min(it, mid) }.sum()

        if(total <= m)
            low = mid + 1
        else
            high = mid - 1
    }

    print(high)
}

