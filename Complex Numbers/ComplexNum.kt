class ComplexNum(a: Double = 0.0) : Number() {
	
	// Real property
	var real: Double
	// Imaginary property
	var imaginary: Double = 0.0
	
	// Primary constructor, initializes the real element
	init {
		real = a
	}
	
	// Secondary constructor, initializes the imaginary element if provided
	constructor(a: Double = 0.0, b: Double) : this(a) {
		imaginary = b
	}
	
	constructor(a: Number, b: Number) : this(a.toDouble(), b.toDouble())

	// Higher order function, takes in the "op" function as a parameter and does it on reals and imaginaries
	private fun doOpOnBoth(other: ComplexNum, op: Double.(Double) -> Double): ComplexNum {
		return ComplexNum(real.op(other.real), (imaginary.op(other.imaginary)))
	}

	operator fun minus(other: ComplexNum): ComplexNum {
		return doOpOnBoth(other, (Double::minus))
	}

	operator fun plus(other: ComplexNum): ComplexNum {
		return doOpOnBoth(other, (Double::plus))
	}
    
	operator fun times(other: ComplexNum): ComplexNum {
		return ComplexNum(real * other.real - imaginary * other.imaginary, real * other.imaginary + imaginary * other.real)
	}
   
	operator fun div(other: ComplexNum): ComplexNum {
		val denom = other.real * other.real + other.imaginary * other.imaginary
		val realNum = real * other.real + imaginary * other.imaginary
		val imagNum = imaginary * other.real + real * other.imaginary
		return ComplexNum(realNum/denom, imagNum/denom)
	}

	override fun toString(): String {
		return "" + real + " + " + imaginary + "i"
	}
	
	override fun toByte(): Byte {
		return real.toByte()
	}
	
	override fun toChar() : Char {
		return real.toChar()
	}
	
	override fun toDouble() : Double {
		return real
	}
	
	override fun toInt() : Int {
		return real.toInt()
	}
	
	override fun toLong() : Long {
		return real.toLong()
	}
	
	override fun toShort() : Short {
		return real.toShort()
	}
	
	override fun toFloat() : Float {
		return real.toFloat()
	}
    
}
