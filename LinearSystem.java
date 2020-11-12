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
       
    }

    public void condicionA1(double[][] matrix){
        double normaA;
        double normaA_t;
        //Condicion 1 es encontrar la normaUno de A y Multiplicarlo
        //por la normaUno de A^-1 (inversaMatrix)        
        System.out.println("Norma A\u2081");
        //Saco la normaUno de la matriz A
        normaA = norma.normaUno(matrix);
        //Saco la normaUno de la inversa de la matriz A (A^-1)
        normaA_t = norma.normaUno(matrices.inversaMatrix(matrix));
        //Saco el producto de ambas que seria la Condicion_1
        System.out.println(normaA * normaA_t);
    }
    
    public void condicionA2(){
        System.out.println("Norma A\u2082");
    }
    
    public void condicionAInfinito(){
        System.out.println("Norma A\u221E");
    }
}
