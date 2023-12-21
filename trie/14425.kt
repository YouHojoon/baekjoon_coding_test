fun c2i(c: Char): Int{
    return c.code - 'a'.code
}
 class Trie{
    private val root = 1
    private val mx = 10000 * 500 + 5 // 글자의 개수
    private val chk = BooleanArray(mx)
    private val nxt = Array(mx){IntArray(26){-1}} // 알파벳 26개여서
    private  var unused = 2

    fun insert(s: String){
        var cur = root
        for(c in s){
            if(nxt[cur][c2i(c)] == -1)
                nxt[cur][c2i(c)] = unused++
            cur = nxt[cur][c2i(c)]
        }
        chk[cur] = true
    }

     fun find(s: String): Boolean{
         var cur = root
         for (c in s){
             if (nxt[cur][c2i(c)] == -1)
                 return false
             cur = nxt[cur][c2i(c)]
         }
         return chk[cur]
     }

     fun erase(s:String){
         var cur = root
         for (c in s){
             if(nxt[cur][c2i(c)] == -1)
                 return
             cur = nxt[cur][c2i(c)]
         }
         chk[cur] = false
     }
}


fun main(){
    val (n,m) = readLine()!!.split(" ").map { it.toInt() }
    val s = Trie()
    var cnt = 0

    for (i in 0 until n)
        s.insert(readLine()!!)

    for (i in 0 until m){
        if(s.find(readLine()!!))
            cnt++
    }

    print(cnt)
}
