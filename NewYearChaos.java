package devjava;

public class NewYearChaos {
	static void minimumBribes(int[] q) {
		int ans = 0;
		for (int i = q.length - 1; i >= 0; i--) {
			int ch_pos = q[i] - (i + 1);
			if (ch_pos > 2) {
				System.out.println("Too chaotic");
				return;
			} else {
				int st = Math.max(0, q[i] - 2);
				for (int j = st; j < i; j++) {
					if (q[j] > q[i])
						ans++;
				}
			}
		}
		System.out.println(ans);
	}
}
