public int FibonacciWithFactors(int nFib, int nFact) {
	if (nFact < 0) { // Calculating Fibonacci series
		if (nFib == 0) {return 0;}
		if (nFib == 1) {return 1;}
		return FibonacciWithFactors(nFib - 1, -1) + FibonacciWithFactors(nFib - 2, -1);
	} else if (nFib < 0) { // Calculating factorial
		if (nFact == 0) {return 1;}
		return nFact*FibonacciWithFactors(-1, nFact - 1);
	}
}

// int resultFib  = FibonacciWithFactors(n ,        -1);
// int resultFact = FibonacciWithFactors(-1, resultFib);

FibonacciWithFactors(n, FibonacciWithFactors(n, -1));

////////////////////////////////////////////////////////////////////////////////////////////////

fibonacci(n){
	if n == 0
		return 0
	if n == 1
		return 1
	return fibonacci(n-1) + fibonacci(n-2);
}

factorial(n){
	if n == 0
		return 1
	return n * factorial(n-1);
}

////////////////////////////////////////////////////////////////////////////////////////////////

public static long fibonacciWithFactors (long n, int status) {
 if (status == 0) {
 if (n <= 1) {
 return 1;
 }
 n = fibonacciWithFactors (n - 1, 1) + fibonacciWithFactors (n - 2, 1);
 }
 else if (status == 1) {
 if (n <= 1) {
 return n;
 }
 return fibonacciWithFactors (n - 1, 1) + fibonacciWithFactors (n - 2, 1);
 }
 if (n <= 1) {
 return 1;
 }
 return fibonacciWithFactors (n - 1, 3) * n;
}