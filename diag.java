public class diag {
	public static void main (String[] arg) {
		int[][] matrix = {
			{1,2,3},
			{2,1,4},
			{1,2,3}
		};

		System.out.println(equalDiagonals(matrix));
	}

	public static int equalDiagonals(int[][] matrix) {
		int counter = 0;
		for(int y = 0; y < matrix.length; y++){
			for (int x = 0; x < matrix[0].length; x++) {
				int diag1 = getValue(matrix,x-1,y-1,matrix[y][x]);
				int diag2 = getValue(matrix,x+1,y-1,matrix[y][x]);
				int diag3 = getValue(matrix,x-1,y+1,matrix[y][x]);
				int diag4 = getValue(matrix,x+1,y+1,matrix[y][x]);

				if (diag1*diag2*diag3*diag4 == Math.pow(matrix[y][x],4)) {
					counter++;
				}
			}
		}
		return counter;
	}

	public static int getValue(int[][] matrix, int x, int y, int bases) {
		if (y >= 0 && y < matrix.length && x >= 0 && x < matrix[0].length) {
			return matrix[y][x];
		} else {
			return bases;
		}
	}
}