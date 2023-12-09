fun main(){
    val (n,m) = readLine()!!.split(" ").map{it.toInt()}
    val arr = IntArray(m)
    val builder = StringBuilder()

    fun sequence(arr: IntArray, depth: Int, num: Int){
        if(depth == m){
            builder.appendLine(arr.joinToString(" "))
            return
        }

        for(i in num .. n){
            arr[depth] = i
            sequence(arr, depth + 1, i)
        }
    }

    sequence(arr,0,1)
    print(builder)
}
