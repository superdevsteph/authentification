package com.hellokoding.account.service;

import java.util.List;

import com.hellokoding.account.model.Topo;



public interface TopoService {
    
	public void saveTopo(Topo topo);
    
    public List<Topo> listTopoInfos();


    Topo findByToponame(String toponame);
 
    
	public Topo findTopo(Long id);
	
	
	public void deleteTopo(Long id);

	Topo findTopo1(Long id);
    
    
    
}
