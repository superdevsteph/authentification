package com.hellokoding.account.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hellokoding.account.model.Topo;
import com.hellokoding.account.repository.TopoRepository;

@Repository
public class TopoServiceImpl implements TopoService {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
    @Autowired
    private TopoRepository topoRepository;
    
    @Override
	public Topo findTopo(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Topo.class);
		crit.add(Restrictions.eq("id", id));
		return (Topo) crit.uniqueResult();
	}

    
	@Override
	public Topo findTopo1(Long id) {
		Topo topo = this.findTopo(id);
		if (topo == null) {
			return null;
		}
		return new Topo(topo.getId(), topo.getToponame(), //
				topo.getRegion(), topo.getNbSites(), //
				topo.getNbSecteurs(), topo.getNbVoies(), topo.isDisponible(), topo.getDescription(), topo.getDatePublication());
	}

	
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Topo> listTopoInfos() {
		String sql = "Select new " + Topo.class.getName()//
				+ "(t.id, t.toponame, t.region, t.nbSites, t.nbSecteurs,  t.nbVoies, t.disponible, t.description, t.datePublication) "//
				+ " from " + Topo.class.getName() + " t ";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sql);
		return query.list();
	}
	
	
	 @Transactional
    @Override
    public void saveTopo(Topo topo) {
       
    	Long id = topo.getId();
		Topo Topo = null;
		if (id != null) {
			Topo = this.findTopo(id);
		}
		boolean isNew = false;
		if (Topo == null) {
			isNew = true;
			Topo = new Topo();

		}
	
		Topo.setToponame(Topo.getToponame());
		Topo.setRegion(Topo.getRegion());
		Topo.setNbSites(Topo.getNbSites());
		Topo.setNbSecteurs(Topo.getNbSecteurs());
		Topo.setNbVoies(Topo.getNbVoies());
		Topo.setDisponible(Topo.isDisponible());
		Topo.setDescription(Topo.getDescription());
		Topo.setDatePublication(Topo.getDatePublication());
		
		
		if (isNew) {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(Topo);
		}
	}

    @Override
    public Topo findByToponame(String toponame) {
        return topoRepository.findByToponame(toponame);
    }
    


    @Transactional
	@Override
	public void deleteTopo(Long id) {
		Topo Topo = this.findTopo(id);
		if (Topo != null) {
			this.sessionFactory.getCurrentSession().delete(Topo);
		}
	}
}
