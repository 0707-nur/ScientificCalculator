@file:Suppress("EqualsBetweenInconvertibleTypes")

package com.example.scientificcalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.scientificcalculator.databinding.ActivityMainBinding
import java.lang.Math.toRadians
import kotlin.math.cos
import kotlin.math.ln
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.math.tan

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            binding.TVprimary.text = (binding.TVprimary.text.toString() + "1")
        }
        binding.button2.setOnClickListener {
            binding.TVprimary.text = (binding.TVprimary.text.toString() + "2")
        }
        binding.button3.setOnClickListener {
            binding.TVprimary.text = (binding.TVprimary.text.toString() + "3")
        }
        binding.button4.setOnClickListener {
            binding.TVprimary.text = (binding.TVprimary.text.toString() + "4")
        }
        binding.button5.setOnClickListener {
            binding.TVprimary.text = (binding.TVprimary.text.toString() + "5")
        }
        binding.button6.setOnClickListener {
            binding.TVprimary.text = (binding.TVprimary.text.toString() + "6")
        }
        binding.button7.setOnClickListener {
            binding.TVprimary.text = (binding.TVprimary.text.toString() + "7")
        }
        binding.button8.setOnClickListener {
            binding.TVprimary.text = (binding.TVprimary.text.toString() + "8")
        }
        binding.button9.setOnClickListener {
            binding.TVprimary.text = (binding.TVprimary.text.toString() + "9")
        }
        binding.button0.setOnClickListener {
            binding.TVprimary.text = (binding.TVprimary.text.toString() + "0")
        }
        binding.buttonDot.setOnClickListener {
            binding.TVprimary.text = (binding.TVprimary.text.toString() + ".")
        }
        binding.buttonPlus.setOnClickListener {
            binding.TVprimary.text = (binding.TVprimary.text.toString() + "+")
        }
        binding.buttonDiv.setOnClickListener {
            binding.TVprimary.text = (binding.TVprimary.text.toString() + "/")
        }
        binding.buttonBrac1.setOnClickListener {
            binding.TVprimary.text = (binding.TVprimary.text.toString() + "(")
        }
        binding.buttonBrac2.setOnClickListener {
            binding.TVprimary.text = (binding.TVprimary.text.toString() + ")")
        }
        binding.buttonPi.setOnClickListener {
            // on clicking on pi button we are adding
            // pi value as 3.142 to our current value.
            binding.TVprimary.text = (binding.TVprimary.text.toString() + "3.142")
            binding.TVSecondary.text = (binding.buttonPi.text.toString())
        }
        binding.buttonSin.setOnClickListener {
            binding.TVprimary.text = (binding.TVprimary.text.toString() + "sin")
        }
        binding.buttonCos.setOnClickListener {
            binding.TVprimary.text = (binding.TVprimary.text.toString() + "cos")
        }
        binding.buttonTan.setOnClickListener {
            binding.TVprimary.text = (binding.TVprimary.text.toString() + "tan")
        }
        binding.buttonInv.setOnClickListener {
            binding.TVprimary.text = (binding.TVprimary.text.toString() + "^" + "(-1)")
        }
        binding.buttonLn.setOnClickListener {
            binding.TVprimary.text = (binding.TVprimary.text.toString() + "ln")
        }
        binding.buttonLog.setOnClickListener {
            binding.TVprimary.text = (binding.TVprimary.text.toString() + "log")
        }

        binding.buttonMul.setOnClickListener {
            // if mul sign is not present in our
            // text view then only we are adding
            // the multiplication operator to it.
            val str: String = binding.TVprimary.text.toString()
            if (!str.get(index = str.length - 1).equals("*")) {
                binding.TVprimary.text = (binding.TVprimary.text.toString() + "*")
            }
        }

        binding.buttonSqrt.setOnClickListener {
            if (binding.TVprimary.text.toString().isEmpty()) {
                // if the entered number is empty we are displaying an error message.
                Toast.makeText(this, "Please enter a valid number..", Toast.LENGTH_SHORT).show()
            } else {
                val str: String = binding.TVprimary.text.toString()
                // on below line we are calculation
                // square root of the given number.
                val r = sqrt(str.toDouble())
                // on below line we are converting our double
                // to string and then setting it to text view.
                val result = r.toString()
                binding.TVprimary.text = result
            }
        }

        binding.buttonEqual.setOnClickListener {
            val str: String = binding.TVprimary.text.toString()
            // on below line we are calling an evaluate
            // method to calculate the value of expressions.
            val result: Double = evaluate(str)
            // on below line we are getting result
            // and setting it to text view.
            val r = result.toString()
            binding.TVprimary.text = r
            binding.TVSecondary.text = str
        }
        binding.buttonAC.setOnClickListener {
            // on clicking on ac button we are clearing
            // our primary and secondary text view.
            binding.TVprimary.text = ""
            binding.TVSecondary.text = ""
        }
        binding.buttonC.setOnClickListener {
            // on clicking on c button we are clearing
            // the last character by checking the length.
            var str: String = binding.TVprimary.text.toString()
            if (str != "") {
                str = str.substring(0, str.length - 1)
                binding.TVprimary.text = str
            }
        }
        binding.buttonSquare.setOnClickListener {
            if (binding.TVprimary.text.toString().isEmpty()) {
                // if the entered number is empty we are displaying an error message.
                Toast.makeText(this, "Please enter a valid number..", Toast.LENGTH_SHORT).show()
            } else {
                // on below line we are getting the expression and then calculating the square of the number
                val d: Double = binding.TVprimary.text.toString().toDouble()
                // on below line we are calculating the square.
                val square = d * d
                // after calculating the square we
                // are setting it to text view.
                binding.TVprimary.text = square.toString()
                // on below line we are setting
                // the d to secondary text view.
                binding.TVSecondary.text = "$d²"
            }
        }
        binding.buttonFact.setOnClickListener {
            if (binding.TVprimary.text.toString().isEmpty()) {
                // if the entered number is empty we are displaying an error message.
                Toast.makeText(this, "Please enter a valid number..", Toast.LENGTH_SHORT).show()
            } else {
                // on below line we are getting int value
                // and calculating the factorial value of the entered number.
                val value: Int = binding.TVprimary.text.toString().toInt()
                val fact: Int = factorial(value)
                binding.TVprimary.text = fact.toString()
                binding.TVSecondary.text = "$value`!"
            }

        }

    }

    private fun factorial(n: Int): Int {
        // this method is use to find factorial
        return if (n == 1 || n == 0) 1 else n * factorial(n - 1)
    }

    private fun evaluate(str: String): Double {
        return object : Any() {
            // on below line we are creating variable
            // for tracking the position and char pos.
            var pos = -1
            var ch = 0

            // below method is for moving to next character.
            fun nextChar() {
                // on below line we are incrementing our position
                // and moving it to next position.
                ch = if (++pos < str.length) str[pos].code else -1
            }

            // this method is use to check the extra space
            // present int the expression and removing it.
            fun eat(charToEat: Int): Boolean {
                while (ch == ' '.code) nextChar()
                // on below line we are checking the char pos
                // if both is equal then we are returning it to true.
                if (ch == charToEat) {
                    nextChar()
                    return true
                }
                return false
            }

            // below method is to parse our
            // expression and to get the ans
            // in this we are calling a parse
            // expression method to calculate the value.
            fun parse(): Double {
                nextChar()
                val x = parseExpression()
                if (pos < str.length) throw RuntimeException("Unexpected: " + ch.toChar())
                return x
            }

            // in this method we will only perform addition and
            // subtraction operation on the expression.
            fun parseExpression(): Double {
                var x = parseTerm()
                while (true) {
                    if (eat('+'.code)) x += parseTerm() // addition
                    else if (eat('-'.code)) x -= parseTerm() // subtraction
                    else return x
                }
            }

            // in below method we will perform
            // only multiplication and division operation.
            fun parseTerm(): Double {
                var x = parseFactor()
                while (true) {
                    if (eat('*'.code)) x *= parseFactor() // multiplication
                    else if (eat('/'.code)) x /= parseFactor() // division
                    else return x
                }
            }

            // below method is use to parse the factor
            fun parseFactor(): Double {
                //on below line we are checking for addition
                // and subtraction and performing unary operations.
                if (eat('+'.code)) return parseFactor() // unary plus
                if (eat('-'.code)) return -parseFactor() // unary minus
                // creating a double variable for ans.
                var x: Double
                // on below line we are creating
                // a variable for position.
                val startPos = pos
                // on below line we are checking
                // for opening and closing parenthesis.
                if (eat('('.code)) { // parentheses
                    x = parseExpression()
                    eat(')'.code)
                } else if (ch >= '0'.code && ch <= '9'.code || ch == '.'.code) {
                    // numbers
                    while (ch >= '0'.code && ch <= '9'.code || ch == '.'.code) nextChar()
                    // on below line we are getting sub string from our string using start and pos.
                    x = str.substring(startPos, pos).toDouble()
                } else if (ch >= 'a'.code && ch <= 'z'.code) {
                    // on below function we are checking for the operator in our expression.
                    while (ch >= 'a'.code && ch <= 'z'.code) nextChar()
                    val func = str.substring(startPos, pos)
                    // calling a method to parse our factor.
                    x = parseFactor()
                    // on below line we are checking for square root.
                    x =
                        when (func) {
                            "sqrt" -> sqrt(x)
                            // on below line we are checking for sin function
                            // and calculating sin function using Math class.
                            "sin" -> kotlin.math.sin(
                                toRadians(x)
                                // on below line we are calculating the cos value
                            )
                            "cos" -> cos(
                                toRadians(x)
                                // on below line we are calculating
                                // the tan value of our expression.
                            )
                            "tan" -> tan(toRadians(x))
                            // on below line we are calculating
                            // log value of the expression.
                            "log" -> kotlin.math.log10(x)
                            // on below line we are calculating
                            // ln value of expression.
                            "ln" -> ln(x)
                            // f we get any error then
                            // we simply return the exception.
                            else -> throw RuntimeException(
                                "Unknown function: $func"
                            )
                        }
                } else {
                    // if the condition not satisfy then we are returning the exception
                    throw RuntimeException("Unexpected: " + ch.toChar())
                }
                // on below line we are calculating the power of the expression.
                if (eat('^'.code)) x = x.pow(parseFactor()) // exponentiation
                return x
            }
            // at last calling a parse for our expression.
        }.parse()
    }
}