package com.theironyard;

/**
 * Implement this class' methods as instructed below
 */
public class MatrixKatas {

    /**
     * Create a static method named createProductTable(). It should accept two
     * integer arguments representing the size of a two dimensional array. The
     * method will create an array of that size and populate it with the
     * associated products.
     *
     * For example, arguments of 4, 3 would produce this matrix:
     *
     * [
     *  [0, 0, 0],
     *  [0, 1, 2],
     *  [0, 2, 4],
     *  [0, 3, 6]
     * ]
     *
     * Note that the outer array has four elements. Each inner array has three
     * elements. Let's call this array `products`. If we were to access
     * products[3,2] we would find 6.
     *
     * This method returns an array of ints.
     *
     * @param a The size of the "outer" array of arrays of ints.
     * @param b The size of the "inner" arrays of ints.
     * @return A two dimensional array of integers where the value is the product of the array indexes
     */
    // todo: create createProductTable() method
	public static int[][] createProductTable(int a, int b){
		int[][] numberArray = new int[a][];
		for(int i = 0; i < a;i++){
			numberArray[i] = new int[b];

			for(int indx = 0; indx < b; indx++ ){
				numberArray[i][indx] = i * indx;
			}
		}
		return numberArray;
	}
}
