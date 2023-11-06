fun main(){
    readLine()!!
    val cards = readLine()!!.split(" ").map { it.toInt() }.sorted()
    readLine()!!.toInt()

    print(
        readLine()!!.split(" ")
            .map { it.toInt() }
            .map {
            var s = 0
            var e = cards.count() - 1
            var result = 0
            while (s <= e){
                val mid = (s+e)/2
                if(cards[mid] < it)
                    s = mid + 1
                else if(cards[mid] == it) {
                    result = 1
                    break
                }
                else
                    e = mid - 1

            }
            result
        }.joinToString(separator = " ") { it.toString()}
    )
}
