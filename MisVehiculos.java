package FundamentosJava;
/**Ejemplo sacado del libro Fundamentos de Programaciòn en Java (Facultad de Informatica -Universidad Complutense de Madrid)
**/

public class MisVehiculos {
    public static void main(String[] args) {
        System.out.println("Saludo de inicio: Helooooo, presento un ejemplo del libro: Fundamentos de Programación en Java!!");

        //Creación de clase Vehiculo
        class Vehiculo {
            // Atributos
            private String matricula;
            private String marca;
            private String modelo;
            private String color;
            private double tarifa;
            private boolean disponible;

            // Metodo Constructor
            public Vehiculo(String matricula, String marca, String modelo, String color, double tarifa){
                this.matricula=matricula;
                this.marca=marca;
                this.modelo=modelo;
                this.color=color;
                this.tarifa=tarifa;
                this.disponible=false;
            }

            // Metodo Constructor que requiere solamente la matrícula (sobrecarga de mètodos)
            public Vehiculo(String matricula){
                this.matricula=matricula;
            }
            // Metodo constructor que no requiere el ingreso de argumentos.
            public Vehiculo(){}

            //Metodos get y set para acceder a los atributos ya que son --private--.
            public String getMatricula() {return this.matricula;}
            public String getMarca() {return this.marca;}
            public String getModelo() {return this.modelo;}
            public String getColor() {return this.color;}
            public double getTarifa() {return this.tarifa;}
            public boolean getDisponible() {return this.disponible;}
            public void setTarifa(double tarifa) {this.tarifa=tarifa;}
            public void setDisponible(boolean disponible) {this.disponible=disponible;}
            public String getAtributos() {return "Matricula: "+this.matricula+" Marca: "+this.marca+" Modelo: "+modelo+" Color: "+this.color+ " Tarifa: "+this.tarifa+" Disponible: "+this.disponible;}

            //Otros metodos
            public void recibirVehiculoAlquilado (Vehiculo v) {v.setDisponible(true);} //cambia el estado de disponibilidad del vehiculo que se ingresa.

        }

        //Creación de la clase Cliente
        class Cliente{
            private String nif, nombre, apellido;
            //Constructor
            public Cliente(String nif, String nombre, String apellido){
                this.nif=nif;
                this.nombre=nombre;
                this.apellido=apellido;
            }
        }

        //Creacion de la clase VehiculoAlquilado en Composicion con Cliente y Vehiculo.
        class VehiculoAlquilado {
            private Cliente cliente;
            private Vehiculo vehiculo;
            private int diaAlquiler;
            private int mesAlquiler;
            private int añoAlquiler;
            private int totalDiasAlquiler;

            public VehiculoAlquilado(Cliente cliente, Vehiculo vehiculo, int diaAlquiler, int mesAlquiler, int añoAlquiler, int totalDiasAlquiler) {
                this.cliente = cliente;
                this.vehiculo = vehiculo;
                this.diaAlquiler = diaAlquiler;
                this.mesAlquiler = mesAlquiler;
                this.añoAlquiler = añoAlquiler;
                this.totalDiasAlquiler = totalDiasAlquiler;
            }


            //Metodos get de Cliente y Vehiculo
            public Cliente getCliente() {
                return this.cliente;
            }

            public Vehiculo getVehiculo() {
                return this.vehiculo;
            }
        }


/*
--------------------------------------------------------
********* Vehículos: Turismo - Deportivo - Furgoneta ********
                     Son Subclase de la Clase Vehiculos (HERENCIA).
--------------------------------------------------------
 */

            //Declaración de las subclases con sus respectivos constructores y métodos get.

            class Turismo extends Vehiculo{
                private int puertas;
                private boolean marchaAutomatica;

                public Turismo(String matricula, String marca, String modelo, String color, double tarifa, int puertas, boolean marchaAutomatica){
                    super(matricula, marca, modelo, color,tarifa);
                    this.puertas=puertas;
                    this.marchaAutomatica=marchaAutomatica;
                }
                public int getPuertas(){return this.puertas;}
                public boolean getMarchaAutomatica() { return this.marchaAutomatica;}
                public String getAtributos(){
                    return super.getAtributos() +
                            "Puertas: "+ this.puertas +
                            "Marcha automática: " + this.marchaAutomatica;
                }
            }

            class Deportivo extends Vehiculo{
                private int cilindrada;

                public Deportivo(String matricula, String marca, String modelo, String color, double tarifa, int cilindrada){
                    super(matricula, marca, modelo, color,tarifa);
                    this.cilindrada=cilindrada;
                }
                public int getCilindrada(){return this.cilindrada;}

                public String getAtributos(){
                    return super.getAtributos() +
                            "Cilindrada (cm3): " + this.cilindrada;
                }
            }

            class Furgoneta extends Vehiculo{
                private int carga;
                private int volumen;

                public Furgoneta(String matricula, String marca, String modelo, String color, double tarifa, int carga, int volumen){
                    super(matricula, marca, modelo, color,tarifa);
                    this.carga=carga;
                    this.volumen=volumen;
                }
                public int getCarga(){return this.carga;}
                public int getVolumen() { return this.volumen;}
                public String getAtributos(){
                    return super.getAtributos() +
                            "Carga (kg): "+ this.carga +
                            "Volumen (m3):  " + this.volumen;
                }

            }

/*
--------------------------------------
--------- FIN DEL PROGRAMA -----------
--------------------------------------
 */

        //Instanciación de vehículos
        Vehiculo vehiculo1= new Vehiculo("abc123", "renault", "sandero", "rojo",100.0);
        Vehiculo vehiculo2= new Vehiculo("def456", "ford", "ka", "verde",150.0);
        Vehiculo vehiculo3=vehiculo1; //apunta a v1- cualquier cambio en v3 impactará en v1-

        //Instanciamos cliente
        Cliente cliente1=new Cliente("112233x", "Juan", "Perez");

        //Juan alquila el vehiculo1 el 11/12/2011 por 2 días
        VehiculoAlquilado alquiler1=new VehiculoAlquilado(cliente1,vehiculo1,11, 12,2011,2);

/*
-----------Probamos en consola--------------
-------------------------------------------
 */

        Vehiculo v5=new Vehiculo(); //Puedo crear un vehiculo sin datos porque uno de los constructores lo permite.
        System.out.println("vemos: "+v5.getAtributos()); //mostrará null en tods los campos.

        // Muestro datos del alquiler1
        System.out.println("El alquiler1"+alquiler1.getVehiculo().getAtributos()+" "+"nif cliente: "+alquiler1.getCliente().nif+" Cuyo nombre es "+alquiler1.getCliente().nombre  );

/*
------------------------------------------------------------
   ********* Conversion ascendente de tipos (upcasting) *******
           Java permite asignar un objeto a una referencia de la clase base
           Tener cuidado con la inversa (downcasting) porque puede generar problemas.
------------------------------------------------------------
*/
   //Creo objeto Vehiculo referenciando a la subclase Turismo
    Vehiculo miVehiculoTurismo1= new Turismo ("ttt555", "chevrolet", "crabb", "plata", 90.0, 2, true);
    System.out.println("Muestro miVehiculoTurismo1:  "+miVehiculoTurismo1.getAtributos());




    }//Cierre del Main
}
