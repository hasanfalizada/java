package main;

public class EightQueens {

	static void printDesk(char[][] desk) {
		System.out.println("------------------");
		for (int i = 0; i < desk.length; i++) {
			for (int j = 0; j < desk[i].length; j++) {
				System.out.print(desk[i][j] + "|");
			}
			System.out.println();
		}
		System.out.println("------------------");
	}

	static void setRandomInitialQueen(char[][] desk) {
		int range_min = 0;
		int range_max = 7;
		int range = (range_max - range_min) + 1;
		int randomRow = (int) (Math.random() * range) + range_min;
		int randomColumn = (int) (Math.random() * range) + range_min;
		desk[randomRow][randomColumn] = 'Q';
	}

	static void setInitialQueen(char[][] desk, int row, int column) {
		desk[row][column] = 'Q';
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

	static boolean setEligibleQueen(char[][] desk) {
		for (int i = 0; i < desk.length; i++) {
			lp: for (int j = 0; j < desk[i].length; j++) {
				int x = i, y = j;
				while (x < 8) {
					// Checking column down
					if (desk[x][y] == 'Q') {
						continue lp;
					}
					x++;
				}
				x = i;
				y = j;
				while (x >= 0) {
					// Checking column up
					if (desk[x][y] == 'Q') {
						continue lp;
					}
					x--;
				}
				x = i;
				y = j;
				while (y >= 0) {
					// Checking column left
					if (desk[x][y] == 'Q') {
						continue lp;
					}
					y--;
				}
				x = i;
				y = j;
				while (y < 8) {
					// Checking column right
					if (desk[x][y] == 'Q') {
						continue lp;
					}
					y++;
				}
				x = i;
				y = j;
				while (x >= 0 & y >= 0) {
					// Checking diagonal left up
					if (desk[x][y] == 'Q') {
						continue lp;
					}
					x--;
					y--;
				}
				x = i;
				y = j;
				while (x < 8 & y < 8) {
					// Checking diagonal left down
					if (desk[x][y] == 'Q') {
						continue lp;
					}
					x++;
					y++;
				}

				x = i;
				y = j;
				while (x >= 0 & y < 8) {
					// Checking diagonal right up
					if (desk[x][y] == 'Q') {
						continue lp;
					}
					x--;
					y++;
				}
				x = i;
				y = j;
				while (x < 8 & y >= 0) {
					// Checking diagonal right down
					if (desk[x][y] == 'Q') {
						continue lp;
					}
					x++;
					y--;
				}
				desk[i][j] = 'Q';
				return true;
			}
		}
		return false;
	}

	static void setQueens(char[][] desk) {
		if (queensCount(desk) == 8) {
			return;
		} else {
			if (setEligibleQueen(desk)) {
				setQueens(desk);
			} else {
				cleanDesk(desk);
				setRandomInitialQueen(desk);
				setQueens(desk);
			}
		}
	}

	public static void main(String[] args) {
		char[][] desk = { { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', },
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', },
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', },
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', }, { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', } };

		setRandomInitialQueen(desk);
		setQueens(desk);
		printDesk(desk);
	}
}
