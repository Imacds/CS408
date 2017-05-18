

fun main(args: Array<String>) {
	
	/* TEST COMPLEX NUMBER CLASS */
	println("COMPLEX NUMBER CLASS")
	println("---------------------------")
    var x = ComplexNum(2.0, -4.0)
    var y = ComplexNum(4.0)
    var z = ComplexNum(b=3.0)
    println("(X + Z) -> " + (x + z))
	println("(X/Y + Z) -> " + (x/y + z))
	
	
	/* TEST SMART CASTING */
	println("\nSMART CASTING")
	println("---------------------------")
	print("Enter a string or a number: ")
//	var userInput : String? = readLine()
//	testSmartCast(userInput)
	
//	if (str is String) {
//		var str2 : Double? = str.toDoubleOrNull()
//		
//		if (str2 is Double) {
//			println(str2 + str2)
//		}
//	}
	
	
	// null safety
	

	
	
    // NULL COALESCING
	print("\nIf title is null, the supplied title is: ")
	var suppliedTitle = null
	val title = suppliedTitle ?: "Default title"
	println(title)
	
	
	
//	println("Enter whatever: ")
//	var isThisAString : String?
//	isThisAString = null
//	isThisAString = readLine()
//	
//	println(isThisAString)
}

// This function tests Smart Casting
fun testSmartCast(anyVar : Any) {
	if (anyVar is String) {
		var anyVarDouble : Double? = anyVar.toDoubleOrNull()
		
		if (anyVarDouble is Double) {
			println(anyVarDouble + anyVarDouble)
		}
	}
}