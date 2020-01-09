package com.hellokoding.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hellokoding.account.model.Topo;

public interface TopoRepository extends JpaRepository<Topo, Long> {
    Topo findByToponame(String toponame);
}
