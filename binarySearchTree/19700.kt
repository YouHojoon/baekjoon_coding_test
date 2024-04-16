import java.util.StringTokenizer
import java.util.TreeMap
import java.util.TreeSet

data class Team(
    var member: Int,
    val maxHeight: Int
): Comparable<Team>{
    override fun compareTo(other: Team): Int {
        if (member == other.member)
            return maxHeight - other.maxHeight
        return member - other.member
    }
}


fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val teams = TreeSet<Team>()
    val students = Array(n){0 to 0}

    repeat(n){
        val (h,k) = readLine().split(" ").map { it.toInt() }
        students[it] = k to h
    }

    for (student in students.sortedWith(compareBy({-it.second}, {-it.first}))){
        if(teams.isEmpty()){
            teams.add(Team(1, student.second))
            continue
        }

        val tmp = teams.lower(Team(student.first, student.second))
        if (tmp == null)
            teams.add(Team(1,student.second))
        else
            tmp.member++
    }

    print(teams.size)
}
