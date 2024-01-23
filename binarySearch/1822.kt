fun main() = with(System.`in`.bufferedReader()){
    val (n1,n2) = readLine().split(" ").map { it.toInt() }
    val a = readLine().split(" ").map { it.toInt() }
    val b = readLine().split(" ").map { it.toInt() }.sorted()
    val ans = mutableListOf<Int>()

    for (i in a){
        if (b.binarySearch(i) < 0){
            ans.add(i)
        }
    }

    println(ans.size)
    print(ans.sorted().joinToString(" "))
}
