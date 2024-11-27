// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		System.out.println(plus(2,3));   // 2 + 3
		System.out.println(minus(7,2));  // 7 - 2
		System.out.println(minus(2,7));  // 2 - 7
		System.out.println(times(3,4));  // 3 * 4
		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
		System.out.println(pow(5,3));      // 5^3
		System.out.println(pow(3,5));      // 3^5
		System.out.println(div(12,3));   // 12 / 3    
		System.out.println(div(5,5));    // 5 / 5  
		System.out.println(div(25,7));   // 25 / 7
		System.out.println(mod(25,7));   // 25 % 7
		System.out.println(mod(120,6));  // 120 % 6    		
		System.out.println("im here");  // 120 % 6    		
		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		boolean neg = x2 < 0;
		while (x2!=0) {
			if (neg) {
				x1--;
				x2++;
			} 
			else {
				x1++;
				x2--;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		boolean neg = x2 < 0;
		while (x2!=0) {
			if (neg) {
				x1++;
				x2++;
			} 
			else {
				x1--;
				x2--;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		boolean neg = x2 < 0; 
		int original_value = x1;
		int lim = minus(0,1);
		if (x1 == 0 || x2 == 0) {
			return 0;
		}
		while (x2 != 1 && x2 != lim) {
			x1 = plus(x1,original_value);
			if (neg) {
				x2++;
			} 
			else {
				x2--;
			}
		}
		if (neg) {
			x1 = minus(0,x1);
		}
		return x1;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n==0 || x==1) {
			return 1;
		}
		int x1 = x;
		while (n > 1) {
			x = times(x,x1);
			n--;
		}
		return x;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int counter = 0;
		boolean neg1 = (x1<0 && x2<0) || (x1>0 && x2>0);
		boolean neg2 = x1>0;
		int breakpoint = minus(0,x2);
		while (true) {
			if (neg1) {
				if ((neg2 && (x1<x2)) || (!neg2 && (x1>x2))) {
					break;
				}
				x1 = minus(x1,x2);
				counter++;

			}
			else {
				if ((neg2 && (x1<breakpoint)) || (!neg2 && (x1>breakpoint))) {
					break;
				}
				x1 = plus(x2,x1);
				counter--;
			}
		}
		return counter;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if (x2 == 0 || x1 == 0) {
			return 0;
		}
		if (x1 < 0) {
			x1 = plus(x2,x1);
		}
		if (x2<0) {
			return minus(x1,minus(0,x2));
		}
		return minus(x1 ,times(x2,div(x1,x2)));
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if (x==1 || x==0) {
			return x;
		}
		int mid=x/2,start=0, end=x, res = 1, rep = 0;
		while(rep!=mid){
			res = times(mid,mid);
			if(res>x) {
				end = plus(mid,1);
			}
			else if (res<x){
				start = minus(mid,1);
			}
			else {
				return mid;
			}
			rep = mid;
			mid = div(plus(start,end),2);
			
		}
		return mid;
	}	  	  
}