import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val truth = readLine().split(" ").map { it.toInt() }.drop(1)
    val graphOfParty = Array(m){ mutableListOf<Int>() }
    val graphOfMember = Array(n+1){ mutableListOf<Int>() }
    val canVisit = BooleanArray(m){true}

    repeat(m){partyIndex ->
        for (i in readLine().split(" ").map { it.toInt() }.drop(1)){
            graphOfParty[partyIndex].add(i)
            graphOfMember[i].add(partyIndex)
        }
    }
    val queue = ArrayDeque<Int>()
    truth.toCollection(queue)

    while (queue.isNotEmpty()){
        val cur = queue.removeFirst()

        for (i in graphOfMember[cur]){
            if (!canVisit[i])
                continue

            canVisit[i] = false
            graphOfParty[i].toCollection(queue)
        }
    }

    print(canVisit.filter { it }.size)
}
