import java.lang.StringBuilder

fun main(){
    val (n,m) = readLine()!!.split(" ").map{it.toInt()}
    val arr = IntArray(m)
    val builder = StringBuilder()
    
    fun recursiveSequence(arr: IntArray, depth: Int){
        if(depth == m){
            builder.appendLine(arr.joinToString(" "))
            return
        }
        for(i in 1 .. n){
            arr[depth] = i
            recursiveSequence(arr,depth + 1)
        }
    }

    recursiveSequence(arr,0)
    print(builder)
    
}
