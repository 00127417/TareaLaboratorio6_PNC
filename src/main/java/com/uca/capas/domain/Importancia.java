package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "importancia")
public class Importancia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c_importancia")
	private Integer CodigoImportancia;
	
	@Column(name = "s_importancia")
	private String Importancia;
	
	@OneToMany(mappedBy = "CodigoImportancia", fetch = FetchType.LAZY)
	private List<Contribuyente> ContriList;
	
	public Importancia() {
		
	}

	public Integer getCodigoImportancia() {
		return CodigoImportancia;
	}

	public void setCodigoImportancia(Integer codigoImportancia) {
		CodigoImportancia = codigoImportancia;
	}

	public String getImportancia() {
		return Importancia;
	}

	public void setImportancia(String importancia) {
		Importancia = importancia;
	}

	public List<Contribuyente> getContriList() {
		return ContriList;
	}

	public void setContriList(List<Contribuyente> contriList) {
		ContriList = contriList;
	}
	
	
	
}
