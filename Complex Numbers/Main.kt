fun main(args: Array<String>) {
	
	println("Complex Numbers Test")
	println("--------------------")
	/* Code in comparison to Java's */
	var first = ComplexNum(4.0, 5.0)
	var second = ComplexNum(2.0, 1.0)
	var third = first + second
	println(third.toString())
	
	/*******************************/
	
	var x = ComplexNum(2.0, -4.0)
	var y = ComplexNum(4.0)
	var z = ComplexNum(b = 3.0)
	
	println("(X + Z) -> " + (x + z))
	println("(X/Y + Z) -> " + (x/y + z))
	println("--------------------\n")
	
	/* Other tests to show Kotlin's flexibility */
	// Smart Casting
	println("Smart Casting")
	println("--------------------")
	print("Enter a string or number: ")
	var userInput = readLine()
	if (userInput is String) {
		var userInput2 = userInput.toDoubleOrNull()
		if (userInput2 is Double) {
			println("You entered a number and that number times 2 is: " + (userInput2 * 2))
		}
		else {
			println("You entered a string saying: " + userInput)
		}
	}
	println("--------------------")
	
	// Null Coalescing
	println("Null Coalescing")
	println("--------------------")
	var a : String = "Hello"
	var b : String? = "Hello"
	// a = null (compilation error)
	b = null
	val greeting = b ?: "Default greeting"
	println(greeting)
	println("--------------------")
}
