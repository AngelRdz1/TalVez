
package org.apache.dts;

public class Cola {
    //Variables de tipo nodo para conocer el inicio y final de la cola
    NodoCola inicio, fin;
    
    //variable para guardar el tamaño de la cola
    int tamCola;
    
    //Constructor con ambos nodo de inicio y fin en null
    public Cola(){
        inicio=fin=null;
        tamCola = 0;
    }
    //Conocer si la cola esta vacia
    public boolean ColaVacia(){
        return inicio==null ;
    }
    //metodo para ingresar datos a la cola
    public void Insertar(int numPas, int cantMale, String nom){
        NodoCola aux = new NodoCola(numPas,cantMale,nom);
        if(ColaVacia())
            inicio = aux;
        else
            fin.siguiente=aux;
        
        fin = aux;
        tamCola++;  
    }
    
    public String Desencolar(){
        String aux = inicio.nombre;
        inicio=inicio.siguiente;
        tamCola--;
        return aux;
    }
    
    
    
    
}
