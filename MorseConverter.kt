package com.example.morsecodeconverter

object MorseConverter {
    private val textoAMorse = hashMapOf<Char, String>()
    private val morseATexto = hashMapOf<String, Char>()

    init {
        val morseMap = mapOf(
            'A' to ".-", 'B' to "-...", 'C' to "-.-.", 'D' to "-..", 'E' to ".",
            'F' to "..-.", 'G' to "--.", 'H' to "....", 'I' to "..", 'J' to ".---",
            'K' to "-.-", 'L' to ".-..", 'M' to "--", 'N' to "-.", 'O' to "---",
            'P' to ".--.", 'Q' to "--.-", 'R' to ".-.", 'S' to "...", 'T' to "-",
            'U' to "..-", 'V' to "...-", 'W' to ".--", 'X' to "-..-", 'Y' to "-.--",
            'Z' to "--..", '1' to ".----", '2' to "..---", '3' to "...--", '4' to "....-",
            '5' to ".....", '6' to "-....", '7' to "--...", '8' to "---..", '9' to "----.",
            '0' to "-----"
        )

        textoAMorse.putAll(morseMap)
        morseMap.forEach { (key, value) -> morseATexto[value] = key }
    }

    fun convertirTextoAMorse(texto: String): String {
        return texto.uppercase().map { c ->
            if (c == ' ') "   "
            else textoAMorse[c] ?: "?"
        }.joinToString(" ")
    }

    fun convertirMorseATexto(morse: String): String {
        return morse.trim().split("   ").joinToString(" ") { palabra ->
            palabra.split(" ").map { letra ->
                morseATexto[letra] ?: '?'
            }.joinToString("")
        }
    }
}
