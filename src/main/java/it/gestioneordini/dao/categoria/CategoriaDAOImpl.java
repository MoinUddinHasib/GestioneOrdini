package it.gestioneordini.dao.categoria;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Categoria;
import it.gestioneordini.model.Ordine;

public class CategoriaDAOImpl implements CategoriaDAO {
	
	private EntityManager entityManager;

	@Override
	public List<Categoria> list() throws Exception {
		return entityManager.createQuery("from Categoria",Categoria.class).getResultList();
	}

	@Override
	public Categoria get(Long id) throws Exception {
		return entityManager.find(Categoria.class, id);
	}

	@Override
	public void update(Categoria o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		o = entityManager.merge(o);
	}

	@Override
	public void insert(Categoria o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(o);
	}

	@Override
	public void delete(Categoria o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(o));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public List<Ordine> findAllOrdiniByCategoria(Categoria categoria) throws Exception {
		Set<Ordine> lo= new HashSet<>();
		String q="select c.articoli from Categoria c where c.id=?1";
		TypedQuery<Collection> query = entityManager.createQuery(q,Collection.class);
		List<Collection> lista_articoli =query.setParameter(1, categoria.getId()).getResultList();
		
		for(int i=0;i<lista_articoli.size();i++) {
			Articolo ar=(Articolo)lista_articoli.get(i);
			lo.add(ar.getOrdine());
		}
		return lo.stream().collect(Collectors.toList());
	}

	@Override
	public int sommaTotale(Categoria categoria) throws Exception {
		int ris=0;
		String q="select c.articoli from Categoria c where c.id=?1";
		TypedQuery<Collection> query = entityManager.createQuery(q,Collection.class);
		List<Collection> lista_articoli =query.setParameter(1, categoria.getId()).getResultList();
		
		for(int i=0;i<lista_articoli.size();i++) {
			Articolo ar=(Articolo)lista_articoli.get(i);
			ris+=ar.getPrezzoSingolo();
		}
		return ris;
	}

}
