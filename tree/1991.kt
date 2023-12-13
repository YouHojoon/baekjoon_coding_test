fun preOrder(lc: CharArray, rc: CharArray, i: Char){
    print(i)
    val index = i.code - 'A'.code
    if(lc[index] != '.')
        preOrder(lc, rc, lc[index])
    if(rc[index] != '.')
        preOrder(lc, rc, rc[index])
}
fun inOrder(lc: CharArray, rc: CharArray, i: Char){
    val index = i.code - 'A'.code
    if(lc[index] != '.')
        inOrder(lc, rc, lc[index])
    print(i)
    if(rc[index] != '.')
        inOrder(lc, rc, rc[index])
}
fun postOrder(lc: CharArray, rc: CharArray, i: Char){
    val index = i.code - 'A'.code
    if(lc[index] != '.')
        postOrder(lc, rc, lc[index])
    if(rc[index] != '.')
        postOrder(lc, rc, rc[index])
    print(i)
}
fun main(){
    val lc = CharArray(26)
    val rc = CharArray(26)

    for(i in 0 until readLine()!!.toInt()){
        val (p, l, r) = readLine()!!.split(" ")

        lc[p[0] - 'A'] = l[0]
        rc[p[0] - 'A'] = r[0]
    }

    preOrder(lc,rc,'A')
    println()
    inOrder(lc,rc,'A')
    println()
    postOrder(lc,rc,'A')
}
