import java.util.Arrays;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.fraction.Fraction;

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
        //Genero una matrix identidad del tamano necesario.
        double [][] identidad = generadorIdentidad(Matrix.length);       
        //Declaro una matriz para almacenar la inversa.
        double [][] inversa;
        // Solving AB = I for given A
        // Creo un objeto del tipo RealMatrix con los parametros y valores de la matriz 'Matrix'.
        RealMatrix A = new Array2DRowRealMatrix(Matrix);
        System.out.println("La matriz ingresada es : ");
        //Creamos un String y almacenamos los datos del objeto RealMatrix A
        //con el metodo toString() de la clase RealMatrix.
        String matrixA = A.toString();
        //Creamos un segundo String auxiliar para almacenar los cambios realizados en el primer String matrixA.
        //Realizamos reemplazos en el String auxB para darle el formato correcto.
        String auxA = matrixA.replace("},", "} \n").replace("Array2DRowRealMatrix","");
        //Imprimimos la matrix, previo formateo.
        System.out.println(auxA);
        //Magia. 
        DecompositionSolver solver = new LUDecomposition(A).getSolver();        
        //Le pasamos la matriz identidad para que se realice el procedimiento de inversion.
        RealMatrix I = new Array2DRowRealMatrix(identidad);
        //Mas magia.
        RealMatrix B = solver.solve(I);
        //Creamos un String y almacenamos los datos del objeto RealMatrix A
        //con el metodo toString() de la clase RealMatrix.
        String identidadString = B.toString();
        //Formateamos el String auxB para que muestre correctamente los datos.
        String auxIdentidad = identidadString.replace("},", "} \n").replace("Array2DRowRealMatrix",""); 
        //Imprimimos el resultado
        System.out.println("La inversa de la matriz ingresada es : ");
        //System.out.println(auxIdentidad);
        System.out.println("En fraccion :");
        
        //Usamos el metodo getData() que tiene la clase RealMatrix para poder obtener los valores de la matriz
        //en un formato de matriz double[][].
        inversa = B.getData();
        mostrarMatrixFraccion(inversa);
        System.out.println("En decimales :");
        return inversa;
    }
    
    public double[][] generadorIdentidad(int dimension){
        //Este metodo genera una matrix Identidad de tamano 'dimension' dado por parametro
        double [][] identidad = new double[dimension][dimension];
        for(int i = 0; i < dimension;i++){
                identidad[i][i] = 1;
        }
        //No es necesario mostrar, pero comento la linea para fines de testeo
        //mostrarMatrix(identidad);
        return identidad;
    }
    //Convierte decimal a fracciones.
    public String decimalToFraction(double decimal){
        String fraccion = "";
        Fraction f = new Fraction(decimal);
        fraccion = f.toString();
        //System.out.println(f);
        return fraccion;
    }
    
    
    public void mostrarMatrixFraccion(double [][] matrix){
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix.length; j++){
                Fraction f = new Fraction(matrix[i][j]);
                System.out.print(f+" ");
            }
            System.out.println("\n");
        }
    }
}
