fun main(){
    var (n,k) = readLine()!!.split(" ").map{it.toInt()}
    val coins = IntArray(n){readLine()!!.toInt()}.filter{it <= k}.reversed()
    var cnt = 0
    
    for(coin in coins){
        cnt += k / coin
        k %= coin
    }
    
    print(cnt)
}
