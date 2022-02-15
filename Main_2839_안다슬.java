import java.util.Scanner;

public class Main_2839_안다슬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int five = N / 5;
		for (int i = five; i > 0; i--) {
			int three = N - 5 * i;
			if (three % 3 == 0) {
				System.out.println(i + (three / 3));
				return;
			}
			else {
				continue;
			}
		}

		if (N % 3 == 0) {
			System.out.println(N / 3);
			return;
		}
		System.out.println(-1);

	}

}
