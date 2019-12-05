package com.windhelm.location.repo;

import com.windhelm.location.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface LocationReporsitory extends JpaRepository<Location,Integer> {

    @Query("select type,count(type) from Location group by type")
    List<Object[]> findTypeCount();
}
