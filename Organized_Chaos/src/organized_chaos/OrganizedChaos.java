/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package organized_chaos;

/**
 *
 * @author fabriziospiotta
 */
public class OrganizedChaos {

    public static int[] djikstra(int numeroVertices, Lista listaPrincipal, int nodoFuente){
        Lista<Pair> priorityList = new Lista();
        int[] dist = new int[numeroVertices];
        for (int i = 0; i < numeroVertices; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
        dist[nodoFuente] = 0;
        priorityList.AppendOrdenadoPair(new Pair(0,nodoFuente));
        
        while(priorityList.getSize() != 0) {
            Pair top = (Pair) priorityList.getpFirst().getElemento();
            int dis = top.getDistance();
            int node = top.getNumeroVertice();
            priorityList.Delete(top);
            
            Nodo <Arco> aux = listaPrincipal.BuscarVertice(node).getListaDeAdyacencia().getpFirst();
            for (int i = 0; i < listaPrincipal.BuscarVertice(node).getListaDeAdyacencia().getSize(); i++) {
                int edgeWeight = aux.getElemento().getDistancia();
                int adjNode = aux.getElemento().getVerticeDestinoNumero();
                
                if (dis +  edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    priorityList.AppendOrdenadoPair(new Pair(dist[adjNode], adjNode));
                }     
                aux = aux.getpNext();
            }  
        }
        return dist;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Grafo grafoPrueba = new Grafo();
        
        grafoPrueba.getListaPrincipal().imprimirListaPrincipal();
        
        grafoPrueba.insertarVertice("Z", 0);
        grafoPrueba.insertarVertice("A", 1);
        grafoPrueba.insertarVertice("B", 2);
        grafoPrueba.insertarVertice("C", 3);
        grafoPrueba.insertarVertice("D", 4);
        
        grafoPrueba.insertarArco(10, "B", "Z", 0);
        grafoPrueba.insertarArco(10, "Z", "B", 2);
        grafoPrueba.insertarArco(3, "A", "B", 2);
        grafoPrueba.insertarArco(3, "B", "A", 1);
        grafoPrueba.insertarArco(1, "B", "C", 3);
        grafoPrueba.insertarArco(1, "C", "B", 2);
        grafoPrueba.insertarArco(4, "C", "D", 4); 
        grafoPrueba.insertarArco(4, "D", "C", 3); 
        grafoPrueba.insertarArco(6, "A", "D", 4); 
        grafoPrueba.insertarArco(6, "D", "A", 1); 
        grafoPrueba.insertarArco(1, "D", "Z", 0); 
        grafoPrueba.insertarArco(1, "Z", "D", 4); 
        
        grafoPrueba.getListaPrincipal().imprimirListaPrincipal();
        
        int[] dist = djikstra(grafoPrueba.getNumeroDeVertices(), grafoPrueba.getListaPrincipal(), 2);
        
        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i]);
        }
        
        System.out.println("Prueba para git");
        
    }
    
}
