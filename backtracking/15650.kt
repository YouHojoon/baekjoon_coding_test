fun sequence(n: Int, m: Int){
    val arr = IntArray(m)
    fun recursiveSequence(arr: IntArray, depth: Int, num: Int){
        if(depth == m){
            println(arr.joinToString(" "))
            return
        }
        
        for(i in num .. n){
            arr[depth] = i
            recursiveSequence(arr,depth + 1, i + 1)
        }
    }
    recursiveSequence(arr,0,1)
}

fun main(){
    val (n,m) = readLine()!!.split(" ").map{it.toInt()}
    sequence(n,m)
}
