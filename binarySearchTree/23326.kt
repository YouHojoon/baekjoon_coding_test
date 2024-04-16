import java.util.StringTokenizer
import java.util.TreeSet

fun main() = with(System.`in`.bufferedReader()){
    val (n,q) = readLine().split(" ").map { it.toInt() }
    val landmarks = TreeSet<Int>()

    readLine()
        .split(" ")
        .withIndex()
        .filter { it.value == "1" }
        .map{it.index }
        .toCollection(landmarks)

    var cur = 0
    val sb = StringBuilder()

    repeat(q){
        val st = StringTokenizer(readLine())

        when(st.nextToken()){
            "1" -> {
                val n = st.nextToken().toInt() - 1
                if (landmarks.contains(n))
                    landmarks.remove(n)
                else
                    landmarks.add(n)
            }
            "2" -> {
                cur += st.nextToken().toInt()
                if(cur > n)
                    cur %= n
            }
            "3" -> {
                when{
                    landmarks.contains(cur) -> sb.appendLine(0)
                    landmarks.isEmpty() -> sb.appendLine(-1)
                    else ->{
                        val clockwise = landmarks.higher(cur)
                        if (clockwise != null){
                            sb.appendLine(clockwise - cur)
                        }
                        else{
                            val counterClockwise = landmarks.higher(-1)
                            sb.appendLine(n - cur + counterClockwise)
                        }
                    }
                }
            }
        }
    }

    print(sb)
}
