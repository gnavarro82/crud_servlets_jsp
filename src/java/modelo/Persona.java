
package modelo;

public class Persona {
private String dni;
private String nombre;
private int edad;
private int telefono;
 

public Persona() {
        dni = "";
        nombre ="";
        edad = 0;
        telefono = 0;
    }



    public String getDni() {
        return dni;
    }

   

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }


}
