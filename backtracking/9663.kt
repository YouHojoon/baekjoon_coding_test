// row에 퀸을 놓는다.
fun find(row: Int, n: Int, used1: BooleanArray, used2: BooleanArray, used3: BooleanArray): Int{
    if(row == n){
        return 1
    }
    
    var result = 0
    
    for(x in 0 until n){
        if(used1[x] || used2[x + row] || used3[row - x + n - 1])
            continue
        used1[x] = true
        used2[x + row] = true
        used3[row - x + n - 1] = true
        result += find(row + 1, n, used1,used2,used3)
        used1[x] = false
        used2[x + row] = false
        used3[row - x + n - 1] = false
    }
    
    return result
}

fun main(){
    val n = readLine()!!.toInt()
    val used1 = BooleanArray(15)
    val used2 = BooleanArray(31) // 왼 대각
    val used3 = BooleanArray(31) // 오른 대각
    
    print(find(0,n,used1,used2,used3))
}
