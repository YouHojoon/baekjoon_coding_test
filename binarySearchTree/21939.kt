import java.util.StringTokenizer
import java.util.TreeMap
import java.util.TreeSet

fun main() = with(System.`in`.bufferedReader()){
    val diff  = IntArray(100001)
    val numbers = TreeSet<Int>{o1,o2 ->
        val d =  diff[o1] - diff[o2]
        if (d == 0)
            o1 - o2
        else
            d
    }

    val sb = StringBuilder()
    repeat(readLine().toInt()){
        val (n,p) = readLine().split(" ").map { it.toInt() }
        diff[n] = p
        numbers.add(n)
    }

    repeat(readLine().toInt()){
        val st = StringTokenizer(readLine())

        val op = st.nextToken()
        when(op){
            "add" -> {
                val n = st.nextToken().toInt()
                val p = st.nextToken().toInt()
                diff[n] = p
                numbers.add(n)
            }
            "solved" -> {
                val n = st.nextToken().toInt()
                numbers.remove(n)
                diff[n] = 0
            }
            "recommend" ->{
                val x = st.nextToken().toInt()
                if (x == 1)
                    sb.appendLine(numbers.last())
                else
                    sb.appendLine(numbers.first())
            }
        }
    }

    print(sb)
}
