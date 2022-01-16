package com.vv.personal.twm.crdb.v1.data.repository;

import com.vv.personal.twm.crdb.v1.data.entity.VillaEntity;
import com.vv.personal.twm.crdb.v1.data.entity.VillaIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Vivek
 * @since 15/01/22
 */
@Repository
public interface VillaRepository extends JpaRepository<VillaEntity, VillaIdentifier> {

    List<VillaEntity> findAllByVillaIdentifierWorld(String world);
}