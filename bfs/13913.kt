import java.util.Queue
import java.util.LinkedList
import java.util.Stack

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val prev = IntArray(100_001){-1}
    prev[n] = 0

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(n,0))


    while (queue.isNotEmpty()){
        val (cur,t) = queue.poll()

        if (cur == k) {
            println(t)
            break
        }

        if (cur + 1 in 0 .. 100_000 && prev[cur + 1] == -1) {
            prev[cur + 1] = cur
            queue.add(Pair(cur + 1, t + 1))
        }

        if (cur - 1 in 0 .. 100_000  && prev[cur - 1] == -1) {
            queue.add(Pair(cur - 1, t + 1))
            prev[cur - 1] = cur
        }

        if(2 * cur in 0 .. 100_000 && prev[cur * 2] == -1) {
            queue.add(Pair(cur * 2, t + 1))
            prev[cur * 2] = cur
        }
    }

    val stack = Stack<Int>()
    var cur = k

    while (cur != n) {

        stack.push(cur)
        cur = prev[cur]
    }

    stack.push(n)

    while (stack.isNotEmpty())
        print("${stack.pop()} ")
}
