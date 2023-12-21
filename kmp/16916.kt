import kotlin.system.exitProcess

fun failure(s: String): IntArray{
    val res = IntArray(s.length)
    var j = 0

    for(i in 1 until res.size){
        while (j > 0 && s[i] != s[j])
            j = res[j-1]

        if (s[i] == s[j])
            res[i] = ++j
    }

    return res
}

fun main(){
    val s = readLine()!!
    val p = readLine()!!

    val fail = failure(p)
    var j = 0

    for(i in 0 until s.length){
        while (j > 0 && s[i] != p[j])
            j = fail[j-1]
        if (s[i] == p[j])
            j++
        if (j == p.length) {
            print(1)
            exitProcess(0)
        }
    }

    print(0)
}
