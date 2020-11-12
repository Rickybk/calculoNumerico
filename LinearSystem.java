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
        condicionA1(matrix);
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
        String normaA1_tString = Double.toString(normaA1_t); 
        System.out.println("es =  "+normaA1_tString+" * "+ normaA1String + " = "+ (normaA1*normaA1_t));
    }
    
    public void condicionA2(){
        System.out.println("Norma A\u2082");
    }
    
    public void condicionAInfinito(double[][] matrix){
        double normaAInfinito, normaAInfinito_t;
        //Condicion 1 es encontra la normaInfinito de A y Multiplicarlo
        //por la normaInfinito de A^-1 (inversaMatrix)
        System.out.println("Condicion de A\u221E");
        //Saco la normaInfinito de la matriz A
        normaAInfinito = norma.normaInfinito(matrix);        
        //Saco la normaInfinito de la inversa de la matriz A (A^-1)
        normaAInfinito_t = norma.normaInfinito(matrices.inversaMatrix(matrix));
        //Saco el producto de ambas para conseguir la Condicion_Infinito
        System.out.println("Condicion de A\u221E");
        System.out.println("es :"+normaAInfinito * normaAInfinito_t);
    }
}
