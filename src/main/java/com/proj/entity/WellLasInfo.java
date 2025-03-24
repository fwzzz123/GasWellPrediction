package com.proj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName Well_Las_Info
 */
@TableName(value ="Well_Las_Info")
@Data
public class WellLasInfo implements Serializable {
    /**
     * 
     */
    @TableId(value = "Las_Info_ID",type = IdType.AUTO)
    private Object lasInfoId;

    /**
     * 
     */
    private String wellId;

    /**
     * 
     */
    private String strt;

    /**
     * 
     */
    private String stop;

    /**
     * 
     */
    private String step;

    /**
     * 
     */
    private String absentValue;

    /**
     * 
     */
    private String comp;

    /**
     * 
     */
    private String well;

    /**
     * 
     */
    private String fld;

    /**
     * 
     */
    private String loc;

    /**
     * 
     */
    private String ctry;

    /**
     * 
     */
    private String prov;

    /**
     * 
     */
    private String srvc;

    /**
     * 
     */
    private String date;

    /**
     * 
     */
    private String uwi;

    /**
     * 
     */
    private String cnty;

    /**
     * 
     */
    private String stat;

    /**
     * 
     */
    private String api;

    /**
     * 
     */
    private String lic;

    /**
     * 
     */
    private String lati;

    /**
     * 
     */
    private String wellLong;

    /**
     * 
     */
    private String gdat;

    /**
     * 
     */
    private String run;

    /**
     * 
     */
    private String pdat;

    /**
     * 
     */
    private String epd;

    /**
     * 
     */
    private String lmf;

