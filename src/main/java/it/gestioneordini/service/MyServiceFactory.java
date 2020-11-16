package it.gestioneordini.service;

import it.gestioneordini.dao.*;
import it.gestioneordini.service.articolo.ArticoloService;
import it.gestioneordini.service.articolo.ArticoloServiceImpl;
import it.gestioneordini.service.categoria.CategoriaService;
import it.gestioneordini.service.categoria.CategoriaServiceImpl;
import it.gestioneordini.service.ordine.OrdineService;
import it.gestioneordini.service.ordine.OrdineServiceImpl;

public class MyServiceFactory {

	private static ArticoloService ARTICOLO_SERVICE_INSTANCE = null;
	private static OrdineService ORDINE_SERVICE_INSTANCE = null;
	private static CategoriaService CATEGORIA_SERVICE_INSTANCE = null;
	
	public static ArticoloService getArticoloServiceInstance() {
		if(ARTICOLO_SERVICE_INSTANCE == null)
			ARTICOLO_SERVICE_INSTANCE = new ArticoloServiceImpl();
		ARTICOLO_SERVICE_INSTANCE.setArticoloDAO(MyDAOFactory.getArticoloDAOInstance());
		return ARTICOLO_SERVICE_INSTANCE;
	}
	
	public static OrdineService getOrdineServiceInstance() {
		if(ORDINE_SERVICE_INSTANCE == null)
			ORDINE_SERVICE_INSTANCE = new OrdineServiceImpl();
		ORDINE_SERVICE_INSTANCE.setOrdineDAO(MyDAOFactory.getOrdineDAOInstance());
		return ORDINE_SERVICE_INSTANCE;
	}
	
	public static CategoriaService getCategoriaServiceInstance() {
		if(CATEGORIA_SERVICE_INSTANCE == null)
			CATEGORIA_SERVICE_INSTANCE = new CategoriaServiceImpl();
		CATEGORIA_SERVICE_INSTANCE.setCategoriaDAO(MyDAOFactory.getCategoriaDAOInstance());
		return CATEGORIA_SERVICE_INSTANCE;
	}
}
