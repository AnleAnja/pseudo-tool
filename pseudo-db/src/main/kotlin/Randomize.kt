import kotlin.random.Random

val vowels = listOf("a", "e", "i", "o", "u")
val consonants = listOf(
    "b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"
)

fun randomString(): String {
    val random = Random.Default
    val nameBuilder = StringBuilder()

    for (i in 1..6) {
        val isVowel = random.nextBoolean()

        if (isVowel) {
            val vowel = vowels[random.nextInt(vowels.size)]
            nameBuilder.append(vowel)
        } else {
            val consonant = consonants[random.nextInt(consonants.size)]
            nameBuilder.append(consonant)
        }
    }
    return nameBuilder.toString()
}

fun randomName(input: String): String {
    if (input.isBlank()) {
        return input
    }

    val firstChar = input[0].toUpperCase()
    val remainingChars = input.substring(1)

    return "$firstChar$remainingChars"
}

fun randomEmail(firstname: String, lastname: String): String = "$firstname.$lastname@th-koeln.de"

fun randomRegistration() = Random.Default.nextLong(99999999 - 10000000 + 1) + 10000000

fun randomId(): String {
    val random = Random.Default
    val randomNumbers = (1..5).joinToString("") { random.nextInt(0, 10).toString() }
    return "id$randomNumbers"
}
