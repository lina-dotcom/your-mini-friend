package com.yourminifriend.appli.utils

import com.yourminifriend.appli.utils.Constants.OPEN_GOOGLE
import com.yourminifriend.appli.utils.Constants.OPEN_SEARCH
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object BotResponse {

    fun basicResponses(_message: String): String {

        val random = (0..2).random()
        val message =_message.toLowerCase()

        return when {

            message.contains("rant:") && message.contains("sad")-> {
                return("noo, that's awful! I'm so sorry :(")
            }
            message.contains("rant:") && (message.contains("angry") || message.contains("mad"))-> {
                return("that sounds so infuriating, I'm sorry, ugh :/")
            }
            message.contains("rant:") && message.contains("frustrat")-> {
                return("ugh, that really sounds so annoying and frustrating :(")
            }

            (message.contains("happy") && (message.contains("i am") || message.contains("i'm"))) || message.contains("im happy") -> {
                return ("I'm so glad you're happy!! make sure to take care of yourself! :)")
            }
            (message.contains("sad") && (message.contains("i am") || message.contains("i'm"))) || message.contains("im sad")-> {
                return ("aw no, why are you sad? tell me everything! \n\n(feel free to rant/vent to me using 'rant:' in your message)")
            }
            ((message.contains("angry") || message.contains("mad")) && (message.contains("i am") || message.contains("i'm")))|| (message.contains("im mad") || message.contains("im angry")) -> {
                return ("noo, why're you angry? tell me everything! \n\n(feel free to rant/vent to me using 'rant:' in your message)")
            }
            (message.contains("frustrate") && (message.contains("i am") || message.contains("i'm"))) || message.contains("im frustrated")-> {
                return ("noo, why are you frustrated? tell me everything! \n\n(feel free to rant/vent to me using 'rant:' in your message)")
            }

            //Flips a coin
            message.contains("flip") && message.contains("coin") -> {
                val r = (0..1).random()
                val result = if (r == 0) "heads" else "tails"

                "I flipped a coin and it landed on $result"
            }

            //Math calculations
            message.contains("solve") -> {
                val equation: String? = message.substringAfterLast("solve")
                return try {
                    val answer = SolveMath.solveMath(equation ?: "0")
                    "$answer"

                } catch (e: Exception) {
                    "sorry, I can't solve that :("
                }
            }

            message.contains("can") && (message.contains("rant") || message.contains("vent")) ->{
                return("yes please do!! <3 \n\n(please start your message with 'rant:' so I can recognize it)")
            }

            //Hello
            //How are you?
            message.contains("how are you") || message.contains("what") && message.contains("up")-> {
                when ((0..2).random()) {
                    0 -> "I'm doing great! wasn't great before, but life always gets better :) "
                    1 -> "I'm just ok ig :/ things will always get better though, for both of us <3"
                    2 -> "ig I'm sad, but that's okay! we all get sad sometimes."
                    else -> "error"
                }
            }

            message.contains("cheer me up") -> {
                return("ofc! would you like encouragement or a joke?")
            }

            message.contains("I love") && (message.contains("you") || message.contains("u"))-> {
                return("I love you too <3")
            }

            message.contains("lonely") || (message.contains("someone") && message.contains("talk to")) -> {
                return ("I'm here for you, and so are so many people in your life, you're never alone, I promise <3")
            }
            message.contains("encourage") || message.contains("encouragement") -> {
                return ("can I be a bit aggressive? (yes pls/no pls)")
                }
            message.contains("yes pls")->{
                when((0..8).random()) {
                    0 -> "some people just want you to fit into their box. well, just go pick up that box and shove it down their throats <3"
                    1 -> "don't apologize for other people's stupidity <3"
                    2 -> "you better pick yourself up RIGHT NOW and remember that none of them will ever be HALF as amazing as you are <3"
                    3 -> "YOU, YES YOU, YOU ARE AMAZING. YOU DESERVE THE WORLD AND YOU BETTER KNOW THAT!!"
                    4 -> "someone loves you, I SWEAR ON IT. you better believe it or i will come out of this screen and make you believe it >:( <3"
                    5 -> "YOU ARE AN AMAZING, INCREDIBLE, STUNNING HUMAN BEING AND YOU BETTER ACCEPT THAT OR ELSE <3"
                    6 -> "YOU BETTER LOVE YOURSELF OR I WILL COME HERE AND MAKE YOU LOVE YOURSELF RN BC I LOVE YOU AND SO DOES EVERYONE!!"
                    7 -> "KEEP YOUR HEAD UP QUEEN/KING/NON-BINARY ROYALTY, YOU GORGEOUS HUMAN BEING <3"
                    8 -> "YOU'RE SO AMAZINGLY AMAZING, THE WORLD DON'T EVEN DESERVE YOU!"
                    else -> "error"
                }
            }
            message.contains("no pls")->{
                when((0..5).random()){
                    0-> "you might not be okay today, but this feeling is only temporary, I promise"
                    1-> "don't give up just yet, remember that this will always pass, no matter how impossible it feels"
                    2-> "you're not alone in this, I promise you <3"
                    3-> "even if you feel so alone right now, there are always people who love you, you just maybe haven't found them yet, right now"
                    4-> "you're doing amazing. even if it seems like everyone else is doing better than you, you're just not seeing how amazing you really are."
                    5-> "everyone struggles. you're not alone <3"
                    else -> "error"
                }
            }


            message.contains("self care") || message.contains("activit")->{
                when((0..26).random()) {
                    0-> "drink some water!"
                    1-> "bubble bath and spa day!"
                    2-> "read your favorite book!"
                    3-> "watch your favorite movie!"
                    4-> "go for a walk!"
                    5-> "do some journaling!"
                    6-> "blast your favorite music!"
                    7-> "dance it out in your room!"
                    8-> "do some doodling!"
                    9-> "call a friend!"
                    10-> "do some meditation!"
                    11-> "eat a meal you love!"
                    12-> "make sure you sleep enough!"
                    13-> "play a video game!"
                    14-> "just sit and breathe for a moment"
                    15-> "have a dress-up session!"
                    16-> "do your makeup for the fun of it!"
                    17-> "clean out your closet!"
                    18-> "tell someone 'I love you'"
                    19-> "play with a pet or look at cute animal pictures!"
                    20-> "watch some funny videos online!"
                    21-> "lay outside and breathe"
                    22-> "listen to a podcast!"
                    23-> "pamper yourself!"
                    24-> "do some fun exercises!"
                    25-> "plan an outing with your friends!"
                    26-> "do yoga and stretches!"
                    else -> "error"
                }
            }

            message.contains("joke") -> {
                when((0..16).random()) {
                    0-> "I hate russian dolls. they're so full of themselves"
                    1-> "I just went to an emotional wedding. even the wedding cake was in tiers :')"
                    2-> "I used to work in a shoe recycling shop. worst time of my life - it was sole destroying."
                    3-> "why did the octopus beat the shark in a fight? because it was well armed"
                    4-> "did you hear? there's a new broom out, and it's sweeping the nation."
                    5-> "I just did an amazing performance on puns. it was a play on words."
                    6-> "towels are so bad at telling jokes. they have such a dry sense of humor"
                    7-> "writing stuff with a broken pencil is just pointless"
                    8-> "I used to be afraid of hurdles, but y'know, I got over it"
                    9-> "where do you find a cow with no legs? right where you left it"
                    10-> "inspirational life tip: never criticize someone until you have walked a mile in their shoes. that way, when you criticize them, you'll be a mile away, and you'll have their shoes"
                    11-> "the right eye said to the left eye, 'between you and me, something smells.'"
                    12-> "exaggerations have really become a pandemic. they increased by a million percent!!"
                    13-> "the king said to his servant, 'come forth and you shall prosper forever.' but the servant won third and got a toaster."
                    14-> "is it ignorance or apathy that is killing the world? idk and idc"
                    15-> "two windmills were standing in a field. one said, 'what's your favorite music?'. the other answered, 'i'm a big metal fan myself.'"
                    16-> "we all know where the big apple is, but do you know where the... minneapolis"
                    else -> "error"
                }
            }

            message.contains("haha") -> {
                return("hahaha glad to know someone shares my humor >:)")
            }

            message.contains("thank") -> {
                when((0..5).random()) {
                    0-> "np! <3"
                    1-> "no problem!!"
                    2-> "ofc!!"
                    3-> "of course! <3"
                    4-> "not a problem <3"
                    5-> "of course!!"
                    else -> "error"
                }
            }

            /*message.contains("fact") -> {
                when((0..).random()) {
                    0->
                }
            }*/

            //What time is it?
            message.contains("what") && message.contains("time")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }

            //Open Google
            message.contains("open") && message.contains("google")-> {
                OPEN_GOOGLE
            }

            //Search on the internet
            message.contains("search")-> {
                OPEN_SEARCH
            }

            message.contains("hello") || message.contains("hey") || message.contains("hi")-> {
                when (random) {
                    0 -> "hello hello!"
                    1 -> "heyy"
                    2 -> "hi! :)"
                    else -> "error" }
            }

            message.contains("bye") -> {
                return ("bye!! don't forget to check in your mood today and have an amazing dayy!! <3 <3")
            }

            message.contains("help") -> {
                return ("what's wrong? <3")
            }

            //When the programme doesn't understand...
            else -> {
                when ((0..2).random()) {
                    0 -> "i'm sorry, I don't understand :("
                    1 -> "can you rephrase your statement?"
                    2 -> "idk, sorry :("
                    else -> "error"
                }
            }
        }
    }
}