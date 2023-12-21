fun main(){
    val builder = StringBuilder()
    while(true){
        val s = readLine()!!.split(" ").map{it.toInt()}.toMutableList()

        if(s.removeFirst() == 0)
            break

        s.sort()

        val tmp = IntArray(6)
        fun seq(index: Int, depth: Int){
            if(depth == 6){
                builder.appendLine(tmp.joinToString(" "))
                return
            }

            for(i in index until s.size){
                tmp[depth] = s[i]
                seq(i+1, depth + 1)
            }
        }

        seq(0,0)
        builder.appendLine()
    }
    print(builder)
}
