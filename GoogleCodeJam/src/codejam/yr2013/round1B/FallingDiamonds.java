package codejam.yr2013.round1B;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import codejam.shared.CommonMethods;

/**
 * @author Ran
 * @time
 */
public class FallingDiamonds {

	public static void main(String[] args) throws Exception {
		FallingDiamonds main = new FallingDiamonds();
		String problemIndex = "B";
		String problemDataSet = "small";
		// main.run("test.in", "answer.out");
		main.run(problemIndex + "-" + problemDataSet + "-practice.in",
				"answer.out");
		System.exit(0);
	}

	private void run(String input, String output) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader(new File(
				FallingDiamonds.class.getResource(input).toURI())));
		PrintWriter out = new PrintWriter(new FileWriter(output));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			out.write("Case #" + t + ": ");
			String[] lines = in.readLine().split("\\s");
			int n = Integer.parseInt(lines[0]);
			int x = Math.abs(Integer.parseInt(lines[1]));
			int y = Math.abs(Integer.parseInt(lines[2]));
			double ret = solve(n, x, y);
			System.out.println(ret);
			out.write("" + ret + "\n");
		}
		in.close();
		out.close();
	}

	private double solve(int n, int x, int y) {
		int xy = x + y;
		int m = n - ((xy * xy - xy) / 2);
		int max = xy;
		int min = Math.max(0, m - xy);
		if (m <= 0)
			return 0;
		if (m >= 2 * xy + 1)
			return 1;
		if (x == 0)
			return 0;
		if (y < min)
			return 1;
		int combinations = 0;
		for (int i = 0; i <= (y - min); i++) {
			combinations += CommonMethods.binomCoeff(max - min, i);
		}
		// System.out.println("combinations is " + combinations);
		// System.out.println("max - min is " + (max - min));
		return 1 - (combinations / Math.pow(2, max - min));
	}

}