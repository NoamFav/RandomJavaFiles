public class Add {
	public static void main(String[] arg) {
		int initial = 3;
		int target = 7;
		System.out.println(additions(initial, target));
	}

	public static int additions (int initial, int target) {
		int temp = 0;
		int counter = 0;
		while (temp+initial < target) {
			temp += initial;
			counter++;
		}
		return counter;
	}
}