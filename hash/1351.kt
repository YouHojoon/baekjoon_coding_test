import java.io.BufferedReader
import java.io.InputStreamReader

fun HashMap<Long,Long>.infinitySequence(i: Long, p: Long, q:Long): Long{
    val lhs = i / p
    val rhs = i / q

    if (this[i] == null)
        this[i] = this.infinitySequence(lhs, p,q) + this.infinitySequence(rhs,p,q)

    return this[i]!!
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n,p,q) = readLine().split(" ").map { it.toLong() }
    val hash = HashMap<Long,Long>()
    hash[0] = 1

    print(hash.infinitySequence(n,p,q))
}
