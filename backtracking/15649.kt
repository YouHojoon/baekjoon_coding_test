
fun find(sequence: MutableList<Int>, visited: BooleanArray, n: Int, m: Int){
    if(sequence.count() == m){
        println(sequence.joinToString(" "){it.toString()})
        return
    }

    for(i in 1 .. n){
        if(!visited[i]){
            visited[i] = true
            sequence.add(i)
            find(sequence,visited,n,m)
            visited[i] = false
            sequence.removeLast()
        }
    }
}

fun main(){
    val (n,m) = readLine()!!.split(" ").map{it.toInt()}
    val sequence = mutableListOf<Int>()
    val visited = BooleanArray(n+1)

    find(sequence, visited,n,m)
}
