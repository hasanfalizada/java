package dev;

public class AlmostEquilateralTriangles {

    public static void main(String[] args) {
        long limit = 1_000_000_000L;
        long sum = findSumOfPerimeters(limit);
        System.out.println("Сумма периметров всех почти равносторонних треугольников: " + sum);
    }

    public static long findSumOfPerimeters(long perimeterLimit) {
        long totalSum = 0;

        // Для почти равносторонних треугольников рассматриваем два случая:
        // 1) Треугольник вида (n, n, n+1)
        // 2) Треугольник вида (n, n, n-1)

        // Случай 1: треугольник (n, n, n+1)
        // Площадь = sqrt(s(s-a)(s-b)(s-c)), где s = (3n+1)/2
        // После упрощений: площадь = (n+1)*sqrt(3n²-2n-1)/4
        // Для целочисленной площади нужно, чтобы 3n²-2n-1 было полным квадратом

        for (long n = 1; 3 * n + 1 <= perimeterLimit; n++) {
            if (isValidTriangleType1(n)) {
                totalSum += 3 * n + 1;
                System.out.println("Найден треугольник типа 1: (" + n + ", " + n + ", " + (n + 1) +
                        "), периметр: " + (3 * n + 1));
            }
        }

        // Случай 2: треугольник (n, n, n-1) где n > 1
        for (long n = 2; 3 * n - 1 <= perimeterLimit; n++) {
            if (isValidTriangleType2(n)) {
                totalSum += 3 * n - 1;
                System.out.println("Найден треугольник типа 2: (" + n + ", " + n + ", " + (n - 1) +
                        "), периметр: " + (3 * n - 1));
            }
        }

        return totalSum;
    }

    // Проверяем треугольник типа (n, n, n+1)
    private static boolean isValidTriangleType1(long n) {
        // Площадь = (n+1)*sqrt(3n²-2n-1)/4
        // Нужно проверить, что 3n²-2n-1 - полный квадрат
        long discriminant = 3 * n * n - 2 * n - 1;
        if (discriminant <= 0) return false;

        long sqrtDiscriminant = (long) Math.sqrt(discriminant);
        if (sqrtDiscriminant * sqrtDiscriminant != discriminant) return false;

        // Проверяем, что площадь целочисленная
        // Площадь = (n+1)*sqrtDiscriminant/4
        return ((n + 1) * sqrtDiscriminant) % 4 == 0;
    }

    // Проверяем треугольник типа (n, n, n-1)
    private static boolean isValidTriangleType2(long n) {
        // Площадь = (n-1)*sqrt(3n²+2n-1)/4
        // Нужно проверить, что 3n²+2n-1 - полный квадрат
        long discriminant = 3 * n * n + 2 * n - 1;
        if (discriminant <= 0) return false;

        long sqrtDiscriminant = (long) Math.sqrt(discriminant);
        if (sqrtDiscriminant * sqrtDiscriminant != discriminant) return false;

        // Проверяем, что площадь целочисленная
        // Площадь = (n-1)*sqrtDiscriminant/4
        return ((n - 1) * sqrtDiscriminant) % 4 == 0;
    }

    // Альтернативный более эффективный подход через уравнение Пелля
    public static long findSumOptimized(long perimeterLimit) {
        long totalSum = 0;

        // Решения уравнения Пелля для случая (n, n, n+1)
        // x² - 3y² = 1, где x связано с n
        totalSum += solvePellEquation1(perimeterLimit);

        // Решения уравнения Пелля для случая (n, n, n-1)
        totalSum += solvePellEquation2(perimeterLimit);

        return totalSum;
    }

    private static long solvePellEquation1(long limit) {
        long sum = 0;
        // Начальное решение уравнения x² - 3y² = 1: (x₀, y₀) = (2, 1)
        long x = 2, y = 1;

        while (true) {
            // Из решения (x, y) получаем n = (x + 3)/2 для случая (n, n, n+1)
            if ((x + 3) % 4 == 0) {
                long n = (x + 3) / 4;
                long perimeter = 3 * n + 1;
                if (perimeter > limit) break;
                sum += perimeter;
                System.out.println("Оптимизированный поиск - треугольник: (" + n + ", " + n + ", " + (n + 1) +
                        "), периметр: " + perimeter);
            }

            // Следующее решение: (x', y') = (2x + 3y, x + 2y)
            long newX = 2 * x + 3 * y;
            long newY = x + 2 * y;
            x = newX;
            y = newY;

            if (x < 0) break; // переполнение
        }

        return sum;
    }

    private static long solvePellEquation2(long limit) {
        long sum = 0;
        // Для случая (n, n, n-1) используем другое уравнение Пелля
        long x = 1, y = 0;

        // Генерируем решения
        for (int i = 0; i < 100; i++) { // ограничиваем количество итераций
            if ((x - 3) % 4 == 0 && x > 3) {
                long n = (x + 3) / 4;
                long perimeter = 3 * n - 1;
                if (perimeter > limit) break;
                if (perimeter > 0) {
                    sum += perimeter;
                    System.out.println("Оптимизированный поиск - треугольник: (" + n + ", " + n + ", " + (n - 1) +
                            "), периметр: " + perimeter);
                }
            }

            long newX = 2 * x + 3 * y;
            long newY = x + 2 * y;
            x = newX;
            y = newY;

            if (x < 0) break;
        }

        return sum;
    }
}
