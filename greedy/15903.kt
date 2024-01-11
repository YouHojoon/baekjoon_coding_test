import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()){
    val (n,m) = readLine().split(" ").map { it.toLong() }
    val queue = PriorityQueue<Long>()
    readLine().split(" ").map { it.toLong() }.forEach { queue.add(it) }

    for (i in 0 until m){
        val c1 = queue.poll()
        val c2 = queue.poll()

        for (j in 0 until 2)
            queue.offer(c1 + c2)
    }

    print(queue.sum())
}
