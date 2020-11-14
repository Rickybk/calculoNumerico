public class LinearSystem
{
    //double[][] matrix;
    Normas norma      = new Normas();
    Matrices matrices = new Matrices();
    /**
     * Constructor for objects of class LinearSystem
     */
    public LinearSystem(double[][] matrix)
    {
        //condicionA1(matrix);
        condicionA2(matrix);
        //condicionAInfinito(matrix);
       
    }

    public void condicionA1(double[][] matrix){
        double normaA1;
        double normaA1_t;
        //Condicion 1 es encontrar la normaUno de A y Multiplicarlo
        //por la normaUno de A^-1 (inversaMatrix)        
        
        //Saco la normaUno de la matriz A
        normaA1 = norma.normaUno(matrix);
        //Saco la normaUno de la inversa de la matriz A (A^-1)
        normaA1_t = norma.normaUno(matrices.inversaMatrix(matrix));
        //Saco el producto de ambas para conseguir la Condicion_1
        System.out.println("La condicion del sistema lineal dado  A\u2081 : Cond(A) = |A\u207B\u00B9|\u2081 * |A|\u2081");
        //Convertimos los Ints a Strings para poder mostrarlos
        String normaA1String   = Double.toString(normaA1);
        //Convertimos decimales a fraccion
        String normaA1_tString = matrices.decimalToFraction(normaA1_t); 
        String resultado       = matrices.decimalToFraction((normaA1*normaA1_t));
        System.out.println("es =  "+normaA1_tString+" * "+ normaA1String + " = "+resultado + " = "+ (normaA1*normaA1_t));
        if((normaA1*normaA1_t)>=1 && (normaA1*normaA1_t)< 30 ){
            System.out.println("Como 1 <= Cond(A) = "+ normaA1*normaA1_t +" <= 30 "+"Esta bien condicionado");
        } else {
            System.out.println("No esta bien condicionado");
        }
    }
    
    public void condicionA2(double[][] matrix){
        double[][] inversaMatrix;
        double[][] resultado;
        double[][] transpuesta;
        System.out.println("La condicion del sistema lineal dado  A\u2082 : Cond(A) = sqrt(|A\u207B\u00B9|\u2082 * |A|\u2082)");
        System.out.println("Es la raiz del producto");
        System.out.println("La matriz ingresada es : ");
        matrices.mostrarMatrix(matrix);
        System.out.println("Y su transpuesta es :");
        matrices.mostrarMatrix(matrices.matrixTranspuesta(matrix));
        System.out.println("Y el producto entre ambas es :");
        matrices.mostrarMatrix(matrices.multiplicacion(matrices.matrixTranspuesta(matrix),matrix));
        System.out.println("Ahora que tenemos A\u209C*A calculamos los valores propios");
        System.out.println("Recuerda es la raiz del valor propio mas grande \u221A(|A|\u2082))");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Ahora repetimos el proceso, pero con la matrix inversa");
        inversaMatrix = matrices.inversaMatrix(matrix);
        matrices.mostrarMatrix(inversaMatrix);
        System.out.println("Ahora calculamos la tranpuesta de la matrix inversa : ");
        transpuesta = matrices.matrixTranspuesta(inversaMatrix);
        matrices.mostrarMatrix(transpuesta); 
        System.out.println("En decimales :");
        matrices.mostrarMatrixFraccion(transpuesta);
        System.out.println("Ahora calculamos el producto de ambas :");
        //Algun dia arreglare este codigo chancho pero de momento funciona :'v
        //No olvidar que la multiplicacion de matrices debe ir primero la tranpuesta.
        resultado = matrices.multiplicacion(transpuesta,inversaMatrix);
        matrices.mostrarMatrix(resultado);
        System.out.println("Ahora que tenemos A\u207b\u00B9\u209C*A\u207b\u00B9 calculamos los valores propios");
        System.out.println("Recuerda es la raiz del valor propio mas grande \u221A(|A\u207b\u00B9|\u2082)");
    }
    
    public void condicionAInfinito(double[][] matrix){
        double normaAInfinito, normaAInfinito_t;
        String normaAInfinitoString =   "";
        String normaAInfinito_tString = "";
        //Condicion 1 es encontra la normaInfinito de A y Multiplicarlo
        //por la normaInfinito de A^-1 (inversaMatrix)
        System.out.println("La condicion del sistema lineal dado  A\u221E : Cond(A) = |A\u207B\u00B9|\u221E * |A|\u221E");
        //Saco la normaInfinito de la matriz A
        normaAInfinito = norma.normaInfinito(matrix);        
        //Saco la normaInfinito de la inversa de la matriz A (A^-1)
        normaAInfinito_t       = norma.normaInfinito(matrices.inversaMatrix(matrix));
        //Convertimos los decimales a fraccion y los almacenamos en Strings para mostrarlos luego.
        normaAInfinito_tString = matrices.decimalToFraction(normaAInfinito_t);
        normaAInfinitoString   = matrices.decimalToFraction(normaAInfinito);
        String resultado       = matrices.decimalToFraction(normaAInfinito*normaAInfinito_t);
        //Saco el producto de ambas para conseguir la Condicion_Infinito
        System.out.println("Condicion de A\u221E");
        System.out.println("es =  "+normaAInfinito_tString+" * "+ normaAInfinitoString + " = "+resultado + 
        " = "+ (normaAInfinito*normaAInfinito_t));
        if((normaAInfinito*normaAInfinito_t)>=1 && (normaAInfinito*normaAInfinito_t)< 30 ){
            System.out.println("Como 1 <= Cond(A) = "+ normaAInfinito*normaAInfinito_t +" <= 30 "+"Esta bien condicionado");
        } else {
            System.out.println("No esta bien condicionado");
        }
        
    }
}
