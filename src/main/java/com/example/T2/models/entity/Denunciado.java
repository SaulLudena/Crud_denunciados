package com.example.T2.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="denunciados")
public class Denunciado implements Serializable{

	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod_denun;
	private String nom_denun;
	private String ape_denun;
	private int dni_denun;
	private String nacio_denun;
	private String distri_denun;
	private String orden_denun;
	@Temporal(TemporalType.DATE)
	//Fecha manual
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha_denun;
	
	//Fecha automatica
	@PrePersist
	public void prePersist(){
		//fecha_denun = new Date();
	}

	public Long getCod_denun() {
		return cod_denun;
	}

	public void setCod_denun(Long cod_denun) {
		this.cod_denun = cod_denun;
	}

	public String getNom_denun() {
		return nom_denun;
	}

	public void setNom_denun(String nom_denun) {
		this.nom_denun = nom_denun;
	}

	public String getApe_denun() {
		return ape_denun;
	}

	public void setApe_denun(String ape_denun) {
		this.ape_denun = ape_denun;
	}

	public int getDni_denun() {
		return dni_denun;
	}

	public void setDni_denun(int dni_denun) {
		this.dni_denun = dni_denun;
	}

	public String getNacio_denun() {
		return nacio_denun;
	}

	public void setNacio_denun(String nacio_denun) {
		this.nacio_denun = nacio_denun;
	}

	public String getDistri_denun() {
		return distri_denun;
	}

	public void setDistri_denun(String distri_denun) {
		this.distri_denun = distri_denun;
	}

	public String getOrden_denun() {
		return orden_denun;
	}

	public void setOrden_denun(String orden_denun) {
		this.orden_denun = orden_denun;
	}

	public Date getFecha_denun() {
		return fecha_denun;
	}

	public void setFecha_denun(Date fecha_denun) {
		this.fecha_denun = fecha_denun;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	



	
}

