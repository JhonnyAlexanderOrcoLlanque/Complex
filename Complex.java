/*
PRACTICA 1 INGENIERIA DE SOFTWARE
OPERACIÓN DE NUMEROS COMPLEJOS
@autor Jhonny Alexander Orco Llanque
@autor Felix Maturano Zarate
@autor German Basualdo Rengifo
@version 1.1
@date 07/03/2024
*/
//Hola
class Complex
{
    double real;
    double imaginario;
  
    Complex(double _real, double _imaginario)
    {
        this.real = _real;
        this.imaginario = _imaginario;
    }
    
    Complex sumar(Complex otro) {
        return new Complex(real + otro.real, imaginario + otro.imaginario);
    }
  
    Complex restar(Complex otro) {
        return new Complex(real - otro.real, imaginario - otro.imaginario);
    }
  
    Complex multiplicar(Complex otro) {
        double r = real * otro.real - imaginario * otro.imaginario;
        double i = real * otro.imaginario + imaginario * otro.real;
        return new Complex(r, i);
    }
  
    Complex dividir(Complex otro) {
        double divisor = otro.real * otro.real + otro.imaginario * otro.imaginario;
        double r = (real * otro.real + imaginario * otro.imaginario) / divisor;
        double i = (imaginario * otro.real - real * otro.imaginario) / divisor;
        return new Complex(r, i);
    }
    
    double modulo(){
        //Jhonny Alexander Orco Llanque
        double result = Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginario, 2));
        return result;
    }

    Complex raizCuadrada(){
        //Jhonny Alexander Orco Llanque
        double r = Math.sqrt( (this.modulo()+this.real)/2 );
        double i = ( Math.signum(this.imaginario) * Math.sqrt(this.modulo()-this.real)) / Math.sqrt(2);
        return new Complex(r, i);
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
        System.out.println("Suma: " + c1.sumar(c2));
        System.out.println("Resta: " + c1.restar(c2));
        System.out.println("Multiplicacion: " + c1.multiplicar(c2));
        System.out.println("Division: " + c1.dividir(c2));
        System.out.println("Modulo de complejo 1: " + c1.modulo());
        System.out.println("Modulo de complejo 2: " + c2.modulo());
        System.out.println("Raiz cuadrada de complejo 1: +/- (" +  c1.raizCuadrada() + ")");
        System.out.println("Raiz cuadrada de complejo 2: +/- (" + c2.raizCuadrada() + ")");
    }
}