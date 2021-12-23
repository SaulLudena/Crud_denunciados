package com.example.T2.models.DAO;

import java.util.List;
import com.example.T2.models.entity.Denunciado;

public interface IDenunciadoDAO {

	public List<Denunciado> getDenunciados();
	public void  guardar(Denunciado denunciado);
	public Denunciado buscarDenunciado(Long cod_denun);
	public void eliminar(Long cod_denun);
}
