package com.example.T2.models.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.T2.models.entity.Denunciado;

@Repository
public class DenunciadoDAO_IMP implements IDenunciadoDAO{

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Denunciado> getDenunciados() {
		return em.createQuery("from Denunciado").getResultList();
	}

	
	@Override
	@Transactional
	public void guardar(Denunciado denunciado) {
		if(denunciado.getCod_denun() != null) {
			em.merge(denunciado);
		}else{
			em.persist(denunciado);
		}
		
	}

	@Override
	public Denunciado buscarDenunciado(Long cod_denun) {
		return em.find(Denunciado.class, cod_denun);
	}


	@Override
	@Transactional
	public void eliminar(Long cod_denun) {
		Denunciado denunciado = buscarDenunciado(cod_denun);
		em.remove(denunciado);
	}

}
