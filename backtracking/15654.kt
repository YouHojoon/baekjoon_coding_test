fun main(){
    val (n,m) = readLine()!!.split(" ").map{it.toInt()}
    val arr = readLine()!!.split(" ").map{it.toInt()}.sorted()
    val builder = StringBuilder()

    fun seq(arr: List<Int>, depth: Int, ans: IntArray){
        if(depth == m){
            builder.appendLine(ans.joinToString(" "))
            return
        }

        for(i in arr){
            ans[depth] = i
            seq(arr.filter { it != i },depth + 1, ans)
        }
    }
    seq(arr,0, IntArray(m))
    print(builder)
}
