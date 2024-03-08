/*
PRACTICA 1 INGENIERIA DE SOFTWARE
OPERACIÓN DE NUMEROS COMPLEJOS
@autor Jhonny Alexander Orco Llanque
@autor Felix Maturano Zarate
@autor German Enrique Basualdo Rengifo
@version 1.2
@date  07/03/2024
*/

class Complex
{
    double real;
    double imaginario;


    Complex(double _real, double _imaginario)
    {
        this.real = _real;
        this.imaginario = _imaginario;
    }
    
    Complex addition(Complex otro) {
        return new Complex(real + otro.real, imaginario + otro.imaginario);
    }
  
    Complex substraction(Complex otro) {
        return new Complex(real - otro.real, imaginario - otro.imaginario);
    }
  
    Complex multiplication(Complex otro) {
        double r = real * otro.real - imaginario * otro.imaginario;
        double i = real * otro.imaginario + imaginario * otro.real;
        return new Complex(r, i);
    }
  
    Complex division(Complex otro) {
        double divisor = otro.real * otro.real + otro.imaginario * otro.imaginario;
        double r = (real * otro.real + imaginario * otro.imaginario) / divisor;
        double i = (imaginario * otro.real - real * otro.imaginario) / divisor;
        return new Complex(r, i);
    }
    
    Complex conjugado(){
        // Felix Maturano Zarate
        return new Complex(real, -imaginario);
    }

    double module(){
        //Jhonny Alexander Orco Llanque
        double result = Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginario, 2));
        return result;
    }
        double phase() {
        //German Enrique Basualdo Rengifo
        return Math.atan2(imaginario, real);
    }
    Complex power(double n) {
        //German Enrique Basualdo Rengifo
        double r = Math.pow(module(), n) * Math.cos(n * phase());
        double i = Math.pow(module(), n) * Math.sin(n * phase());
        return new complex(r, i);
    }

    Complex squareRoot(){
        //Jhonny Alexander Orco Llanque
        double r = Math.sqrt( (this.module()+this.real)/2 );
        double i = ( Math.signum(this.imaginario) * Math.sqrt(this.module()-this.real)) / Math.sqrt(2);
        return new Complex(r, i);
    }

    int k = 1;
    Complex logarithm() {
        // Felix Maturano Zarate
        double modulo = this.module();
        double argumento = Math.atan2(this.imaginario, this.real);
        double parteReal = Math.log(modulo);
        double parteImaginaria = argumento + 2 * Math.PI * k; // Aquí debes definir el valor de k
        return new Complex(parteReal, parteImaginaria);
    }

    @Override
    public String toString() {
        if (imaginario >= 0) {
            return real + " + " + imaginario + "i";
        } else {
            return real + " - " + (-imaginario) + "i";
        }
    }

    public static void main(String[] args) {

        
        Complex c1 = new Complex(3, 2);
        Complex c2 = new Complex(1, -1);
        
        System.out.println("Complejo1: " + c1.toString());
        System.out.println("Complejo2: " + c2.toString());
        System.out.println("Suma: " + c1.addition(c2));
        System.out.println("Resta: " + c1.substraction(c2));
        System.out.println("Multiplicacion: " + c1.multiplication(c2));
        System.out.println("Division: " + c1.division(c2));
        System.out.println("Modulo de complejo 1: " + c1.module());
        System.out.println("Modulo de complejo 2: " + c2.module());
        System.out.println("Conjugado: "+ c1.conjugado());
        System.out.println("Conjugado: "+ c2.conjugado());
        System.out.println("fase o argumento 1: " + c1.phase());
        System.out.println("fase o argumento 2: " + c2.phase());
        System.out.println("potencia de complejos 1: " + c1.power(n));
        System.out.println("potencia de complejos 2: " + c2.power(n));
        System.out.println("Raiz cuadrada de complejo 1: +/- (" +  c1.squareRoot() + ")");
        System.out.println("Raiz cuadrada de complejo 2: +/- (" + c2.squareRoot() + ")");
        System.out.println("Logaritmo de complejo 1: " + c1.logarithm());
        System.out.println("Logaritmo de complejo 2: " + c2.logarithm());
    }
}