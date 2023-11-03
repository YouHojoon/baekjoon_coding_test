fun binarySearch(n: Int, numbers: IntArray): Int{
    var start = 0
    var end = numbers.count()
    
    
    while(start < end){
        val mid = (start + end) / 2
        
        if(numbers[mid] < n){
            start = mid + 1
        }
        else{
            end = mid
        }
    }
    
    val lb = end
    
    start = 0
    end = numbers.count()
    
    while(start < end){
         val mid = (start + end) / 2
        
        if(numbers[mid] <= n){
            start = mid + 1
        }
        else{
            end = mid
        }
    }
    
    return end - lb
}


fun main(){
    readLine()!!
    val cards = readLine()!!.split(" ").map{it.toInt()}.sorted().toIntArray()
    readLine()!!
    
    print(
        readLine()!!.split(" ").map{it.toInt()}.map{
        binarySearch(it, cards)}.joinToString(" ")
    )
}
