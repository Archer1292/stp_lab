import java.io.Console;
import java.util.Random;

public class SquareMatrix {
    private double[][] matrix;
    private int order;


    public SquareMatrix(int order ){
        if(order>0){
            matrix=new double[order][order];
            Random rand = new Random();
            for(int i =0;i<order;i++)
                for(int j =0;j<order;j++){
                    matrix[i][j]=rand.nextDouble();
                }
        }
        else {System.out.println("Порядок матрицы должен быть положительным. Введено  "+order+". Создано матрицу 0x0.");
            matrix=new double[0][0];}
    }
    public SquareMatrix(){
        this(0);
    }
    public void print() {
        if (matrix != null && order > 0)
            for (int i = 0; i < order; i++) {
                for (int j = 0; j < order; j++) {
                    System.out.print(matrix[i][j] + "\t");
                }
            }
        else System.out.println("Ошибка данных");
    }

    public int[] doRowsGrow(){
        if(order>2){
            int[] rowsgrow=new int[order];
            for (int i=0;i<order;i++){
                int isRowGrow=1;
                for (int j=0;j<order-1;j++){
                    if(matrix[i][j+1]<=matrix[i][j])isRowGrow=0;
                }
                rowsgrow[i]=isRowGrow;
            }
            return rowsgrow;
        }else {
            System.out.println("Порядок матрицы должен быть больше 2");
            return null;
        }
    }
}
