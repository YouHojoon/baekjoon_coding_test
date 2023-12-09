fun main(){
    val (n,m) = readLine()!!.split(" ").map{it.toInt()}
    val arr = readLine()!!.split(" ").map{it.toInt()}.sorted()
    val ans = IntArray(m)
    val builder = StringBuilder()
    
    fun seq(arr: List<Int>, depth: Int){
        if(depth == m){
            builder.appendLine(ans.joinToString(" "))
            return
        }
        
        for(i in arr){
            if(depth == 0 || ans[depth - 1] < i){
                ans[depth] = i
                seq(arr,depth+1)
            }   
        }
    }
    
    seq(arr,0)
    print(builder)
}
