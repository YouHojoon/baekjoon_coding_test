//참고 : https://uknowblog.tistory.com/198
fun main(){
    val (n, c) = readLine()!!.split(" ").map{it.toInt()}
    var houses = LongArray(n){readLine()!!.toLong()}
    houses.sort()


    var low = 1L
    var high = houses.last() - houses[0]

    while(low <= high){
        val mid = (low + high) / 2
    
        var cnt = 1
        var prev = houses[0]
    
        for(i in 1 until n){
            if(houses[i] - prev >= mid){
                cnt++
                prev = houses[i]
            }
        }
    
        if(cnt >= c){
            low = mid + 1
        }
        else{
            high = mid - 1
        }
    }
    
    println(high)
}

