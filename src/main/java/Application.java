package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Print an array spiral given a "square" matrix: A two-dimensional array where array.length = array[0].length
 * 
 * @author Filipe Camacho
 *
 */
public class Application {

	public static void main(String[] args) {
		
		Integer[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		
		System.out.print(arraySpiral(matrix));
	}

	/**
	 * Return spiral array given a matrix
	 * @param matrix (X = Y)
	 * @return spiral array
	 */
	public static List<Integer> arraySpiral(Integer[][] matrix) {
		
		List<Integer> visitedNumbers = new ArrayList<>();
		
		if(matrix.length == 0 || matrix.length != matrix[0].length) {
			return visitedNumbers;
		}
		
		int totalCells = matrix.length * matrix[0].length;

		int positionX = 0;
		int positionY = 0;

		int[] directionX = { 0, 1, 0, -1 };
		int[] directionY = { 1, 0, -1, 0 };
		int currentDirection = 0;

		for (int i = 0; i < totalCells; i++) {

			if (positionX + directionX[currentDirection] > matrix[0].length - 1 || positionX + directionX[currentDirection] < 0 // Check if next X position goes out of bounds
					|| visitedNumbers.contains(matrix[positionX + directionX[currentDirection]][positionY]) // Check if next X position was already visited
					|| positionY + directionY[currentDirection] > matrix.length - 1 || positionY + directionY[currentDirection] < 0 // Check if next Y position goes out of bounds
					|| visitedNumbers.contains(matrix[positionX][positionY + directionY[currentDirection]])) // Check if next Y position was already visited 
				{ 
				
				// If any apply, change directions
				currentDirection = currentDirection == 3 ? 0 : currentDirection + 1;
			}
			
			visitedNumbers.add(matrix[positionX][positionY]);
			
			// Increment position
			positionX += directionX[currentDirection];
			positionY += directionY[currentDirection];
		}
		
		return visitedNumbers;
	}
}
