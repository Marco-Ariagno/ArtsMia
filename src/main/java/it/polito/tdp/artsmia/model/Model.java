package it.polito.tdp.artsmia.model;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.artsmia.db.ArtsmiaDAO;

public class Model {

	private Graph<ArtObject, DefaultWeightedEdge> grafo;

	private Map<Integer, ArtObject> idMap;

	public Model() {
		idMap = new HashMap<>();
	}

	public void creaGrafo() {
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

		ArtsmiaDAO dao = new ArtsmiaDAO();
		dao.listObjects(idMap);

		// Aggiungo vertici

		Graphs.addAllVertices(this.grafo, idMap.values());

		// Aggiungo archi

		// APPROCCIO 1 (non funziona sempre) --> doppio ciclo for sui vertici
		//troppo lungo , 67 giorni per farcela, troppe query
		// dati due verici controllo se sono collegati

		/*for (ArtObject a1 : this.grafo.vertexSet()) {
			for (ArtObject a2 : this.grafo.vertexSet()) {
				// devo collegare a1 con a2??
				// controllo se non esiste gia arco
				int peso = dao.getPeso(a1, a2);
				if (peso > 0) {
					if (this.grafo.containsEdge(a1, a2)) {
						// inserisco arco
						Graphs.addEdge(this.grafo, a1, a2, peso);
					}
				}
			}
		}*/
		//Approccio 2 via di mezzo
		//Approccio 3 --> migliore
		
		for(Adiacenza a:dao.getAdiacenza()) {
			if(a.getPeso()>0) {
				Graphs.addEdge(this.grafo, idMap.get(a.getObj1()), idMap.get(a.getObj2()), a.getPeso());
			}			
		}
		
	}
	
	public int nVertici() {
		return this.grafo.vertexSet().size();
	}
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}

}
