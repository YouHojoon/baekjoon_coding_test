//참고 : https://gyeong-log.tistory.com/104
fun main(){
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }
    var list = mutableListOf(Int.MIN_VALUE)
    
    for(n in arr){
        if(list.last() < n)
            list.add(n)
        else{
            var low = 0
            var high = list.count()
            
            while(low < high){
                val mid = (low + high) / 2
                if(list[mid] < n)
                    low = mid + 1
                else
                    high = mid
            }
            list[high] = n
        }
    }

    println(list.count() - 1)
}

