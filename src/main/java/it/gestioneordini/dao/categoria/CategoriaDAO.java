package it.gestioneordini.dao.categoria;

import java.util.List;

import it.gestioneordini.dao.IBaseDAO;
import it.gestioneordini.model.*;

public interface CategoriaDAO extends IBaseDAO<Categoria>{
	
	public List<Ordine> findAllOrdiniByCategoria(Categoria categoria) throws Exception;
	
	public int sommaTotale(Categoria categoria) throws Exception;

}
