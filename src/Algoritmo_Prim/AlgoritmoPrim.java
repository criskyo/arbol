package Algoritmo_Prim;

import Grafo.GrafMatPeso;
import Grafo.Vertice;

public class AlgoritmoPrim {
	
	private int [][] Pesos;
	private int n; // vertice origen y numero de vertices
	private Vertice[] vertices;
	int cont;
	
	public AlgoritmoPrim(GrafMatPeso gp, Vertice[] verts) {
		n= gp.numeroDeVertices();
		Pesos = gp.getMatPeso();
		vertices= verts;
		cont = 0;
	}
	
	protected int arbolExpancionPrim() {
		int longMin, menor;
		int z;
		int[] coste = new int[n];
		int[] masCerca = new int[n];
		boolean [] w = new boolean [n];
		for (int i = 0; i < n; i++) {
			w[i] = false; // conjunto vacio
		}
		longMin = 0;
		w[0] = true;// se parte del vertice 0
		//inicialmente coste[i] es la arista (0,i)
		for (int i = 1; i < n; i++) {
			coste[i] = Pesos[0][i];
			masCerca[i] = 0;
		}
		
		for (int i = 1; i < n; i++) {
			//busca vertice z de V-W mas cercano, de menor longitud de arista, a algun vertice de w
			menor = coste[1];
			z=1;
			for (int j = 2; j < n; j++) {
				if (coste[j]< menor) {
					menor = coste[j];
					z=j;
				}
			}
			longMin += menor;
			System.out.println((++ cont)+" Pasada: Vertice: "+vertices[masCerca[z]].nomVertice()+
					" -> "+ "Vertice: "+vertices[z].nomVertice()+"   Peso"+ coste[z]);
			w[z] = true; // vertice z se añade al conjunto w
			coste[z] = GrafMatPeso.INFINITO;
			//debido a la incorporacion de z , se ajusta coste[] para el resto de vertices
			for (int j = 1; j < n; j++) {
				if ((Pesos [z][j] < coste[j] ) && !w[j]) {
					coste[j] = Pesos [z][j];
					masCerca[j]=z;
				}
				
			}
			
					
		}
		return longMin;
		
	}
	
	
	public int[][] getPesos() {
		return Pesos;
	}

}
