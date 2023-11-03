//참고 : https://velog.io/@lifeisbeautiful/Kotlin-백준-2805번-나무자르기-with-코틀린
fun main(){
    val (n,m)  = readLine()!!.split(" ").map{it.toInt()}
    val trees = readLine()!!.split(" ").map{it.toLong()}

    var low = 0L
    var high = trees.max()

    while(low <= high){
        val mid = (low + high) / 2
        val tmp = trees.filter{it > mid}.map { it - mid }.sum()

        if(tmp >= m)
            low = mid + 1
       else{
           high = mid - 1
        }
    }

    print(high)
}
