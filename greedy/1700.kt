import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n,k) = readLine().split(" ").map { it.toInt() }
    val sch = HashMap<Int, ArrayDeque<Int>>()
    val plugs = HashSet<Int>()
    val queue = ArrayDeque<Int>()

    for (i in 0 .. k)
        sch[i] = ArrayDeque()

    val st = StringTokenizer(readLine())
    var cnt = 0

    while (st.hasMoreTokens()){
        val k = st.nextToken().toInt()
        queue.add(k)
        sch[k]!!.add(cnt)
        cnt++
    }
    
    cnt = 0
    for (i in 0 until k){
        val device = queue.removeFirst()
        sch[device]!!.removeFirst()
        if (plugs.size < n)
            plugs.add(device)
        else if (!plugs.contains(device)){
            val victim = plugs.map {
                val queue = sch[it]!!
                if (queue.isEmpty())
                    it to Int.MAX_VALUE
                else
                    it to queue[0]
            }.maxBy { it.second }
            plugs.remove(victim.first)
            plugs.add(device)
            cnt++
        }
    }

    print(cnt)
}
