
package org.apache.dts;

public class NodoCola {
    int numPasaporte, cantMaletas;
    String nombre;
    NodoCola siguiente;
    
    public NodoCola(int numPasaporte, int cantMaletas, String nombre){
        this.numPasaporte = numPasaporte;
        this.cantMaletas = cantMaletas;
        this.nombre = nombre;
        siguiente=null;
    }
    
}
