
package Interpolacion;

import java.lang.Math.*;
import net.objecthunter.exp4j.*;
//Algoritmo de biseccion Calculo Numerico (Ing Juchani)
public class Biseccion
{
    //Se deben introducir los valores iniciales manualmente.
    double a,b,error;
    String funcion;
    public Biseccion(String funcion,double a, double b, double error){
        this.a       = a;
        this.b       = b;
        this.error   = error;
        this.funcion = funcion;
        valorDeX(funcion,a,b,error);
    }
    
    //public Biseccion(){}
    
    public double Iteraciones(double a, double b, double error){
        double iteraciones = 0;
        //Calculamos las iteraciones necesarias para encontrar X.
        iteraciones = Math.ceil(Math.log((b-a)/error)/Math.log(2));        
        return iteraciones;
    }

    public double valorDeX(String funcion,double a, double b, double error){
        double valordex = 0;
        int iteraciones = (int)Iteraciones(a,b,error);
        System.out.println("Numero aproximado de iteraciones = "+iteraciones);
        //System.out.println("f(a1 = "+a+") = "+ evaluadorFuncion(funcion,a));
        //System.out.println("f(b1 = "+b+") = "+ evaluadorFuncion(funcion,b));        
        for(int i = 1; i <= iteraciones; i++ ){
            double x = (a+b)/2;
            System.out.println("Iteracion # "+i);
            System.out.println("f(a"+i+" = "+a+") = "+ evaluadorFuncion(funcion,a));
            System.out.println("f(x"+i+" = "+x+") = "+ evaluadorFuncion(funcion,x));
            System.out.println("f(b"+i+" = "+b+") = "+ evaluadorFuncion(funcion,b)); 
            System.out.println("----------------------------------------");
            if(evaluadorFuncion(funcion,x)*evaluadorFuncion(funcion,a) < 0){
                b = x;
            } else {
                a = x;
            }
            valordex = x;
        }
        System.out.println("Solucion: X = "+valordex);
        return valordex;
    }

    
    public double evaluadorFuncion(String funcion, double a){
        double result = 0;
        Expression e = new ExpressionBuilder(funcion)
            .variables("x")
            .build()
            .setVariable("x", a);        
        result = e.evaluate();
        return result;
    }

}
