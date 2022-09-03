package com.springboot.app.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.entity.Track;

@Repository
public interface Repo extends CrudRepository<Track,String>{

}
