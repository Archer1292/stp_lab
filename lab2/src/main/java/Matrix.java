
import java.util.Random;
/**
 * @author Bratus Nadja on 11/14/2017
 * @project lab2
 */
public class Matrix {
    public static void main(String[] args) {
        System.out.print("Enter matrix order");
        int order=ArraySolver.getInputNumber();
        Matrix m=new Matrix(order);
        m.print();
        System.out.print("\ndo rows grow : ");
        for (int x :m.doRowsGrow()) System.out.print(x+" ");
        System.out.println("solve expression : ");
        m.solveExpression();
    };

    private double[][] matrix;

    private int order;

    public Matrix(int order) {
        if (order > 0) {
            this.order = order;
            matrix = new double[this.order][this.order];
            Random rand = new Random();
            for (int i = 0; i < this.order; i++)
                for (int j = 0; j < this.order; j++) {
                    matrix[i][j] = rand.nextDouble();
                }
        } else {
            System.out.println("Порядок матрицы должен быть положительным. Введено  " + order + ". Создано матрицу 0x0.");
            this.order=0;
            matrix = new double[0][0];
        }
    }

    public Matrix(double[][]matrix){
        this.matrix=matrix;
        this.order=matrix.length;
    }

    public Matrix() {
        this(0);
    }

    public void print() {
        try {
            if (order > 0)
                for (int i = 0; i < order; i++) {
                    for (int j = 0; j < order; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.print("\n");
                }
            else System.out.println("Order of matrix 0. The size of the matrix is 0x0");

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public int[] doRowsGrow() {
        if (order > 2) {
            int[] rowsgrow = new int[order];
            for (int i = 0; i < order; i++) {
                int isRowGrow = 1;
                for (int j = 0; j < order - 1; j++) {
                    if (matrix[i][j + 1] < matrix[i][j]) isRowGrow = 0;
                }
                rowsgrow[i] = isRowGrow;
            }
            return rowsgrow;
        } else {
            System.out.println("Order of matrix must be greater than 2. Now order is "+ order);
            return null;
        }
    }

    public  void solveExpression() {
        double result = 0;
        double max;

        for (int i = 0; i < matrix.length; i++) {
            max = matrix[i][0];
            for (int j = 0; j < matrix.length; j++)
                if (matrix[i][j] > max)
                    max = matrix[i][j];
            result += max * matrix[matrix.length - i - 1][matrix.length - i - 1];
        }
        System.out.println("The result of calculating is "+ result);
    }
}


