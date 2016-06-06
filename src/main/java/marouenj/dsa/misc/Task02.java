/*
 * Time limit : 2sec / Stack limit : 256MB / Memory limit : 256MB

 * Question
 * Examine the following random number generator:
 * 
 * Xn+1=(A×Xn+B)%M A, B, X1, K and M will be given.  * 
 * Output the random numbers from K-th to K+4-th.
 * 
 * Input
 * Input will be given in the following format from Standard Input
 * 
 * A B X1 K M
 * Integer A(0≦A<M), Integer B(0≦B<M), Integer X1(0≦X1<M), Integer K(1≦K<109) and Integer M(2≦M≦104) will be given in one string.
 * 
 * Output
 * Output the random numbers from K to K+4.
 * 
 * Also, make sure to insert a line break at the end of the output.
 * 
 * Hint and Partial points
 * Notice that the value of K is extremely large and the value of M is small.
 * You will earn 50 points if you answer correctly on all the test cases for 1≦K≦104.

 * Input Example # 1
 * 3 2 5 1 7
 * Output Example #1
 * 5
 * 3
 * 4
 * 0
 * 2
 * 
 * The initial value of random number X1 is 5.
 * X2=(3×5+2)%7=3
 * X3=(3×3+2)%7=4
 * X4=(3×4+2)%7=0
 * X5=(3×0+2)%7=2
 * 
 * Input Example #2
 * 1234 5678 123 12345 9876
 * Output Example #2
 * 4162
 * 6066
 * 5114
 * 5590
 * 414
 */

package marouenj.dsa.misc;

public class Task02 {
}
