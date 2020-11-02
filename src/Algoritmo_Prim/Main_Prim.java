package Algoritmo_Prim;

import Grafo.GrafMatPeso;

public class Main_Prim {
	
	public static void main(String[] args) {
		//numero de vertices
		int n= 7;
		
		// instanciamos el objeto que va a contener el grafo
		GrafMatPeso gra = new GrafMatPeso(n);
		String a = "A";
		String b = "B";
		String c = "C";
		String d = "D";
		String e = "E";
		String f = "F";
		String g = "G";
		
		//nombres de las aristas
		
		gra.nuevoVertice(a);
		gra.nuevoVertice(b);
		gra.nuevoVertice(c);
		gra.nuevoVertice(d);
		gra.nuevoVertice(e);
		gra.nuevoVertice(f);
		gra.nuevoVertice(g);
		
		
		//creamos los vertices
		gra.nuevoArco(a, b, 2);
		gra.nuevoArco(b, a, 2);
		
		gra.nuevoArco(a, c, 3);
		gra.nuevoArco(c, a, 3);
		
		gra.nuevoArco(b, c, 1);
		gra.nuevoArco(c, b, 1);
		
		gra.nuevoArco(b, d, 1);
		gra.nuevoArco(d, b, 1);
		
		gra.nuevoArco(b, e, 4);
		gra.nuevoArco(e, b, 4);
		
		gra.nuevoArco(d, e, 1);
		gra.nuevoArco(e, d, 1);
		
		gra.nuevoArco(c, f, 5);
		gra.nuevoArco(f, c, 5);
		
		gra.nuevoArco(e, f, 1);
		gra.nuevoArco(f, e, 1);
		
		gra.nuevoArco(g, f, 1);
		gra.nuevoArco(f, g, 1);
		
		
		// imprimir los vertices existentes en el grafo
		
		System.out.println("Vertices del grafo");
		for (int i = 0; i< n ; i++) {
			System.out.print(gra.vertices() [i].nomVertice()+" ");
		}
		System.out.println();
		
		//instanciamos el objeto ArbolExpancionMinimo
		AlgoritmoPrim arbol = new AlgoritmoPrim(gra, gra.vertices());
		System.out.println("Costo del arbol minimo: "+ arbol.arbolExpancionPrim());
		
		
		
		
		for (int x=0; x < arbol.getPesos().length; x++) {
			  System.out.print("|");
			  for (int y=0; y < arbol.getPesos()[x].length; y++) {
			    System.out.print ((arbol.getPesos()[x][y]==0xFFFF)? "X": arbol.getPesos()[x][y]);
			    if (y!=arbol.getPesos()[x].length-1) System.out.print("\t");
			  }
			  System.out.println("|");
			}
				
	}

}
