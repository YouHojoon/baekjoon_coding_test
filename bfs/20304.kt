// 참고 : https://imksh.com/47
fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val m = readLine().toInt()
    val ps = readLine().split(" ").map { it.toInt() }

    val visited = IntArray(1_000_001){-1}
    val queue = ArrayDeque<Int>()
    ps.forEach {
        visited[it] = 0
        queue.add(it)
    }

    while (queue.isNotEmpty()){
        val x = queue.removeFirst()

        for (i in 0 until 20){
            val nx = (1 shl i) xor x //1을 k번 쉬프트 연산하여 xor연산하면 안전거리 1차이나는 비밀번호 후보를 얻을 수 있다
            if (nx > n || visited[nx] != -1)
                continue
            visited[nx] = visited[x] + 1
            queue.add(nx)
        }
    }

    print(visited.max())

}
