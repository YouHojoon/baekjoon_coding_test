fun cond(chars: CharArray): Boolean{
    var vowel = 0
    var consonant = 0
    val vowels = arrayOf('a','e','i','o','u')
    
    for (c in chars){
        if (c in vowels)
            vowel++
        else
            consonant++
    }

    return vowel >= 1 && consonant >= 2
}


fun main(){
    val (l, c) = readLine()!!.split(" ").map{it.toInt()}
    val chars = readLine()!!.replace(" ","").toCharArray().sorted()
    val tmp = CharArray(l)
    val builder = StringBuilder()

    fun predict(index: Int, depth: Int){
        if(depth == l){
            if (cond(tmp))
                builder.appendLine(tmp.joinToString(""))
            return
        }

        for(i in index until chars.size){
            tmp[depth] = chars[i]
            predict(i+1, depth+1)
        }
    }

    predict(0,0)
    print(builder)
}
