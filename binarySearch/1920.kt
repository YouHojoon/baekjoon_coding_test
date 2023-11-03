import javax.swing.text.EditorKit

fun binarySearch(n: Int, numbers: List<Int>): Int{
    var start = 0
    var end = numbers.count() - 1

    while(start <= end){
        val mid = (start + end) / 2
        val number = numbers[mid]

        if(number == n)
            return 1
        else if(number > n)
            end = mid -1
        else
            start = mid + 1
    }

    return 0
}

fun main(){
    readLine()!!.toInt()
    val numbers = readLine()!!.split(" ").map{it.toInt()}.sorted()
    readLine()!!.toInt()

    for(i in readLine()!!.split(" ").map{it.toInt()}){
        println(binarySearch(i,numbers))
    }
}
