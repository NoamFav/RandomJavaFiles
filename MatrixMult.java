import java.util.Arrays;
import java.util.Scanner;

public class MatrixMult {

	public static double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {

		//get dimension of the matrix
		int[] dimension1 = { firstMatrix.length, firstMatrix[0].length };
		int[] dimension2 = { secondMatrix.length, secondMatrix[0].length };

		//initialize result matrix size
		double[][] result = new double [dimension1[0]] [dimension2[1]];
		double tempresult = 0;

		if (dimension1[1] == dimension2[0]) {

			for (int y1 = 0; y1 < dimension1[0]; y1++) {

				for (int x2 = 0; x2 < dimension2[1]; x2++) {

					tempresult = 0;

					for (int j = 0; j < dimension1[1]; j++) {

						tempresult += firstMatrix[y1][j] * secondMatrix[j][x2];

					}
					result[y1][x2] = tempresult;
				}
			}
		} else {
			System.out.println("non valide");
			return null;
		}

		return result;
	}

	public static void main(String[] args) {

		double[][] firstMatrix = {
			{2,3},
			{4,5},
			{6,2},
			{5,2}
		};

		double[][] secondMatrix = {
			{1,2,3},
			{4,5,6}
		};

        System.out.println(Arrays.deepToString(multiplyMatrices(firstMatrix,secondMatrix)));
	}
}