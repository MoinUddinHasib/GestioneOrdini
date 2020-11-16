package it.gestioneordini.service.categoria;

import java.util.List;

import it.gestioneordini.dao.categoria.CategoriaDAO;
import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Categoria;
import it.gestioneordini.model.Ordine;
import it.gestioneordini.service.IBaseService;

public interface CategoriaService extends IBaseService<Categoria> {

	//per injection
	public void setCategoriaDAO(CategoriaDAO categoriaDAO);
	
	public List<Ordine> tuttiGliOrdiniDiUnaCategoria(Categoria categoria) throws Exception;
	
	public int totalePrezziDiUnaCategoria(Categoria categoria) throws Exception;

	public Categoria inserisciArticolo(Categoria c1, Articolo a1) throws Exception;

}
