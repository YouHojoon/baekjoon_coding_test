import kotlin.math.min
fun main(){
    val (n,m) = readLine()!!.split(" ").map{it.toInt()}
    val arr = IntArray(n){readLine()!!.toInt()}.sorted()
    var high = 0
    var ans = Int.MAX_VALUE

    for(low in 0 until n){
        while(high < n && arr[high] - arr[low] < m)
            high++
        if(high == n)
            break
        ans = min(arr[high] - arr[low], ans)
    }
    print(ans)
}
