package Grafo;

public class GrafMatPeso {
	public static int INFINITO=0xFFFF;
	private int [][] matPeso;
	private Vertice [] verts;
	private int numVerts;
	
	public GrafMatPeso(int mx) {
		matPeso = new int [mx][mx];
		verts= new Vertice[mx];
		for (int i = 0; i < mx; i++) {
			for (int j = 0; j < mx; j++) {
				matPeso [i][j] = INFINITO;
			}
		numVerts=0;	
		}
	}
	
	//crea un nuevo vertice recibiendo su nombre de parametro
	public void nuevoVertice(String nom) {
		boolean esta = numVertice(nom) >= 0;
		if(!esta) {
			Vertice v = new Vertice(nom);
			v.asigVert(numVerts);
			verts[numVerts++]=v;
		}
	}
	
	
	//retorna el valor del peso entre las aristas ingresdados
	public int pesoArco(String a, String b) {
		int va, vb;
		va=numVertice(a);
		vb=numVertice(b);
		return matPeso[va][vb];
		
	}
	
	//retorna el numero del vertice
	public int numeroDeVertices() {
		return numVerts;
	}
	
	
	//retorna el array de vertices
	public Vertice[] vertices() {
		return verts;
	}
	
	//crea un uevo arco entre dos vertices con un peso especificado en los parametros
	public void nuevoArco(String a, String b, int peso) {
		int va, vb;
		va=numVertice(a);
		vb=numVertice(b);
		matPeso[va][vb]= peso;
	}
	
	//valida que escista el vertice con el nombre que recibe en el parametro
	public int numVertice(String vs) {
		Vertice v = new Vertice(vs);
		boolean encontrado= false;
		int i = 0;
		for (; (i<numVerts) && !encontrado; ) {
			encontrado=verts[i].equals(v);
			if (!encontrado) i++;
		}
		return (i<numVerts) ? i : -1;
	}
	
	
	//retorna la matriz de pesos
	public int[][] getMatPeso(){
		return matPeso;
	}
	
	
	
	

}
