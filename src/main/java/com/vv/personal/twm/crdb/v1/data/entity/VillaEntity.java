package com.vv.personal.twm.crdb.v1.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author Vivek
 * @since 15/01/22
 */
@Entity
@Table(name = "tw_villa")
public class VillaEntity {

    @EmbeddedId
    private VillaIdentifier villaIdentifier;

    @Column(name = "name_villa")
    private String villaName;

    @Column(name = "id_villa")
    private String villaId;

    @Column(name = "type_villa")
    private String villaType;

    @Column(name = "wl")
    private int wall;

    @Column(name = "sp")
    private int spear;

    @Column(name = "sw")
    private int sword;

    @Column(name = "ax")
    private int axe;

    @Column(name = "ar")
    private int arch;

    @Column(name = "su")
    private int scout;

    @Column(name = "lc")
    private int lcav;

    @Column(name = "ma")
    private int marc;

    @Column(name = "hc")
    private int hcav;

    @Column(name = "rm")
    private int ram;

    @Column(name = "ct")
    private int cat;

    @Column(name = "pd")
    private int palad;

    @Column(name = "nb")
    private int noble;

    @Column(name = "farm")
    private String farmStrength;

    public VillaEntity() {
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("world", villaIdentifier.getWorld())
                .append("villaName", villaName)
                .append("x", villaIdentifier.getX())
                .append("y", villaIdentifier.getY())
                .append("villaId", villaId)
                .append("villaType", villaType)
                .append("wall", wall)
                .append("spear", spear)
                .append("sword", sword)
                .append("axe", axe)
                .append("arch", arch)
                .append("scout", scout)
                .append("lcav", lcav)
                .append("marc", marc)
                .append("hcav", hcav)
                .append("ram", ram)
                .append("cat", cat)
                .append("palad", palad)
                .append("noble", noble)
                .append("farmStrength", farmStrength)
                .append("createdTimestamp", villaIdentifier.getCreatedTimestamp())
                .toString();
    }

    public VillaIdentifier getVillaIdentifier() {
        return villaIdentifier;
    }

    public VillaEntity setVillaIdentifier(VillaIdentifier villaIdentifier) {
        this.villaIdentifier = villaIdentifier;
        return this;
    }

    public String getVillaName() {
        return villaName;
    }

    public VillaEntity setVillaName(String villaName) {
        this.villaName = villaName;
        return this;
    }

    public String getVillaId() {
        return villaId;
    }

    public VillaEntity setVillaId(String villaId) {
        this.villaId = villaId;
        return this;
    }

    public String getVillaType() {
        return villaType;
    }

    public VillaEntity setVillaType(String villaType) {
        this.villaType = villaType;
        return this;
    }

    public int getWall() {
        return wall;
    }

    public VillaEntity setWall(int wall) {
        this.wall = wall;
        return this;
    }

    public int getSpear() {
        return spear;
    }

    public VillaEntity setSpear(int spear) {
        this.spear = spear;
        return this;
    }

    public int getSword() {
        return sword;
    }

    public VillaEntity setSword(int sword) {
        this.sword = sword;
        return this;
    }

    public int getAxe() {
        return axe;
    }

    public VillaEntity setAxe(int axe) {
        this.axe = axe;
        return this;
    }

    public int getArch() {
        return arch;
    }

    public VillaEntity setArch(int arch) {
        this.arch = arch;
        return this;
    }

    public int getScout() {
        return scout;
    }

    public VillaEntity setScout(int scout) {
        this.scout = scout;
        return this;
    }

    public int getLcav() {
        return lcav;
    }

    public VillaEntity setLcav(int lcav) {
        this.lcav = lcav;
        return this;
    }

    public int getMarc() {
        return marc;
    }

    public VillaEntity setMarc(int marc) {
        this.marc = marc;
        return this;
    }

    public int getHcav() {
        return hcav;
    }

    public VillaEntity setHcav(int hcav) {
        this.hcav = hcav;
        return this;
    }

    public int getRam() {
        return ram;
    }

    public VillaEntity setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public int getCat() {
        return cat;
    }

    public VillaEntity setCat(int cat) {
        this.cat = cat;
        return this;
    }

    public int getPalad() {
        return palad;
    }

    public VillaEntity setPalad(int palad) {
        this.palad = palad;
        return this;
    }

    public int getNoble() {
        return noble;
    }

    public VillaEntity setNoble(int noble) {
        this.noble = noble;
        return this;
    }

    public String getFarmStrength() {
        return farmStrength;
    }

    public VillaEntity setFarmStrength(String farmStrength) {
        this.farmStrength = farmStrength;
        return this;
    }
}