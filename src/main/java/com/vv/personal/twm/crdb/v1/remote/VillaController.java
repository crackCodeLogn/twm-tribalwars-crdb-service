package com.vv.personal.twm.crdb.v1.remote;

import com.vv.personal.twm.artifactory.generated.tw.VillaProto;
import com.vv.personal.twm.crdb.v1.data.dao.VillaDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author Vivek
 * @since 15/01/22
 */
@Slf4j
@RequiredArgsConstructor
@RestController("villa-controller")
@RequestMapping("/crdb/tw/")
public class VillaController {

    private final VillaDao villaDao;

    @PostMapping("/add-villas")
    public String addVillas(@RequestBody VillaProto.VillaList villaList) {
        log.info("Received request to add '{}' villas into db", villaList.getVillasCount());
        try {
            villaDao.addVillas(villaList);
            log.info("Done!");
            return "Done";
        } catch (Exception e) {
            log.error("Failed to write all data correctly for {} villas from villaList. ", villaList.getVillasCount(), e);
        }
        return "Failed";
    }

    @GetMapping("/read/all")
    public VillaProto.VillaList readAllVillasFromCrdb(@RequestParam String world) {
        log.info("Received request to read all villas from world '{}' from db", world);
        try {
            return villaDao.getVillas(world);
        } catch (Exception e) {
            log.error("Failed to get all villas for {}. ", world, e);
        }
        return VillaProto.VillaList.newBuilder().build();
    }
}