package devjava;

import java.util.HashMap;
import java.util.Map;

public class ReciprocalCycles {
	private static int getCycleLength(int n) {
		System.out.println("For " + n);
		Map<Integer, Integer> stateToIter = new HashMap<Integer, Integer>();
		int state = 1;
		int iter = 0;
		while (!stateToIter.containsKey(state)) {
			System.out.println("State/Iter " + state + "/" + iter);
			stateToIter.put(state, iter);
			state = state * 10 % n;
			iter++;
		}
		return iter - stateToIter.get(state);

	}

	public static void main(String[] args) {
		int bestNumber = 0;
		int bestLength = 0;
		for (int i = 1; i <= 10; i++) {
			int len = getCycleLength(i);
			if (len > bestLength) {
				bestNumber = i;
				bestLength = len;
			}
		}

		System.out.println(Integer.toString(bestNumber));

	}
}
