public class QuadraticSolver
{
   /**
     * Constructor for objects of class QuadraticSolver
     */
    public QuadraticSolver()
    {
        
    }

   public void quadraticEquationRoot1(double a, double b, double c){    
       double root1, root2; //This is now a double, too.
       root1 = (-b + Math.sqrt(Math.pow(b, 2) - 4*a*c)) / (2*a);
       root2 = (-b - Math.sqrt(Math.pow(b, 2) - 4*a*c)) / (2*a);
       System.out.println("El Maximo es :"+Math.max(root1, root2));
       System.out.println("El Minimo es :"+Math.min(root1, root2));
       System.out.println("La Raiz del Maximo es : " + Math.sqrt(Math.max(root1,root2))) ;
   }
}