package com.hellokoding.account.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_topo")
public class Topo {
    private Long id;
    private String toponame;
    private String region;
    private int nbSites;
    private int nbSecteurs;
    private int nbVoies;
    private boolean disponible;
    private String description;
    private Date datePublication;;
   
    
    

    public Topo() {
		super();
		
	}

	public Topo(Long id, String toponame, String region, int nbSites, int nbSecteurs, int nbVoies, boolean disponible,
			String description, Date datePublication) {
		super();
		this.id = id;
		this.toponame = toponame;
		this.region = region;
		this.nbSites = nbSites;
		this.nbSecteurs = nbSecteurs;
		this.nbVoies = nbVoies;
		this.disponible = disponible;
		this.description = description;
		this.datePublication = datePublication;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name = "topo_id", length = 50, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getToponame() {
		return toponame;
	}

	public void setToponame(String toponame) {
		this.toponame = toponame;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getNbSites() {
		return nbSites;
	}

	public void setNbSites(int nbSites) {
		this.nbSites = nbSites;
	}

	public int getNbSecteurs() {
		return nbSecteurs;
	}

	public void setNbSecteurs(int nbSecteurs) {
		this.nbSecteurs = nbSecteurs;
	}

	public int getNbVoies() {
		return nbVoies;
	}

	public void setNbVoies(int nbVoies) {
		this.nbVoies = nbVoies;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

   

}
