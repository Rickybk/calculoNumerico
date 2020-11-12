import java.util.Arrays;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class Matrices
{
    //Matrix a = new Matrix();
    /**
     * Constructor for objects of class Matrix
     */
    public Matrices()
    {

    }
    //Multiplica 2 matrices nxm
    public double[][] multiplicacion(double[][] m1, double[][] m2) {
        int m1ColLength = m1[0].length; // m1 columns length
        int m2RowLength = m2.length;    // m2 rows length
        if(m1ColLength != m2RowLength) return null; // matrix multiplication is not possible
        int mRRowLength = m1.length;    // m result rows length
        int mRColLength = m2[0].length; // m result columns length
        double[][] mResult = new double[mRRowLength][mRColLength];
        for(int i = 0; i < mRRowLength; i++) {         // rows from m1
            for(int j = 0; j < mRColLength; j++) {     // columns from m2
                for(int k = 0; k < m1ColLength; k++) { // columns from m1
                    mResult[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return mResult;
    }

    public void testMatrix(){
        double[][] test         = {{2,3,-5},{1,4,-6}};
        double[][] transpuesta  = {{-2,3},{1,4}};
        Normas norma = new Normas();
        norma.normaInfinito(test);
        norma.normaUno(test);
        norma.normaDos(transpuesta);
        //mostrarMatrix(transpuesta);
        //System.out.println("");
        //mostrarMatrix(matrixTranspuesta(transpuesta));
        //mostrarMatrix(test);
    }

    public void mostrarMatrix(double[][] matrix){
        System.out.println(Arrays.deepToString(matrix).replace("],", "]\n"));

    }

    public void mostrarMatrixJunta(double[][] matrix){
        System.out.print(Arrays.deepToString(matrix).replace("],", "]\n"));
    }

    public double[][] matrixTranspuesta(double[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        double [][] transpuesta = new double [n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j< m; j++){
                transpuesta[i][j] = matrix [j][i];
            }
        }
        return transpuesta; 
    }
    
    
    public void pruebaMatrix(double[][] Matrix){
        double [][] values = {{1, 1, 2}, {2, 4, -3}, {3, 6, -5}};
        double [][] rhs = {{1, 0},{0,1}};
        
        // Solving AB = I for given A
        RealMatrix A = new Array2DRowRealMatrix(Matrix);
        System.out.println("Input A: " + A);
        String matrixA = A.toString();
        String auxB;
        //System.out.println(matrixA);
        auxB = matrixA.replace("},", "} \n");
        //System.out.println(auxB);
        System.out.println(auxB.replace("Array2DRowRealMatrix",""));
        //System.out.println(matrixA.replace("},", "}\n").replace("Array2DRowRealMatrix,"," "));
        //System.out.println("Veamos "+ A);
        DecompositionSolver solver = new LUDecomposition(A).getSolver();

        RealMatrix I = new Array2DRowRealMatrix(rhs);
        RealMatrix B = solver.solve(I);
        System.out.println("Inverse B: " + B);
    }
    
    public double[][] inversaMatrix(double[][] Matrix){
        double [][] values = {{1, 1, 2}, {2, 4, -3}, {3, 6, -5}};
        double [][] identidad = generadorIdentidad(Matrix.length);       
        double [][] inversa;
        // Solving AB = I for given A
        RealMatrix A = new Array2DRowRealMatrix(Matrix);
        System.out.println("Input A: " + A);
        String matrixA = A.toString();
        String auxB;
        //System.out.println(matrixA);
        auxB = matrixA.replace("},", "} \n");
        //System.out.println(auxB);
        System.out.println(auxB.replace("Array2DRowRealMatrix",""));
        //System.out.println(matrixA.replace("},", "}\n").replace("Array2DRowRealMatrix,"," "));
        //System.out.println("Veamos "+ A);
        DecompositionSolver solver = new LUDecomposition(A).getSolver();

        RealMatrix I = new Array2DRowRealMatrix(identidad);
        RealMatrix B = solver.solve(I);
        System.out.println("Inverse B: " + B);
        inversa = B.getData();
        return inversa;
    }
    
    public double[][] generadorIdentidad(int dimension){
        //Este metodo genera una matrix Identidad de tamano 'dimension' dado por parametro
        double [][] identidad = new double[dimension][dimension];
        for(int i = 0; i < dimension;i++){
                identidad[i][i] = 1;
        }
        mostrarMatrix(identidad);
        return identidad;
    }
}
