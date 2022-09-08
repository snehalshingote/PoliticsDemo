package com.party.App.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.party.App.entity.PartyEntity;

public interface PartyRepository extends JpaRepository<PartyEntity, Integer>{

}
