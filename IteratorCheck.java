public class IteratorCheck
{
    // instance variables - replace the example below with your own
    Matrices matrix = new Matrices();
    Normas norma = new Normas();
    /**
     * Constructor for objects of class IteratorCheck
     */
    public IteratorCheck()
    {
        // initialise instance variables
    }

    public double[] check(double a[], double b[]){
        double [] resultado = new double [a.length];
        double error = 0.005;        
        resultado = matrix.restaSimple(a,b);
        double numerador = norma.normaInfinitoColumna(resultado);
        double denominador = norma.normaInfinitoColumna(a);
        double res = norma.normaInfinitoColumna(resultado)/ norma.normaInfinitoColumna(a);
        if(res < error){
            System.out.println("El numerador es : "+numerador);
            System.out.println("El denomiador es : "+denominador); 
            System.out.printf("dexp: %f\n",res);
            System.out.println("es menor al error");
            resultado = a;
        } else {
            System.out.printf("dexp: %f\n",res);
            System.out.println("es mayor al error");
            resultado = null;
        }
        return resultado;
    }
    
}
