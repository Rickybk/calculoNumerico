import java.util.Arrays;
public class Normas
{
    // instance variables - replace the example below with your own
    private int x;
    Matrices matriz = new Matrices();
    /**
     * Constructor for objects of class Normas
     */
    public Normas()
    {
        // initialise instance variables
        
    }
    
   
    public double normaInfinito(double[][] matrix)
    {
        System.out.println("Norma A\u221E");
        double sumatoria = 0;
        double mayor = 0;
        String fraccion = "";
        int n = matrix.length;
        int m = matrix[0].length;
        matriz.mostrarMatrix(matrix);
        System.out.print(" "+n+"X"+m+"\n");

        for(int i = 0;i < n;i++){
            sumatoria = 0;
            for(int j = 0;j< m;j++){
                sumatoria = sumatoria + Math.abs(matrix[i][j]);
            }
            fraccion = matriz.decimalToFraction(sumatoria);
            System.out.print("i = "+(i+1)+"      "+sumatoria+" en fraccion: "+fraccion+"\n");
            if(mayor<sumatoria){
                mayor = sumatoria;
            }
        }
        System.out.println("El mayor es "+mayor);
        //System.out.println("\u03B1\u03B2\u03B3");
        return mayor;
    }

    public double normaUno(double[][] matrix){
        
        System.out.println("Norma A\u2081");
        double sumatoria = 0;
        int n     = matrix.length;
        int m     = matrix[0].length;
        double mayor = 0;
        matriz.mostrarMatrix(matrix);
        System.out.print(" "+n+"X"+m+"\n");

        for(int i = 0;i <= m-1;i++){
            sumatoria = 0;
            for(int j = 0;j<=n-1;j++){
                sumatoria = sumatoria + Math.abs(matrix[j][i]);
            }
            System.out.print("j = "+(i+1)+"      "+sumatoria+"\n");
            if(mayor<sumatoria){
                mayor = sumatoria;
            }
        }
        System.out.println("El mayor es A\u2081 = "+mayor);
        return mayor; 
    }

    public void normaDos(double[][] matrix){
        System.out.println("Norma A\u2082");
        double[][] transpuesta;
        double[][] multiplicado;
        transpuesta = matriz.matrixTranspuesta(matrix);
        multiplicado = matriz.multiplicacion(transpuesta,matrix);
        //En la formula es A^t*A = A transpuesta por A en ese orden OJO
        matriz.mostrarMatrix(transpuesta);
        matriz.mostrarMatrix(matrix);
        System.out.println("");
        matriz.mostrarMatrixJunta(multiplicado);
    }
    
}
