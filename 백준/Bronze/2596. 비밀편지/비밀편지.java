import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String numStr = br.readLine();
		int[] list = new int[] { Integer.parseInt("000000", 2), Integer.parseInt("001111", 2), Integer.parseInt("010011", 2),
				Integer.parseInt("011100", 2), Integer.parseInt("100110", 2), Integer.parseInt("101001", 2), Integer.parseInt("110101", 2),
				Integer.parseInt("111010", 2) };
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			flag = true;
			int num = Integer.parseInt(numStr.substring(i * 6, i * 6 + 6), 2);
			for (int j = 0; j < list.length; j++) {
				int result = num ^ list[j];
				if (Integer.bitCount(result) < 2) {
					sb.append(printAlphabet(j));
					flag = false;
					break;
				}
			}

			if (flag) {
				System.out.println(i + 1);
				break;
			}
		}
		if (!flag) {
			System.out.println(sb);
		}
	}

	private static String printAlphabet(int n) {
		switch (n) {
		case 0:
			return "A";
		case 1:
			return "B";
		case 2:
			return "C";
		case 3:
			return "D";
		case 4:
			return "E";
		case 5:
			return "F";
		case 6:
			return "G";
		case 7:
			return "H";
		default:
			return null;
		}
	}

}