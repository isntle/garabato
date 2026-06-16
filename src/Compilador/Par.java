//**********************************************************************************
//PAR.JAVA
//**********************************************************************************
//**********************************************************************************
//HERNANDEZ HERNANDEZ RUBEN
//LIRA DÁVILA ALAN DAVID
//RAMÍREZ GUTIERREZ ENRIQUE
//OAXACA PÉREZ DAVID ARTURO
//Curso: Compiladores 3CM15
//JUNIO 2021
//ESCOM-IPN
// Clase que logra ligar un objeto de cualquier tipo con un nombre.
//**********************************************************************************
package Compilador;

public class Par {

    private String nombre;
    private Object objeto;

    public Par(String nombre, Object objeto){
        this.nombre = nombre;
        this.objeto = objeto;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }
        
}