    /**
     * 
     */
    private String apd;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        WellLasInfo other = (WellLasInfo) that;
        return (this.getLasInfoId() == null ? other.getLasInfoId() == null : this.getLasInfoId().equals(other.getLasInfoId()))
            && (this.getWellId() == null ? other.getWellId() == null : this.getWellId().equals(other.getWellId()))
            && (this.getStrt() == null ? other.getStrt() == null : this.getStrt().equals(other.getStrt()))
            && (this.getStop() == null ? other.getStop() == null : this.getStop().equals(other.getStop()))
            && (this.getStep() == null ? other.getStep() == null : this.getStep().equals(other.getStep()))
            && (this.getAbsentValue() == null ? other.getAbsentValue() == null : this.getAbsentValue().equals(other.getAbsentValue()))
            && (this.getComp() == null ? other.getComp() == null : this.getComp().equals(other.getComp()))
            && (this.getWell() == null ? other.getWell() == null : this.getWell().equals(other.getWell()))
            && (this.getFld() == null ? other.getFld() == null : this.getFld().equals(other.getFld()))
            && (this.getLoc() == null ? other.getLoc() == null : this.getLoc().equals(other.getLoc()))
            && (this.getCtry() == null ? other.getCtry() == null : this.getCtry().equals(other.getCtry()))
            && (this.getProv() == null ? other.getProv() == null : this.getProv().equals(other.getProv()))
            && (this.getSrvc() == null ? other.getSrvc() == null : this.getSrvc().equals(other.getSrvc()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
            && (this.getUwi() == null ? other.getUwi() == null : this.getUwi().equals(other.getUwi()))
            && (this.getCnty() == null ? other.getCnty() == null : this.getCnty().equals(other.getCnty()))
            && (this.getStat() == null ? other.getStat() == null : this.getStat().equals(other.getStat()))
            && (this.getApi() == null ? other.getApi() == null : this.getApi().equals(other.getApi()))
            && (this.getLic() == null ? other.getLic() == null : this.getLic().equals(other.getLic()))
            && (this.getLati() == null ? other.getLati() == null : this.getLati().equals(other.getLati()))
            && (this.getWellLong() == null ? other.getWellLong() == null : this.getWellLong().equals(other.getWellLong()))
            && (this.getGdat() == null ? other.getGdat() == null : this.getGdat().equals(other.getGdat()))
            && (this.getRun() == null ? other.getRun() == null : this.getRun().equals(other.getRun()))
            && (this.getPdat() == null ? other.getPdat() == null : this.getPdat().equals(other.getPdat()))
            && (this.getEpd() == null ? other.getEpd() == null : this.getEpd().equals(other.getEpd()))
            && (this.getLmf() == null ? other.getLmf() == null : this.getLmf().equals(other.getLmf()))
            && (this.getApd() == null ? other.getApd() == null : this.getApd().equals(other.getApd()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLasInfoId() == null) ? 0 : getLasInfoId().hashCode());
        result = prime * result + ((getWellId() == null) ? 0 : getWellId().hashCode());
        result = prime * result + ((getStrt() == null) ? 0 : getStrt().hashCode());
        result = prime * result + ((getStop() == null) ? 0 : getStop().hashCode());
        result = prime * result + ((getStep() == null) ? 0 : getStep().hashCode());
        result = prime * result + ((getAbsentValue() == null) ? 0 : getAbsentValue().hashCode());
        result = prime * result + ((getComp() == null) ? 0 : getComp().hashCode());
        result = prime * result + ((getWell() == null) ? 0 : getWell().hashCode());
        result = prime * result + ((getFld() == null) ? 0 : getFld().hashCode());
        result = prime * result + ((getLoc() == null) ? 0 : getLoc().hashCode());
        result = prime * result + ((getCtry() == null) ? 0 : getCtry().hashCode());
        result = prime * result + ((getProv() == null) ? 0 : getProv().hashCode());
        result = prime * result + ((getSrvc() == null) ? 0 : getSrvc().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getUwi() == null) ? 0 : getUwi().hashCode());
        result = prime * result + ((getCnty() == null) ? 0 : getCnty().hashCode());
        result = prime * result + ((getStat() == null) ? 0 : getStat().hashCode());
        result = prime * result + ((getApi() == null) ? 0 : getApi().hashCode());
        result = prime * result + ((getLic() == null) ? 0 : getLic().hashCode());
        result = prime * result + ((getLati() == null) ? 0 : getLati().hashCode());
        result = prime * result + ((getWellLong() == null) ? 0 : getWellLong().hashCode());
        result = prime * result + ((getGdat() == null) ? 0 : getGdat().hashCode());
        result = prime * result + ((getRun() == null) ? 0 : getRun().hashCode());
        result = prime * result + ((getPdat() == null) ? 0 : getPdat().hashCode());
        result = prime * result + ((getEpd() == null) ? 0 : getEpd().hashCode());
        result = prime * result + ((getLmf() == null) ? 0 : getLmf().hashCode());
        result = prime * result + ((getApd() == null) ? 0 : getApd().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lasInfoId=").append(lasInfoId);
        sb.append(", wellId=").append(wellId);
        sb.append(", strt=").append(strt);
        sb.append(", stop=").append(stop);
        sb.append(", step=").append(step);
        sb.append(", absentValue=").append(absentValue);
        sb.append(", comp=").append(comp);
        sb.append(", well=").append(well);
        sb.append(", fld=").append(fld);
        sb.append(", loc=").append(loc);
        sb.append(", ctry=").append(ctry);
        sb.append(", prov=").append(prov);
        sb.append(", srvc=").append(srvc);
        sb.append(", date=").append(date);
        sb.append(", uwi=").append(uwi);
        sb.append(", cnty=").append(cnty);
        sb.append(", stat=").append(stat);
        sb.append(", api=").append(api);
        sb.append(", lic=").append(lic);
        sb.append(", lati=").append(lati);
        sb.append(", wellLong=").append(wellLong);
        sb.append(", gdat=").append(gdat);
        sb.append(", run=").append(run);
        sb.append(", pdat=").append(pdat);
        sb.append(", epd=").append(epd);
        sb.append(", lmf=").append(lmf);
        sb.append(", apd=").append(apd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}