package com.vv.personal.twm.crdb.v1.data.dao;

import com.vv.personal.twm.artifactory.generated.tw.VillaProto;
import com.vv.personal.twm.crdb.v1.data.entity.VillaEntity;
import com.vv.personal.twm.crdb.v1.data.repository.VillaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Vivek
 * @since 15/01/22
 */
@Component
@RequiredArgsConstructor
public class VillaDao {
    private final VillaRepository villaRepository;

    public void addVillas(VillaProto.VillaList villaList) {
        Instant currentTime = Instant.now();
        List<VillaEntity> villaEntities = villaList.getVillasList().stream()
                .map(villa -> generateVillaEntity(villa, currentTime)).collect(Collectors.toList());
        villaRepository.saveAll(villaEntities);
    }

    public VillaProto.VillaList getVillas(String world) {
        List<VillaEntity> villaEntities = villaRepository.findAllByWorld(world);

        return VillaProto.VillaList.newBuilder().addAllVillas(
                villaEntities.stream().map(
                        villaEntity -> VillaProto.Villa.newBuilder()
                                .setId(villaEntity.getVillaId())
                                .setX(villaEntity.getX())
                                .setY(villaEntity.getY())
                                .setType(VillaProto.VillaType.valueOf(villaEntity.getVillaType()))
                                .setWorld(villaEntity.getWorld())
                                .setName(villaEntity.getVillaName())
                                .setFarmStrength(villaEntity.getFarmStrength())
                                .setTimestamp(villaEntity.getCreatedTimestamp().toEpochMilli())
                                .setTroops(VillaProto.Troops.newBuilder()
                                        .setWl(villaEntity.getWall())
                                        .setSp(villaEntity.getSpear())
                                        .setSw(villaEntity.getSword())
                                        .setAx(villaEntity.getAxe())
                                        .setAr(villaEntity.getArch())
                                        .setSu(villaEntity.getScout())
                                        .setLc(villaEntity.getLcav())
                                        .setMa(villaEntity.getMarc())
                                        .setHc(villaEntity.getHcav())
                                        .setRm(villaEntity.getRam())
                                        .setCt(villaEntity.getCat())
                                        .setPd(villaEntity.getPalad())
                                        .setNb(villaEntity.getNoble())
                                        .build())
                                .build()
                ).collect(Collectors.toList())
        ).build();
    }

    private VillaEntity generateVillaEntity(VillaProto.Villa villa, Instant instant) {
        VillaEntity villaEntity = new VillaEntity();
        villaEntity.setVillaEntityId(UUID.randomUUID());
        villaEntity.setCreatedTimestamp(instant);

        villaEntity.setWorld(villa.getWorld());
        villaEntity.setVillaName(villa.getName());
        villaEntity.setX(villa.getX());
        villaEntity.setY(villa.getY());
        villaEntity.setVillaId(villa.getId());
        villaEntity.setVillaType(villa.getType().name());
        villaEntity.setFarmStrength(villa.getFarmStrength());

        villaEntity.setWall(villa.getTroops().getWl());
        villaEntity.setSpear(villa.getTroops().getSp());
        villaEntity.setSword(villa.getTroops().getSw());
        villaEntity.setAxe(villa.getTroops().getAx());
        villaEntity.setArch(villa.getTroops().getAr());
        villaEntity.setScout(villa.getTroops().getSu());
        villaEntity.setLcav(villa.getTroops().getLc());
        villaEntity.setMarc(villa.getTroops().getMa());
        villaEntity.setHcav(villa.getTroops().getHc());
        villaEntity.setRam(villa.getTroops().getRm());
        villaEntity.setCat(villa.getTroops().getCt());
        villaEntity.setPalad(villa.getTroops().getPd());
        villaEntity.setNoble(villa.getTroops().getNb());
        return villaEntity;
    }
}