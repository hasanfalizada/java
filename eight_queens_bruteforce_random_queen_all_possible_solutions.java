import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EightQueensTest {

	static class Coordinates {
		private int row;
		private int column;

		public Coordinates(int r, int c) {
			this.row = r;
			this.column = c;
		}

		public String print() {
			return this.row + "-" + this.column;
		}

		public boolean equals(Coordinates coo) {
			if (this.row == coo.row & this.column == coo.column) {
				return true;
			}
			return false;
		}
	}

	static void printCoordinates(List<Coordinates> coordinates) {
		for (int i = 0; i < coordinates.size(); i++) {
			System.out.print(coordinates.get(i).row + "-" + coordinates.get(i).column + "|");
		}
		System.out.println();
	}

	static void printDesk(char[][] inputDesk) {
		System.out.println("------------------");
		for (int i = 0; i < inputDesk.length; i++) {
			for (int j = 0; j < inputDesk[i].length; j++) {

				System.out.print(inputDesk[i][j] + "|");

			}
			System.out.println();
		}
		System.out.println("------------------");
	}

	static void printEmptyCellsCoordinates(List<Coordinates> emptyCells) {
		for (int i = 0; i < emptyCells.size(); i++) {
			System.out.println(emptyCells.get(i).row + "-" + emptyCells.get(i).column);
		}
	}

	static Coordinates getRandomCoordinates() {
		int range_min = 0;
		int range_max = 7;
		int range = (range_max - range_min) + 1;
		int randomRow = (int) (Math.random() * range) + range_min;
		int randomColumn = (int) (Math.random() * range) + range_min;
		return new Coordinates(randomRow, randomColumn);
	}

	static boolean setQueen(char[][] inputDesk, Coordinates coordinates) {
		if (coordinates.row == 9) {
			return false;
		}
		int randomRow = coordinates.row;
		int randomColumn = coordinates.column;
		if (inputDesk[randomRow][randomColumn] == 'Q' | inputDesk[randomRow][randomColumn] == '*') {
			return false;
		}
		inputDesk[randomRow][randomColumn] = 'Q';
		int x = randomRow;
		int y = randomColumn;
		while (x < 8) { // down
			if (inputDesk[x][y] == 'Q') {
				x++;
				continue;
			}
			inputDesk[x][y] = '*';
			x++;
		}
		x = randomRow;
		y = randomColumn;
		while (x >= 0) { // up
			if (inputDesk[x][y] == 'Q') {
				x--;
				continue;
			}
			inputDesk[x][y] = '*';
			x--;
		}
		x = randomRow;
		y = randomColumn;
		while (y >= 0) { // left
			if (inputDesk[x][y] == 'Q') {
				y--;
				continue;
			}
			inputDesk[x][y] = '*';
			y--;
		}
		x = randomRow;
		y = randomColumn;
		while (y < 8) { // right
			if (inputDesk[x][y] == 'Q') {
				y++;
				continue;
			}
			inputDesk[x][y] = '*';
			y++;
		}
		x = randomRow;
		y = randomColumn;
		while (x < 8 & y < 8) { // diagonal down right
			if (inputDesk[x][y] == 'Q') {
				x++;
				y++;
				continue;
			}
			inputDesk[x][y] = '*';
			x++;
			y++;
		}

		x = randomRow;
		y = randomColumn;
		while (x >= 0 & y >= 0) { // diagonal up left
			if (inputDesk[x][y] == 'Q') {
				x--;
				y--;
				continue;
			}
			inputDesk[x][y] = '*';
			x--;
			y--;
		}

		x = randomRow;
		y = randomColumn;
		while (x >= 0 & y < 8) { // diagonal up right
			if (inputDesk[x][y] == 'Q') {
				x--;
				y++;
				continue;
			}
			inputDesk[x][y] = '*';
			x--;
			y++;
		}

		x = randomRow;
		y = randomColumn;
		while (x < 8 & y >= 0) { // diagonal down left
			if (inputDesk[x][y] == 'Q') {
				x++;
				y--;
				continue;
			}
			inputDesk[x][y] = '*';
			x++;
			y--;
		}
		return true;
	}

	static int queensCount(char[][] desk) {
		int queensCount = 0;
		for (int i = 0; i < desk.length; i++) {
			for (int j = 0; j < desk[i].length; j++) {
				if (desk[i][j] == 'Q') {
					queensCount++;
				}
			}
		}
		return queensCount;
	}

	static void cleanDesk(char[][] desk) {
		for (int i = 0; i < desk.length; i++) {
			for (int j = 0; j < desk[i].length; j++) {
				desk[i][j] = ' ';
			}
		}
	}

	static int[] getFirstEmptyCellCoordinates(char[][] desk) {
		for (int i = 0; i < desk.length; i++) {
			for (int j = 0; j < desk[i].length; j++) {
				if (desk[i][j] == ' ') {
					return new int[] { i, j };
				}
			}
		}
		return new int[] { 0, 0 };
	}

	static List<Coordinates> getEmptyCellsCoordinates(char[][] desk) {
		List<Coordinates> coordinates = new ArrayList<>();
		for (int i = 0; i < desk.length; i++) {
			for (int j = 0; j < desk[i].length; j++) {
				if (desk[i][j] == ' ') {
					coordinates.add(new Coordinates(i, j));
				}
			}
		}
		return coordinates;
	}

	static char[][] cloneDesk(char[][] inputDesk) {
		char[][] newDesk = new char[8][8];
		for (int i = 0; i < inputDesk.length; i++) {
			for (int j = 0; j < inputDesk[i].length; j++) {
				newDesk[i][j] = inputDesk[i][j];
			}
		}
		return newDesk;

	}

	static char[][] createDesk() {
		return new char[][] { { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', },
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', },
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', },
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', } };
	}

	static boolean contains(List<List<Coordinates>> list, List<Coordinates> coordinates) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				for (int z = 0; z < coordinates.size(); z++) {
					if (list.get(i).get(j).equals(coordinates.get(z))) {
						coordinates.remove(z);
					}
				}
				if (coordinates.size() == 0) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		List<List<Coordinates>> finalSolutions = new ArrayList<>();
		char[][] desk = createDesk();
		setQueen(desk, getRandomCoordinates());
		printDesk(desk);
		List<Coordinates> coordinates0 = getEmptyCellsCoordinates(desk);
		for (int i = 0; i < coordinates0.size(); i++) {

			char[][] cloneDesk0 = cloneDesk(desk);
			if (setQueen(cloneDesk0, coordinates0.get(i))) {
				List<Coordinates> coordinates1 = getEmptyCellsCoordinates(desk);
				if (coordinates1.isEmpty()) {
					continue;
				}
				for (int j = 0; j < coordinates1.size(); j++) {

					char[][] cloneDesk1 = cloneDesk(cloneDesk0);
					if (setQueen(cloneDesk1, coordinates1.get(j))) {
						List<Coordinates> coordinates2 = getEmptyCellsCoordinates(cloneDesk1);
						if (coordinates2.isEmpty()) {
							continue;
						}
						for (int z = 0; z < coordinates2.size(); z++) {

							char[][] cloneDesk2 = cloneDesk(cloneDesk1);
							if (setQueen(cloneDesk2, coordinates2.get(z))) {
								List<Coordinates> coordinates3 = getEmptyCellsCoordinates(cloneDesk2);
								if (coordinates3.isEmpty()) {
									continue;
								}
								for (int y = 0; y < coordinates3.size(); y++) {

									char[][] cloneDesk3 = cloneDesk(cloneDesk2);
									if (setQueen(cloneDesk3, coordinates3.get(y))) {
										List<Coordinates> coordinates4 = getEmptyCellsCoordinates(cloneDesk3);
										if (coordinates4.isEmpty()) {
											continue;
										}
										for (int x = 0; x < coordinates4.size(); x++) {

											char[][] cloneDesk4 = cloneDesk(cloneDesk3);
											if (setQueen(cloneDesk4, coordinates4.get(x))) {
												List<Coordinates> coordinates5 = getEmptyCellsCoordinates(cloneDesk4);
												if (coordinates5.isEmpty()) {
													continue;
												}
												for (int g = 0; g < coordinates5.size(); g++) {

													char[][] cloneDesk5 = cloneDesk(cloneDesk4);
													if (setQueen(cloneDesk5, coordinates5.get(g))) {
														List<Coordinates> coordinates6 = getEmptyCellsCoordinates(
																cloneDesk5);
														if (coordinates6.isEmpty()) {
															continue;
														}
														for (int h = 0; h < coordinates6.size(); h++) {
															List<Coordinates> candidate = new ArrayList<Coordinates>(
																	Arrays.asList(coordinates0.get(i),
																			coordinates1.get(j), coordinates2.get(z),
																			coordinates3.get(y), coordinates4.get(x),
																			coordinates5.get(g), coordinates6.get(h)));

															if (finalSolutions.isEmpty()) {
																finalSolutions.add(new ArrayList<Coordinates>(
																		Arrays.asList(coordinates0.get(i),
																				coordinates1.get(j),
																				coordinates2.get(z),
																				coordinates3.get(y),
																				coordinates4.get(x),
																				coordinates5.get(g),
																				coordinates6.get(h))));
																continue;
															}

															if (!contains(finalSolutions, candidate)) {
																finalSolutions.add(new ArrayList<Coordinates>(
																		Arrays.asList(coordinates0.get(i),
																				coordinates1.get(j),
																				coordinates2.get(z),
																				coordinates3.get(y),
																				coordinates4.get(x),
																				coordinates5.get(g),
																				coordinates6.get(h))));
															}

														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < finalSolutions.size(); i++) {
			System.out.print("Solution " + i + ": ");
			printCoordinates(finalSolutions.get(i));
		}
	}
}
