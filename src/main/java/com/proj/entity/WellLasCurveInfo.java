package com.proj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName Well_Las_Curve_Info
 */
@TableName(value ="Well_Las_Curve_Info")
@Data
public class WellLasCurveInfo implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Object curveInfoId;

    /**
     * 
     */
    private Integer lasInfoId;

    /**
     * 
     */
    private BigDecimal dept;

    /**
     * 
     */
    private BigDecimal ao10;

    /**
     * 
     */
    private BigDecimal ao20;

    /**
     * 
     */
    private BigDecimal ao60;

    /**
     * 
     */
    private BigDecimal ao90;

    /**
     * 
     */
    private BigDecimal aplc;

    /**
     * 
     */
    private BigDecimal bs;

    /**
     * 
     */
    private BigDecimal cals;

    /**
     * 
     */
    private BigDecimal dt;

    /**
     * 
     */
    private BigDecimal dts;

    /**
     * 
     */
    private BigDecimal dt4p;

    /**
     * 
     */
    private BigDecimal dtc;

    /**
     * 
     */
    private BigDecimal gr;

    /**
     * 
     */
    private BigDecimal pefl;

    /**
     * 
     */
    private BigDecimal rhom;

    /**
     * 
     */
    private BigDecimal vpvs;

    /**
     * 
     */
    private BigDecimal sigf;

    /**
     * 
     */
    private BigDecimal a16h;

    /**
     * 
     */
    private BigDecimal a22h;

    /**
     * 
     */
    private BigDecimal a28h;

    /**
     * 
     */
    private BigDecimal a34h;

    /**
     * 
     */
    private BigDecimal a40h;

    /**
     * 
     */
    private BigDecimal cal;

    /**
     * 
     */
    private BigDecimal cncf;

    /**
     * 
     */
    private BigDecimal k;

    /**
     * 
     */
    private BigDecimal kth;

    /**
     * 
     */
    private BigDecimal m2r1;

    /**
     * 
     */
    private BigDecimal m2r2;

    /**
     * 
     */
    private BigDecimal m2r3;

    /**
     * 
     */
    private BigDecimal m2r6;

    /**
     * 
     */
    private BigDecimal m2r9;

    /**
     * 
     */
    private BigDecimal m2rx;

    /**
     * 
     */
    private BigDecimal pe;

    /**
     * 
     */
    private BigDecimal rop5Rm;

    /**
     * 
     */
    private BigDecimal sp;

    /**
     * 
     */
    private BigDecimal th;

    /**
     * 
     */
    private BigDecimal u;

    /**
     * 
     */
    private BigDecimal zcor;

    /**
     * 
     */
    private BigDecimal zden;

    /**
     * 
     */
    private BigDecimal bit;

    /**
     * 
     */
    private BigDecimal phit;

    /**
     * 
     */
    private BigDecimal pign;

    /**
     * 
     */
    private BigDecimal rhgf;

    /**
     * 
     */
    private BigDecimal suwi;

    /**
     * 
     */
    private BigDecimal sxwi;

    /**
     * 
     */
    private BigDecimal vcl;

    /**
     * 
     */
    private BigDecimal spsbdh;

    /**
     * 
     */
    private BigDecimal bfv;

    /**
     * 
     */
    private BigDecimal cmff;

    /**
     * 
     */
    private BigDecimal drho;

    /**
     * 
     */
    private BigDecimal dtco;

    /**
     * 
     */
    private BigDecimal dtsm;

    /**
     * 
     */
    private BigDecimal hcal;

    /**
     * 
     */
    private BigDecimal ksdr;

    /**
     * 
     */
    private BigDecimal ktim;

    /**
     * 
     */
    private BigDecimal p16h;

    /**
     * 
     */
    private BigDecimal p22h;

    /**
     * 
     */
    private BigDecimal p28h;

    /**
     * 
     */
    private BigDecimal p34h;

    /**
     * 
     */
    private BigDecimal p40h;

    /**
     * 
     */
    private BigDecimal pefz;

    /**
     * 
     */
    private BigDecimal rhoz;

    /**
     * 
     */
    private BigDecimal rop5;

    /**
     * 
     */
    private BigDecimal tcmr;

    /**
     * 
     */
    private BigDecimal tnph;

    /**
     * 
     */
    private BigDecimal cmrp3ms;

    /**
     * 
     */
    private BigDecimal swirr;

    /**
     * 
     */
    private BigDecimal spdh;

    /**
     * 
     */
    private BigDecimal dzod;

    /**
     * 
     */
    private BigDecimal dvod;

    /**
     * 
     */
    private BigDecimal ten;

    /**
     * 
     */
    private BigDecimal ac;

    /**
     * 
     */
    private BigDecimal cnc;

    /**
     * 
     */
    private BigDecimal den;

    /**
     * 
     */
    private BigDecimal rfoc;

    /**
     * 
     */
    private BigDecimal rild;

    /**
     * 
     */
    private BigDecimal rilm;

    /**
     * 
     */
    private BigDecimal cgr;

    /**
     * 
     */
    private BigDecimal ild;

    /**
     * 
     */
    private BigDecimal ilm;

    /**
     * 
     */
    private BigDecimal msfl;

    /**
     * 
     */
    private BigDecimal nphi;

    /**
     * 
     */
    private BigDecimal pef;

    /**
     * 
     */
    private BigDecimal pota;

    /**
     * 
     */
    private BigDecimal rhob;

    /**
     * 
     */
    private BigDecimal thor;

    /**
     * 
     */
    private BigDecimal uran;

    /**
     * 
     */
    private BigDecimal sgr;

    /**
     * 
     */
    private BigDecimal abgt;

    /**
     * 
     */
    private BigDecimal acal;

    /**
     * 
     */
    private BigDecimal batc;

    /**
     * 
     */
    private BigDecimal pore;

    /**
     * 
     */
    private BigDecimal sbd2;

    /**
     * 
     */
    private BigDecimal seda;

    /**
     * 
     */
    private BigDecimal sedc;

    /**
     * 
     */
    private BigDecimal sedp;

    /**
     * 
     */
    private BigDecimal semc;

    /**
     * 
     */
    private BigDecimal semp;

    /**
     * 
     */
    private BigDecimal sesc;

    /**
     * 
     */
    private BigDecimal sesp;

    /**
     * 
     */
    private BigDecimal sexc;

    /**
     * 
     */
    private BigDecimal sexp;

    /**
     * 
     */
    private BigDecimal sgrc;

    /**
     * 
     */
    private BigDecimal splf;

    /**
     * 
     */
    private BigDecimal sw;

    /**
     * 
     */
    private BigDecimal srop;

    /**
     * 
     */
    private BigDecimal dtcp;

    /**
     * 
     */
    private BigDecimal dtsd;

    /**
     * 
     */
    private BigDecimal dtsp;

    /**
     * 
     */
    private BigDecimal port;

    /**
     * 
     */
    private BigDecimal shsi;

    /**
     * 
     */
    private BigDecimal tvd;

    /**
     * 
     */
    private BigDecimal drhb;

    /**
     * 
     */
    private BigDecimal drhl;

    /**
     * 
     */
    private BigDecimal drhr;

    /**
     * 
     */
    private BigDecimal drhu;

    /**
     * 
     */
    private BigDecimal robb;

    /**
     * 
     */
    private BigDecimal robl;

    /**
     * 
     */
    private BigDecimal robr;

    /**
     * 
     */
    private BigDecimal robu;

    /**
     * 
     */
    private BigDecimal tnpb;

    /**
     * 
     */
    private BigDecimal tvdRc;

    /**
     * 
     */
    private BigDecimal grma;

    /**
     * 
     */
    private BigDecimal crpm;

    /**
     * 
     */
    private BigDecimal dcav;

    /**
     * 
     */
    private BigDecimal dcho;

    /**
     * 
     */
    private BigDecimal dcve;

    /**
     * 
     */
    private BigDecimal p16l;

    /**
     * 
     */
    private BigDecimal p22l;

    /**
     * 
     */
    private BigDecimal p28l;

    /**
     * 
     */
    private BigDecimal p40l;

    /**
     * 
     */
    private BigDecimal a16l;

    /**
     * 
     */
    private BigDecimal a22l;

    /**
     * 
     */
    private BigDecimal a28l;

    /**
     * 
     */
    private BigDecimal a34l;

    /**
     * 
     */
    private BigDecimal a40l;

    /**
     * 
     */
    private BigDecimal peb;

    /**
     * 
     */
    private BigDecimal pel;

    /**
     * 
     */
    private BigDecimal per;

    /**
     * 
     */
    private BigDecimal peu;

    /**
     * 
     */
    private BigDecimal sifa;

    /**
     * 
     */
    private BigDecimal tabArcRes;

    /**
     * 
     */
    private BigDecimal tabDen;

    /**
     * 
     */
    private BigDecimal tabGr;

    /**
     * 
     */
    private BigDecimal tabNeu;

    /**
     * 
     */
    private BigDecimal sbdc;

    /**
     * 
     */
    private BigDecimal sco2;

    /**
     * 
     */
    private BigDecimal scor;

    /**
     * 
     */
    private BigDecimal sdde;

    /**
     * 
     */
    private BigDecimal sfb2;

    /**
     * 
     */
    private BigDecimal sgra;

    /**
     * 
     */
    private BigDecimal sgrb;

    /**
     * 
     */
    private BigDecimal snb2;

    /**
     * 
     */
    private BigDecimal snfa;

    /**
     * 
     */
    private BigDecimal snna;

    /**
     * 
     */
    private BigDecimal snp2;

    /**
     * 
     */
    private BigDecimal snpe;

    /**
     * 
     */
    private BigDecimal stem;

    /**
     * 
     */
    private BigDecimal calp;

    /**
     * 
     */
    private BigDecimal dtcr;

    /**
     * 
     */
    private BigDecimal dtdr;

    /**
     * 
     */
    private BigDecimal dtpc;

    /**
     * 
     */
    private BigDecimal grpcl;

    /**
     * 
     */
    private BigDecimal poredt;

    /**
     * 
     */
    private BigDecimal atmp;

    /**
     * 
     */
    private BigDecimal hord;

    /**
     * 
     */
    private BigDecimal verd;

    /**
     * 
     */
    private BigDecimal vw;

    /**
     * 
     */
    private BigDecimal vxo;

    /**
     * 
     */
    private BigDecimal grbz;

    /**
     * 
     */
    private BigDecimal sdea;

    /**
     * 
     */
    private BigDecimal abga;

    /**
     * 
     */
    private BigDecimal abgb;

    /**
     * 
     */
    private BigDecimal abgc;

    /**
     * 
     */
    private BigDecimal tvde;

    /**
     * 
     */
    private BigDecimal grArc;

    /**
     * 
     */
    private BigDecimal pdGravBhc;

    /**
     * 
     */
    private BigDecimal p34l;

    /**
     * 
     */
    private BigDecimal tabArc;

    /**
     * 
     */
    private BigDecimal rpmAdn;

    /**
     * 
     */
    private BigDecimal aco;

    /**
     * 
     */
    private BigDecimal acq;

    /**
     * 
     */
    private BigDecimal cht;

    /**
     * 
     */
    private BigDecimal cn;

    /**
     * 
     */
    private BigDecimal cnlo;

    /**
     * 
     */
    private BigDecimal corr;

    /**
     * 
     */
    private BigDecimal deno;

    /**
     * 
     */
    private BigDecimal lsd;

    /**
     * 
     */
    private BigDecimal lsn;

    /**
     * 
     */
    private BigDecimal perm;

    /**
     * 
     */
    private BigDecimal rto;

    /**
     * 
     */
    private BigDecimal ssd;

    /**
     * 
     */
    private BigDecimal ssn;

    /**
     * 
     */
    private BigDecimal swb;

    /**
     * 
     */
    private BigDecimal dgr;

    /**
     * 
     */
    private BigDecimal nucp;

    /**
     * 
     */
    private BigDecimal sfxe;

    /**
     * 
     */
    private BigDecimal gre;

    /**
     * 
     */
    private BigDecimal appc;

    /**
     * 
     */
    private BigDecimal rop;

    /**
     * 
     */
    private BigDecimal sema;

    /**
     * 
     */
    private BigDecimal sesa;

    /**
     * 
     */
    private BigDecimal sexa;

    /**
     * 
     */
    private BigDecimal wrm;

    /**
     * 
     */
    private BigDecimal scrd;

    /**
     * 
     */
    private BigDecimal htem;

    /**
     * 
     */
    private BigDecimal rxo;

    /**
     * 
     */
    private BigDecimal rt;

    /**
     * 
     */
    private BigDecimal rm;

    /**
     * 
     */
    private BigDecimal rla5;

    /**
     * 
     */
    private BigDecimal rla4;

    /**
     * 
     */
    private BigDecimal rla3;

    /**
     * 
     */
    private BigDecimal rla2;

    /**
     * 
     */
    private BigDecimal rla1;

    /**
     * 
     */
    private BigDecimal pr;

    /**
     * 
     */
    private BigDecimal dt1;

    /**
     * 
     */
    private BigDecimal cnl;

    /**
     * 
     */
    private BigDecimal por;

    /**
     * 
     */
    private BigDecimal rtHrlt;

    /**
     * 
     */
    private BigDecimal rxoHrlt;

    /**
     * 
     */
    private BigDecimal rmHrlt;

    /**
     * 
     */
    private BigDecimal cali;

    /**
     * 
     */
    private BigDecimal tten;

    /**
     * 
     */
    private BigDecimal cnce;

    /**
     * 
     */
    private BigDecimal sw4;

    /**
     * 
     */
    private BigDecimal swdz;

    /**
     * 
     */
    private BigDecimal rla0;

    /**
     * 
     */
    private BigDecimal hdra;

    /**
     * 
     */
    private BigDecimal sw7;

    /**
     * 
     */
    private BigDecimal hdar;

    /**
     * 
     */
    private BigDecimal rxoz;

    /**
     * 
     */
    private BigDecimal acbz;

    /**
     * 
     */
    private BigDecimal cncb;

    /**
     * 
     */
    private BigDecimal denb;

    /**
     * 
     */
    private BigDecimal grc;

    /**
     * 
     */
    private BigDecimal kcs;

    /**
     * 
     */
    private BigDecimal pcf;

    /**
     * 
     */
    private BigDecimal pcs;

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
        WellLasCurveInfo other = (WellLasCurveInfo) that;
        return (this.getCurveInfoId() == null ? other.getCurveInfoId() == null : this.getCurveInfoId().equals(other.getCurveInfoId()))
            && (this.getLasInfoId() == null ? other.getLasInfoId() == null : this.getLasInfoId().equals(other.getLasInfoId()))
            && (this.getDept() == null ? other.getDept() == null : this.getDept().equals(other.getDept()))
            && (this.getAo10() == null ? other.getAo10() == null : this.getAo10().equals(other.getAo10()))
            && (this.getAo20() == null ? other.getAo20() == null : this.getAo20().equals(other.getAo20()))
            && (this.getAo60() == null ? other.getAo60() == null : this.getAo60().equals(other.getAo60()))
            && (this.getAo90() == null ? other.getAo90() == null : this.getAo90().equals(other.getAo90()))
            && (this.getAplc() == null ? other.getAplc() == null : this.getAplc().equals(other.getAplc()))
            && (this.getBs() == null ? other.getBs() == null : this.getBs().equals(other.getBs()))
            && (this.getCals() == null ? other.getCals() == null : this.getCals().equals(other.getCals()))
            && (this.getDt() == null ? other.getDt() == null : this.getDt().equals(other.getDt()))
            && (this.getDts() == null ? other.getDts() == null : this.getDts().equals(other.getDts()))
            && (this.getDt4p() == null ? other.getDt4p() == null : this.getDt4p().equals(other.getDt4p()))
            && (this.getDtc() == null ? other.getDtc() == null : this.getDtc().equals(other.getDtc()))
            && (this.getGr() == null ? other.getGr() == null : this.getGr().equals(other.getGr()))
            && (this.getPefl() == null ? other.getPefl() == null : this.getPefl().equals(other.getPefl()))
            && (this.getRhom() == null ? other.getRhom() == null : this.getRhom().equals(other.getRhom()))
            && (this.getVpvs() == null ? other.getVpvs() == null : this.getVpvs().equals(other.getVpvs()))
            && (this.getSigf() == null ? other.getSigf() == null : this.getSigf().equals(other.getSigf()))
            && (this.getA16h() == null ? other.getA16h() == null : this.getA16h().equals(other.getA16h()))
            && (this.getA22h() == null ? other.getA22h() == null : this.getA22h().equals(other.getA22h()))
            && (this.getA28h() == null ? other.getA28h() == null : this.getA28h().equals(other.getA28h()))
            && (this.getA34h() == null ? other.getA34h() == null : this.getA34h().equals(other.getA34h()))
            && (this.getA40h() == null ? other.getA40h() == null : this.getA40h().equals(other.getA40h()))
            && (this.getCal() == null ? other.getCal() == null : this.getCal().equals(other.getCal()))
            && (this.getCncf() == null ? other.getCncf() == null : this.getCncf().equals(other.getCncf()))
            && (this.getK() == null ? other.getK() == null : this.getK().equals(other.getK()))
            && (this.getKth() == null ? other.getKth() == null : this.getKth().equals(other.getKth()))
            && (this.getM2r1() == null ? other.getM2r1() == null : this.getM2r1().equals(other.getM2r1()))
            && (this.getM2r2() == null ? other.getM2r2() == null : this.getM2r2().equals(other.getM2r2()))
            && (this.getM2r3() == null ? other.getM2r3() == null : this.getM2r3().equals(other.getM2r3()))
            && (this.getM2r6() == null ? other.getM2r6() == null : this.getM2r6().equals(other.getM2r6()))
            && (this.getM2r9() == null ? other.getM2r9() == null : this.getM2r9().equals(other.getM2r9()))
            && (this.getM2rx() == null ? other.getM2rx() == null : this.getM2rx().equals(other.getM2rx()))
            && (this.getPe() == null ? other.getPe() == null : this.getPe().equals(other.getPe()))
            && (this.getRop5Rm() == null ? other.getRop5Rm() == null : this.getRop5Rm().equals(other.getRop5Rm()))
            && (this.getSp() == null ? other.getSp() == null : this.getSp().equals(other.getSp()))
            && (this.getTh() == null ? other.getTh() == null : this.getTh().equals(other.getTh()))
            && (this.getU() == null ? other.getU() == null : this.getU().equals(other.getU()))
            && (this.getZcor() == null ? other.getZcor() == null : this.getZcor().equals(other.getZcor()))
            && (this.getZden() == null ? other.getZden() == null : this.getZden().equals(other.getZden()))
            && (this.getBit() == null ? other.getBit() == null : this.getBit().equals(other.getBit()))
            && (this.getPhit() == null ? other.getPhit() == null : this.getPhit().equals(other.getPhit()))
            && (this.getPign() == null ? other.getPign() == null : this.getPign().equals(other.getPign()))
            && (this.getRhgf() == null ? other.getRhgf() == null : this.getRhgf().equals(other.getRhgf()))
            && (this.getSuwi() == null ? other.getSuwi() == null : this.getSuwi().equals(other.getSuwi()))
            && (this.getSxwi() == null ? other.getSxwi() == null : this.getSxwi().equals(other.getSxwi()))
            && (this.getVcl() == null ? other.getVcl() == null : this.getVcl().equals(other.getVcl()))
            && (this.getSpsbdh() == null ? other.getSpsbdh() == null : this.getSpsbdh().equals(other.getSpsbdh()))
            && (this.getBfv() == null ? other.getBfv() == null : this.getBfv().equals(other.getBfv()))
            && (this.getCmff() == null ? other.getCmff() == null : this.getCmff().equals(other.getCmff()))
            && (this.getDrho() == null ? other.getDrho() == null : this.getDrho().equals(other.getDrho()))
            && (this.getDtco() == null ? other.getDtco() == null : this.getDtco().equals(other.getDtco()))
            && (this.getDtsm() == null ? other.getDtsm() == null : this.getDtsm().equals(other.getDtsm()))
            && (this.getHcal() == null ? other.getHcal() == null : this.getHcal().equals(other.getHcal()))
            && (this.getKsdr() == null ? other.getKsdr() == null : this.getKsdr().equals(other.getKsdr()))
            && (this.getKtim() == null ? other.getKtim() == null : this.getKtim().equals(other.getKtim()))
            && (this.getP16h() == null ? other.getP16h() == null : this.getP16h().equals(other.getP16h()))
            && (this.getP22h() == null ? other.getP22h() == null : this.getP22h().equals(other.getP22h()))
            && (this.getP28h() == null ? other.getP28h() == null : this.getP28h().equals(other.getP28h()))
            && (this.getP34h() == null ? other.getP34h() == null : this.getP34h().equals(other.getP34h()))
            && (this.getP40h() == null ? other.getP40h() == null : this.getP40h().equals(other.getP40h()))
            && (this.getPefz() == null ? other.getPefz() == null : this.getPefz().equals(other.getPefz()))
            && (this.getRhoz() == null ? other.getRhoz() == null : this.getRhoz().equals(other.getRhoz()))
            && (this.getRop5() == null ? other.getRop5() == null : this.getRop5().equals(other.getRop5()))
            && (this.getTcmr() == null ? other.getTcmr() == null : this.getTcmr().equals(other.getTcmr()))
            && (this.getTnph() == null ? other.getTnph() == null : this.getTnph().equals(other.getTnph()))
            && (this.getCmrp3ms() == null ? other.getCmrp3ms() == null : this.getCmrp3ms().equals(other.getCmrp3ms()))
            //&& (this.getGrarc() == null ? other.getGrarc() == null : this.getGrarc().equals(other.getGrarc()))
            && (this.getSwirr() == null ? other.getSwirr() == null : this.getSwirr().equals(other.getSwirr()))
            && (this.getSpdh() == null ? other.getSpdh() == null : this.getSpdh().equals(other.getSpdh()))
            && (this.getDzod() == null ? other.getDzod() == null : this.getDzod().equals(other.getDzod()))
            && (this.getDvod() == null ? other.getDvod() == null : this.getDvod().equals(other.getDvod()))
            && (this.getTen() == null ? other.getTen() == null : this.getTen().equals(other.getTen()))
            && (this.getAc() == null ? other.getAc() == null : this.getAc().equals(other.getAc()))
            && (this.getCnc() == null ? other.getCnc() == null : this.getCnc().equals(other.getCnc()))
            && (this.getDen() == null ? other.getDen() == null : this.getDen().equals(other.getDen()))
            && (this.getRfoc() == null ? other.getRfoc() == null : this.getRfoc().equals(other.getRfoc()))
            && (this.getRild() == null ? other.getRild() == null : this.getRild().equals(other.getRild()))
            && (this.getRilm() == null ? other.getRilm() == null : this.getRilm().equals(other.getRilm()))
            && (this.getCgr() == null ? other.getCgr() == null : this.getCgr().equals(other.getCgr()))
            && (this.getIld() == null ? other.getIld() == null : this.getIld().equals(other.getIld()))
            && (this.getIlm() == null ? other.getIlm() == null : this.getIlm().equals(other.getIlm()))
            && (this.getMsfl() == null ? other.getMsfl() == null : this.getMsfl().equals(other.getMsfl()))
            && (this.getNphi() == null ? other.getNphi() == null : this.getNphi().equals(other.getNphi()))
            && (this.getPef() == null ? other.getPef() == null : this.getPef().equals(other.getPef()))
            && (this.getPota() == null ? other.getPota() == null : this.getPota().equals(other.getPota()))
            && (this.getRhob() == null ? other.getRhob() == null : this.getRhob().equals(other.getRhob()))
            && (this.getThor() == null ? other.getThor() == null : this.getThor().equals(other.getThor()))
            && (this.getUran() == null ? other.getUran() == null : this.getUran().equals(other.getUran()))
            && (this.getSgr() == null ? other.getSgr() == null : this.getSgr().equals(other.getSgr()))
            && (this.getAbgt() == null ? other.getAbgt() == null : this.getAbgt().equals(other.getAbgt()))
            && (this.getAcal() == null ? other.getAcal() == null : this.getAcal().equals(other.getAcal()))
            && (this.getBatc() == null ? other.getBatc() == null : this.getBatc().equals(other.getBatc()))
            && (this.getPore() == null ? other.getPore() == null : this.getPore().equals(other.getPore()))
            && (this.getSbd2() == null ? other.getSbd2() == null : this.getSbd2().equals(other.getSbd2()))
            && (this.getSeda() == null ? other.getSeda() == null : this.getSeda().equals(other.getSeda()))
            && (this.getSedc() == null ? other.getSedc() == null : this.getSedc().equals(other.getSedc()))
            && (this.getSedp() == null ? other.getSedp() == null : this.getSedp().equals(other.getSedp()))
            && (this.getSemc() == null ? other.getSemc() == null : this.getSemc().equals(other.getSemc()))
            && (this.getSemp() == null ? other.getSemp() == null : this.getSemp().equals(other.getSemp()))
            && (this.getSesc() == null ? other.getSesc() == null : this.getSesc().equals(other.getSesc()))
            && (this.getSesp() == null ? other.getSesp() == null : this.getSesp().equals(other.getSesp()))
            && (this.getSexc() == null ? other.getSexc() == null : this.getSexc().equals(other.getSexc()))
            && (this.getSexp() == null ? other.getSexp() == null : this.getSexp().equals(other.getSexp()))
            && (this.getSgrc() == null ? other.getSgrc() == null : this.getSgrc().equals(other.getSgrc()))
            && (this.getSplf() == null ? other.getSplf() == null : this.getSplf().equals(other.getSplf()))
            && (this.getSw() == null ? other.getSw() == null : this.getSw().equals(other.getSw()))
            && (this.getSrop() == null ? other.getSrop() == null : this.getSrop().equals(other.getSrop()))
            && (this.getDtcp() == null ? other.getDtcp() == null : this.getDtcp().equals(other.getDtcp()))
            && (this.getDtsd() == null ? other.getDtsd() == null : this.getDtsd().equals(other.getDtsd()))
            && (this.getDtsp() == null ? other.getDtsp() == null : this.getDtsp().equals(other.getDtsp()))
            && (this.getPort() == null ? other.getPort() == null : this.getPort().equals(other.getPort()))
            && (this.getShsi() == null ? other.getShsi() == null : this.getShsi().equals(other.getShsi()))
            && (this.getTvd() == null ? other.getTvd() == null : this.getTvd().equals(other.getTvd()))
            && (this.getDrhb() == null ? other.getDrhb() == null : this.getDrhb().equals(other.getDrhb()))
            && (this.getDrhl() == null ? other.getDrhl() == null : this.getDrhl().equals(other.getDrhl()))
            && (this.getDrhr() == null ? other.getDrhr() == null : this.getDrhr().equals(other.getDrhr()))
            && (this.getDrhu() == null ? other.getDrhu() == null : this.getDrhu().equals(other.getDrhu()))
            && (this.getRobb() == null ? other.getRobb() == null : this.getRobb().equals(other.getRobb()))
            && (this.getRobl() == null ? other.getRobl() == null : this.getRobl().equals(other.getRobl()))
            && (this.getRobr() == null ? other.getRobr() == null : this.getRobr().equals(other.getRobr()))
            && (this.getRobu() == null ? other.getRobu() == null : this.getRobu().equals(other.getRobu()))
            && (this.getTnpb() == null ? other.getTnpb() == null : this.getTnpb().equals(other.getTnpb()))
            && (this.getTvdRc() == null ? other.getTvdRc() == null : this.getTvdRc().equals(other.getTvdRc()))
            && (this.getGrma() == null ? other.getGrma() == null : this.getGrma().equals(other.getGrma()))
            && (this.getCrpm() == null ? other.getCrpm() == null : this.getCrpm().equals(other.getCrpm()))
            && (this.getDcav() == null ? other.getDcav() == null : this.getDcav().equals(other.getDcav()))
            && (this.getDcho() == null ? other.getDcho() == null : this.getDcho().equals(other.getDcho()))
            && (this.getDcve() == null ? other.getDcve() == null : this.getDcve().equals(other.getDcve()))
            && (this.getP16l() == null ? other.getP16l() == null : this.getP16l().equals(other.getP16l()))
            && (this.getP22l() == null ? other.getP22l() == null : this.getP22l().equals(other.getP22l()))
            && (this.getP28l() == null ? other.getP28l() == null : this.getP28l().equals(other.getP28l()))
            && (this.getP40l() == null ? other.getP40l() == null : this.getP40l().equals(other.getP40l()))
            && (this.getA16l() == null ? other.getA16l() == null : this.getA16l().equals(other.getA16l()))
            && (this.getA22l() == null ? other.getA22l() == null : this.getA22l().equals(other.getA22l()))
            && (this.getA28l() == null ? other.getA28l() == null : this.getA28l().equals(other.getA28l()))
            && (this.getA34l() == null ? other.getA34l() == null : this.getA34l().equals(other.getA34l()))
            && (this.getA40l() == null ? other.getA40l() == null : this.getA40l().equals(other.getA40l()))
            && (this.getPeb() == null ? other.getPeb() == null : this.getPeb().equals(other.getPeb()))
            && (this.getPel() == null ? other.getPel() == null : this.getPel().equals(other.getPel()))
            && (this.getPer() == null ? other.getPer() == null : this.getPer().equals(other.getPer()))
            && (this.getPeu() == null ? other.getPeu() == null : this.getPeu().equals(other.getPeu()))
            && (this.getSifa() == null ? other.getSifa() == null : this.getSifa().equals(other.getSifa()))
            && (this.getTabArcRes() == null ? other.getTabArcRes() == null : this.getTabArcRes().equals(other.getTabArcRes()))
            && (this.getTabDen() == null ? other.getTabDen() == null : this.getTabDen().equals(other.getTabDen()))
            && (this.getTabGr() == null ? other.getTabGr() == null : this.getTabGr().equals(other.getTabGr()))
            && (this.getTabNeu() == null ? other.getTabNeu() == null : this.getTabNeu().equals(other.getTabNeu()))
            && (this.getSbdc() == null ? other.getSbdc() == null : this.getSbdc().equals(other.getSbdc()))
            && (this.getSco2() == null ? other.getSco2() == null : this.getSco2().equals(other.getSco2()))
            && (this.getScor() == null ? other.getScor() == null : this.getScor().equals(other.getScor()))
            && (this.getSdde() == null ? other.getSdde() == null : this.getSdde().equals(other.getSdde()))
            && (this.getSfb2() == null ? other.getSfb2() == null : this.getSfb2().equals(other.getSfb2()))
            && (this.getSgra() == null ? other.getSgra() == null : this.getSgra().equals(other.getSgra()))
            && (this.getSgrb() == null ? other.getSgrb() == null : this.getSgrb().equals(other.getSgrb()))
            && (this.getSnb2() == null ? other.getSnb2() == null : this.getSnb2().equals(other.getSnb2()))
            && (this.getSnfa() == null ? other.getSnfa() == null : this.getSnfa().equals(other.getSnfa()))
            && (this.getSnna() == null ? other.getSnna() == null : this.getSnna().equals(other.getSnna()))
            && (this.getSnp2() == null ? other.getSnp2() == null : this.getSnp2().equals(other.getSnp2()))
            && (this.getSnpe() == null ? other.getSnpe() == null : this.getSnpe().equals(other.getSnpe()))
            && (this.getStem() == null ? other.getStem() == null : this.getStem().equals(other.getStem()))
            && (this.getCalp() == null ? other.getCalp() == null : this.getCalp().equals(other.getCalp()))
            && (this.getDtcr() == null ? other.getDtcr() == null : this.getDtcr().equals(other.getDtcr()))
            && (this.getDtdr() == null ? other.getDtdr() == null : this.getDtdr().equals(other.getDtdr()))
            && (this.getDtpc() == null ? other.getDtpc() == null : this.getDtpc().equals(other.getDtpc()))
            && (this.getGrpcl() == null ? other.getGrpcl() == null : this.getGrpcl().equals(other.getGrpcl()))
            && (this.getPoredt() == null ? other.getPoredt() == null : this.getPoredt().equals(other.getPoredt()))
            && (this.getAtmp() == null ? other.getAtmp() == null : this.getAtmp().equals(other.getAtmp()))
            && (this.getHord() == null ? other.getHord() == null : this.getHord().equals(other.getHord()))
            && (this.getVerd() == null ? other.getVerd() == null : this.getVerd().equals(other.getVerd()))
            && (this.getVw() == null ? other.getVw() == null : this.getVw().equals(other.getVw()))
            && (this.getVxo() == null ? other.getVxo() == null : this.getVxo().equals(other.getVxo()))
            && (this.getGrbz() == null ? other.getGrbz() == null : this.getGrbz().equals(other.getGrbz()))
            && (this.getSdea() == null ? other.getSdea() == null : this.getSdea().equals(other.getSdea()))
            && (this.getAbga() == null ? other.getAbga() == null : this.getAbga().equals(other.getAbga()))
            && (this.getAbgb() == null ? other.getAbgb() == null : this.getAbgb().equals(other.getAbgb()))
            && (this.getAbgc() == null ? other.getAbgc() == null : this.getAbgc().equals(other.getAbgc()))
            && (this.getTvde() == null ? other.getTvde() == null : this.getTvde().equals(other.getTvde()))
            && (this.getGrArc() == null ? other.getGrArc() == null : this.getGrArc().equals(other.getGrArc()))
            && (this.getPdGravBhc() == null ? other.getPdGravBhc() == null : this.getPdGravBhc().equals(other.getPdGravBhc()))
            && (this.getP34l() == null ? other.getP34l() == null : this.getP34l().equals(other.getP34l()))
            && (this.getTabArc() == null ? other.getTabArc() == null : this.getTabArc().equals(other.getTabArc()))
            && (this.getRpmAdn() == null ? other.getRpmAdn() == null : this.getRpmAdn().equals(other.getRpmAdn()))
            && (this.getAco() == null ? other.getAco() == null : this.getAco().equals(other.getAco()))
            && (this.getAcq() == null ? other.getAcq() == null : this.getAcq().equals(other.getAcq()))
            && (this.getCht() == null ? other.getCht() == null : this.getCht().equals(other.getCht()))
            && (this.getCn() == null ? other.getCn() == null : this.getCn().equals(other.getCn()))
            && (this.getCnlo() == null ? other.getCnlo() == null : this.getCnlo().equals(other.getCnlo()))
            && (this.getCorr() == null ? other.getCorr() == null : this.getCorr().equals(other.getCorr()))
            && (this.getDeno() == null ? other.getDeno() == null : this.getDeno().equals(other.getDeno()))
            && (this.getLsd() == null ? other.getLsd() == null : this.getLsd().equals(other.getLsd()))
            && (this.getLsn() == null ? other.getLsn() == null : this.getLsn().equals(other.getLsn()))
            && (this.getPerm() == null ? other.getPerm() == null : this.getPerm().equals(other.getPerm()))
            && (this.getRto() == null ? other.getRto() == null : this.getRto().equals(other.getRto()))
            && (this.getSsd() == null ? other.getSsd() == null : this.getSsd().equals(other.getSsd()))
            && (this.getSsn() == null ? other.getSsn() == null : this.getSsn().equals(other.getSsn()))
            && (this.getSwb() == null ? other.getSwb() == null : this.getSwb().equals(other.getSwb()))
            && (this.getDgr() == null ? other.getDgr() == null : this.getDgr().equals(other.getDgr()))
            && (this.getNucp() == null ? other.getNucp() == null : this.getNucp().equals(other.getNucp()))
            && (this.getSfxe() == null ? other.getSfxe() == null : this.getSfxe().equals(other.getSfxe()))
            && (this.getGre() == null ? other.getGre() == null : this.getGre().equals(other.getGre()))
            && (this.getAppc() == null ? other.getAppc() == null : this.getAppc().equals(other.getAppc()))
            && (this.getRop() == null ? other.getRop() == null : this.getRop().equals(other.getRop()))
            && (this.getSema() == null ? other.getSema() == null : this.getSema().equals(other.getSema()))
            && (this.getSesa() == null ? other.getSesa() == null : this.getSesa().equals(other.getSesa()))
            && (this.getSexa() == null ? other.getSexa() == null : this.getSexa().equals(other.getSexa()))
            && (this.getWrm() == null ? other.getWrm() == null : this.getWrm().equals(other.getWrm()))
            && (this.getScrd() == null ? other.getScrd() == null : this.getScrd().equals(other.getScrd()))
            && (this.getHtem() == null ? other.getHtem() == null : this.getHtem().equals(other.getHtem()))
            && (this.getRxo() == null ? other.getRxo() == null : this.getRxo().equals(other.getRxo()))
            && (this.getRt() == null ? other.getRt() == null : this.getRt().equals(other.getRt()))
            && (this.getRm() == null ? other.getRm() == null : this.getRm().equals(other.getRm()))
            && (this.getRla5() == null ? other.getRla5() == null : this.getRla5().equals(other.getRla5()))
            && (this.getRla4() == null ? other.getRla4() == null : this.getRla4().equals(other.getRla4()))
            && (this.getRla3() == null ? other.getRla3() == null : this.getRla3().equals(other.getRla3()))
            && (this.getRla2() == null ? other.getRla2() == null : this.getRla2().equals(other.getRla2()))
            && (this.getRla1() == null ? other.getRla1() == null : this.getRla1().equals(other.getRla1()))
            && (this.getPr() == null ? other.getPr() == null : this.getPr().equals(other.getPr()))
            && (this.getDt1() == null ? other.getDt1() == null : this.getDt1().equals(other.getDt1()))
            && (this.getCnl() == null ? other.getCnl() == null : this.getCnl().equals(other.getCnl()))
            && (this.getPor() == null ? other.getPor() == null : this.getPor().equals(other.getPor()))
            && (this.getRtHrlt() == null ? other.getRtHrlt() == null : this.getRtHrlt().equals(other.getRtHrlt()))
            && (this.getRxoHrlt() == null ? other.getRxoHrlt() == null : this.getRxoHrlt().equals(other.getRxoHrlt()))
            && (this.getRmHrlt() == null ? other.getRmHrlt() == null : this.getRmHrlt().equals(other.getRmHrlt()))
            && (this.getCali() == null ? other.getCali() == null : this.getCali().equals(other.getCali()))
            && (this.getTten() == null ? other.getTten() == null : this.getTten().equals(other.getTten()))
            && (this.getCnce() == null ? other.getCnce() == null : this.getCnce().equals(other.getCnce()))
            && (this.getSw4() == null ? other.getSw4() == null : this.getSw4().equals(other.getSw4()))
            && (this.getSwdz() == null ? other.getSwdz() == null : this.getSwdz().equals(other.getSwdz()))
            && (this.getRla0() == null ? other.getRla0() == null : this.getRla0().equals(other.getRla0()))
            && (this.getHdra() == null ? other.getHdra() == null : this.getHdra().equals(other.getHdra()))
            && (this.getSw7() == null ? other.getSw7() == null : this.getSw7().equals(other.getSw7()))
            && (this.getHdar() == null ? other.getHdar() == null : this.getHdar().equals(other.getHdar()))
            && (this.getRxoz() == null ? other.getRxoz() == null : this.getRxoz().equals(other.getRxoz()))
            && (this.getAcbz() == null ? other.getAcbz() == null : this.getAcbz().equals(other.getAcbz()))
            && (this.getCncb() == null ? other.getCncb() == null : this.getCncb().equals(other.getCncb()))
            && (this.getDenb() == null ? other.getDenb() == null : this.getDenb().equals(other.getDenb()))
            && (this.getGrc() == null ? other.getGrc() == null : this.getGrc().equals(other.getGrc()))
            && (this.getKcs() == null ? other.getKcs() == null : this.getKcs().equals(other.getKcs()))
            && (this.getPcf() == null ? other.getPcf() == null : this.getPcf().equals(other.getPcf()))
            && (this.getPcs() == null ? other.getPcs() == null : this.getPcs().equals(other.getPcs()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCurveInfoId() == null) ? 0 : getCurveInfoId().hashCode());
        result = prime * result + ((getLasInfoId() == null) ? 0 : getLasInfoId().hashCode());
        result = prime * result + ((getDept() == null) ? 0 : getDept().hashCode());
        result = prime * result + ((getAo10() == null) ? 0 : getAo10().hashCode());
        result = prime * result + ((getAo20() == null) ? 0 : getAo20().hashCode());
        result = prime * result + ((getAo60() == null) ? 0 : getAo60().hashCode());
        result = prime * result + ((getAo90() == null) ? 0 : getAo90().hashCode());
        result = prime * result + ((getAplc() == null) ? 0 : getAplc().hashCode());
        result = prime * result + ((getBs() == null) ? 0 : getBs().hashCode());
        result = prime * result + ((getCals() == null) ? 0 : getCals().hashCode());
        result = prime * result + ((getDt() == null) ? 0 : getDt().hashCode());
        result = prime * result + ((getDts() == null) ? 0 : getDts().hashCode());
        result = prime * result + ((getDt4p() == null) ? 0 : getDt4p().hashCode());
        result = prime * result + ((getDtc() == null) ? 0 : getDtc().hashCode());
        result = prime * result + ((getGr() == null) ? 0 : getGr().hashCode());
        result = prime * result + ((getPefl() == null) ? 0 : getPefl().hashCode());
        result = prime * result + ((getRhom() == null) ? 0 : getRhom().hashCode());
        result = prime * result + ((getVpvs() == null) ? 0 : getVpvs().hashCode());
        result = prime * result + ((getSigf() == null) ? 0 : getSigf().hashCode());
        result = prime * result + ((getA16h() == null) ? 0 : getA16h().hashCode());
        result = prime * result + ((getA22h() == null) ? 0 : getA22h().hashCode());
        result = prime * result + ((getA28h() == null) ? 0 : getA28h().hashCode());
        result = prime * result + ((getA34h() == null) ? 0 : getA34h().hashCode());
        result = prime * result + ((getA40h() == null) ? 0 : getA40h().hashCode());
        result = prime * result + ((getCal() == null) ? 0 : getCal().hashCode());
        result = prime * result + ((getCncf() == null) ? 0 : getCncf().hashCode());
        result = prime * result + ((getK() == null) ? 0 : getK().hashCode());
        result = prime * result + ((getKth() == null) ? 0 : getKth().hashCode());
        result = prime * result + ((getM2r1() == null) ? 0 : getM2r1().hashCode());
        result = prime * result + ((getM2r2() == null) ? 0 : getM2r2().hashCode());
        result = prime * result + ((getM2r3() == null) ? 0 : getM2r3().hashCode());
        result = prime * result + ((getM2r6() == null) ? 0 : getM2r6().hashCode());
        result = prime * result + ((getM2r9() == null) ? 0 : getM2r9().hashCode());
        result = prime * result + ((getM2rx() == null) ? 0 : getM2rx().hashCode());
        result = prime * result + ((getPe() == null) ? 0 : getPe().hashCode());
        result = prime * result + ((getRop5Rm() == null) ? 0 : getRop5Rm().hashCode());
        result = prime * result + ((getSp() == null) ? 0 : getSp().hashCode());
        result = prime * result + ((getTh() == null) ? 0 : getTh().hashCode());
        result = prime * result + ((getU() == null) ? 0 : getU().hashCode());
        result = prime * result + ((getZcor() == null) ? 0 : getZcor().hashCode());
        result = prime * result + ((getZden() == null) ? 0 : getZden().hashCode());
        result = prime * result + ((getBit() == null) ? 0 : getBit().hashCode());
        result = prime * result + ((getPhit() == null) ? 0 : getPhit().hashCode());
        result = prime * result + ((getPign() == null) ? 0 : getPign().hashCode());
        result = prime * result + ((getRhgf() == null) ? 0 : getRhgf().hashCode());
        result = prime * result + ((getSuwi() == null) ? 0 : getSuwi().hashCode());
        result = prime * result + ((getSxwi() == null) ? 0 : getSxwi().hashCode());
        result = prime * result + ((getVcl() == null) ? 0 : getVcl().hashCode());
        result = prime * result + ((getSpsbdh() == null) ? 0 : getSpsbdh().hashCode());
        result = prime * result + ((getBfv() == null) ? 0 : getBfv().hashCode());
        result = prime * result + ((getCmff() == null) ? 0 : getCmff().hashCode());
        result = prime * result + ((getDrho() == null) ? 0 : getDrho().hashCode());
        result = prime * result + ((getDtco() == null) ? 0 : getDtco().hashCode());
        result = prime * result + ((getDtsm() == null) ? 0 : getDtsm().hashCode());
        result = prime * result + ((getHcal() == null) ? 0 : getHcal().hashCode());
        result = prime * result + ((getKsdr() == null) ? 0 : getKsdr().hashCode());
        result = prime * result + ((getKtim() == null) ? 0 : getKtim().hashCode());
        result = prime * result + ((getP16h() == null) ? 0 : getP16h().hashCode());
        result = prime * result + ((getP22h() == null) ? 0 : getP22h().hashCode());
        result = prime * result + ((getP28h() == null) ? 0 : getP28h().hashCode());
        result = prime * result + ((getP34h() == null) ? 0 : getP34h().hashCode());
        result = prime * result + ((getP40h() == null) ? 0 : getP40h().hashCode());
        result = prime * result + ((getPefz() == null) ? 0 : getPefz().hashCode());
        result = prime * result + ((getRhoz() == null) ? 0 : getRhoz().hashCode());
        result = prime * result + ((getRop5() == null) ? 0 : getRop5().hashCode());
        result = prime * result + ((getTcmr() == null) ? 0 : getTcmr().hashCode());
        result = prime * result + ((getTnph() == null) ? 0 : getTnph().hashCode());
        result = prime * result + ((getCmrp3ms() == null) ? 0 : getCmrp3ms().hashCode());
        //result = prime * result + ((getGrarc() == null) ? 0 : getGrarc().hashCode());
        result = prime * result + ((getSwirr() == null) ? 0 : getSwirr().hashCode());
        result = prime * result + ((getSpdh() == null) ? 0 : getSpdh().hashCode());
        result = prime * result + ((getDzod() == null) ? 0 : getDzod().hashCode());
        result = prime * result + ((getDvod() == null) ? 0 : getDvod().hashCode());
        result = prime * result + ((getTen() == null) ? 0 : getTen().hashCode());
        result = prime * result + ((getAc() == null) ? 0 : getAc().hashCode());
        result = prime * result + ((getCnc() == null) ? 0 : getCnc().hashCode());
        result = prime * result + ((getDen() == null) ? 0 : getDen().hashCode());
        result = prime * result + ((getRfoc() == null) ? 0 : getRfoc().hashCode());
        result = prime * result + ((getRild() == null) ? 0 : getRild().hashCode());
        result = prime * result + ((getRilm() == null) ? 0 : getRilm().hashCode());
        result = prime * result + ((getCgr() == null) ? 0 : getCgr().hashCode());
        result = prime * result + ((getIld() == null) ? 0 : getIld().hashCode());
        result = prime * result + ((getIlm() == null) ? 0 : getIlm().hashCode());
        result = prime * result + ((getMsfl() == null) ? 0 : getMsfl().hashCode());
        result = prime * result + ((getNphi() == null) ? 0 : getNphi().hashCode());
        result = prime * result + ((getPef() == null) ? 0 : getPef().hashCode());
        result = prime * result + ((getPota() == null) ? 0 : getPota().hashCode());
        result = prime * result + ((getRhob() == null) ? 0 : getRhob().hashCode());
        result = prime * result + ((getThor() == null) ? 0 : getThor().hashCode());
        result = prime * result + ((getUran() == null) ? 0 : getUran().hashCode());
        result = prime * result + ((getSgr() == null) ? 0 : getSgr().hashCode());
        result = prime * result + ((getAbgt() == null) ? 0 : getAbgt().hashCode());
        result = prime * result + ((getAcal() == null) ? 0 : getAcal().hashCode());
        result = prime * result + ((getBatc() == null) ? 0 : getBatc().hashCode());
        result = prime * result + ((getPore() == null) ? 0 : getPore().hashCode());
        result = prime * result + ((getSbd2() == null) ? 0 : getSbd2().hashCode());
        result = prime * result + ((getSeda() == null) ? 0 : getSeda().hashCode());
        result = prime * result + ((getSedc() == null) ? 0 : getSedc().hashCode());
        result = prime * result + ((getSedp() == null) ? 0 : getSedp().hashCode());
        result = prime * result + ((getSemc() == null) ? 0 : getSemc().hashCode());
        result = prime * result + ((getSemp() == null) ? 0 : getSemp().hashCode());
        result = prime * result + ((getSesc() == null) ? 0 : getSesc().hashCode());
        result = prime * result + ((getSesp() == null) ? 0 : getSesp().hashCode());
        result = prime * result + ((getSexc() == null) ? 0 : getSexc().hashCode());
        result = prime * result + ((getSexp() == null) ? 0 : getSexp().hashCode());
        result = prime * result + ((getSgrc() == null) ? 0 : getSgrc().hashCode());
        result = prime * result + ((getSplf() == null) ? 0 : getSplf().hashCode());
        result = prime * result + ((getSw() == null) ? 0 : getSw().hashCode());
        result = prime * result + ((getSrop() == null) ? 0 : getSrop().hashCode());
        result = prime * result + ((getDtcp() == null) ? 0 : getDtcp().hashCode());
        result = prime * result + ((getDtsd() == null) ? 0 : getDtsd().hashCode());
        result = prime * result + ((getDtsp() == null) ? 0 : getDtsp().hashCode());
        result = prime * result + ((getPort() == null) ? 0 : getPort().hashCode());
        result = prime * result + ((getShsi() == null) ? 0 : getShsi().hashCode());
        result = prime * result + ((getTvd() == null) ? 0 : getTvd().hashCode());
        result = prime * result + ((getDrhb() == null) ? 0 : getDrhb().hashCode());
        result = prime * result + ((getDrhl() == null) ? 0 : getDrhl().hashCode());
        result = prime * result + ((getDrhr() == null) ? 0 : getDrhr().hashCode());
        result = prime * result + ((getDrhu() == null) ? 0 : getDrhu().hashCode());
        result = prime * result + ((getRobb() == null) ? 0 : getRobb().hashCode());
        result = prime * result + ((getRobl() == null) ? 0 : getRobl().hashCode());
        result = prime * result + ((getRobr() == null) ? 0 : getRobr().hashCode());
        result = prime * result + ((getRobu() == null) ? 0 : getRobu().hashCode());
        result = prime * result + ((getTnpb() == null) ? 0 : getTnpb().hashCode());
        result = prime * result + ((getTvdRc() == null) ? 0 : getTvdRc().hashCode());
        result = prime * result + ((getGrma() == null) ? 0 : getGrma().hashCode());
        result = prime * result + ((getCrpm() == null) ? 0 : getCrpm().hashCode());
        result = prime * result + ((getDcav() == null) ? 0 : getDcav().hashCode());
        result = prime * result + ((getDcho() == null) ? 0 : getDcho().hashCode());
        result = prime * result + ((getDcve() == null) ? 0 : getDcve().hashCode());
        result = prime * result + ((getP16l() == null) ? 0 : getP16l().hashCode());
        result = prime * result + ((getP22l() == null) ? 0 : getP22l().hashCode());
        result = prime * result + ((getP28l() == null) ? 0 : getP28l().hashCode());
        result = prime * result + ((getP40l() == null) ? 0 : getP40l().hashCode());
        result = prime * result + ((getA16l() == null) ? 0 : getA16l().hashCode());
        result = prime * result + ((getA22l() == null) ? 0 : getA22l().hashCode());
        result = prime * result + ((getA28l() == null) ? 0 : getA28l().hashCode());
        result = prime * result + ((getA34l() == null) ? 0 : getA34l().hashCode());
        result = prime * result + ((getA40l() == null) ? 0 : getA40l().hashCode());
        result = prime * result + ((getPeb() == null) ? 0 : getPeb().hashCode());
        result = prime * result + ((getPel() == null) ? 0 : getPel().hashCode());
        result = prime * result + ((getPer() == null) ? 0 : getPer().hashCode());
        result = prime * result + ((getPeu() == null) ? 0 : getPeu().hashCode());
        result = prime * result + ((getSifa() == null) ? 0 : getSifa().hashCode());
        result = prime * result + ((getTabArcRes() == null) ? 0 : getTabArcRes().hashCode());
        result = prime * result + ((getTabDen() == null) ? 0 : getTabDen().hashCode());
        result = prime * result + ((getTabGr() == null) ? 0 : getTabGr().hashCode());
        result = prime * result + ((getTabNeu() == null) ? 0 : getTabNeu().hashCode());
        result = prime * result + ((getSbdc() == null) ? 0 : getSbdc().hashCode());
        result = prime * result + ((getSco2() == null) ? 0 : getSco2().hashCode());
        result = prime * result + ((getScor() == null) ? 0 : getScor().hashCode());
        result = prime * result + ((getSdde() == null) ? 0 : getSdde().hashCode());
        result = prime * result + ((getSfb2() == null) ? 0 : getSfb2().hashCode());
        result = prime * result + ((getSgra() == null) ? 0 : getSgra().hashCode());
        result = prime * result + ((getSgrb() == null) ? 0 : getSgrb().hashCode());
        result = prime * result + ((getSnb2() == null) ? 0 : getSnb2().hashCode());
        result = prime * result + ((getSnfa() == null) ? 0 : getSnfa().hashCode());
        result = prime * result + ((getSnna() == null) ? 0 : getSnna().hashCode());
        result = prime * result + ((getSnp2() == null) ? 0 : getSnp2().hashCode());
        result = prime * result + ((getSnpe() == null) ? 0 : getSnpe().hashCode());
        result = prime * result + ((getStem() == null) ? 0 : getStem().hashCode());
        result = prime * result + ((getCalp() == null) ? 0 : getCalp().hashCode());
        result = prime * result + ((getDtcr() == null) ? 0 : getDtcr().hashCode());
        result = prime * result + ((getDtdr() == null) ? 0 : getDtdr().hashCode());
        result = prime * result + ((getDtpc() == null) ? 0 : getDtpc().hashCode());
        result = prime * result + ((getGrpcl() == null) ? 0 : getGrpcl().hashCode());
        result = prime * result + ((getPoredt() == null) ? 0 : getPoredt().hashCode());
        result = prime * result + ((getAtmp() == null) ? 0 : getAtmp().hashCode());
        result = prime * result + ((getHord() == null) ? 0 : getHord().hashCode());
        result = prime * result + ((getVerd() == null) ? 0 : getVerd().hashCode());
        result = prime * result + ((getVw() == null) ? 0 : getVw().hashCode());
        result = prime * result + ((getVxo() == null) ? 0 : getVxo().hashCode());
        result = prime * result + ((getGrbz() == null) ? 0 : getGrbz().hashCode());
        result = prime * result + ((getSdea() == null) ? 0 : getSdea().hashCode());
        result = prime * result + ((getAbga() == null) ? 0 : getAbga().hashCode());
        result = prime * result + ((getAbgb() == null) ? 0 : getAbgb().hashCode());
        result = prime * result + ((getAbgc() == null) ? 0 : getAbgc().hashCode());
        result = prime * result + ((getTvde() == null) ? 0 : getTvde().hashCode());
        result = prime * result + ((getGrArc() == null) ? 0 : getGrArc().hashCode());
        result = prime * result + ((getPdGravBhc() == null) ? 0 : getPdGravBhc().hashCode());
        result = prime * result + ((getP34l() == null) ? 0 : getP34l().hashCode());
        result = prime * result + ((getTabArc() == null) ? 0 : getTabArc().hashCode());
        result = prime * result + ((getRpmAdn() == null) ? 0 : getRpmAdn().hashCode());
        result = prime * result + ((getAco() == null) ? 0 : getAco().hashCode());
        result = prime * result + ((getAcq() == null) ? 0 : getAcq().hashCode());
        result = prime * result + ((getCht() == null) ? 0 : getCht().hashCode());
        result = prime * result + ((getCn() == null) ? 0 : getCn().hashCode());
        result = prime * result + ((getCnlo() == null) ? 0 : getCnlo().hashCode());
        result = prime * result + ((getCorr() == null) ? 0 : getCorr().hashCode());
        result = prime * result + ((getDeno() == null) ? 0 : getDeno().hashCode());
        result = prime * result + ((getLsd() == null) ? 0 : getLsd().hashCode());
        result = prime * result + ((getLsn() == null) ? 0 : getLsn().hashCode());
        result = prime * result + ((getPerm() == null) ? 0 : getPerm().hashCode());
        result = prime * result + ((getRto() == null) ? 0 : getRto().hashCode());
        result = prime * result + ((getSsd() == null) ? 0 : getSsd().hashCode());
        result = prime * result + ((getSsn() == null) ? 0 : getSsn().hashCode());
        result = prime * result + ((getSwb() == null) ? 0 : getSwb().hashCode());
        result = prime * result + ((getDgr() == null) ? 0 : getDgr().hashCode());
        result = prime * result + ((getNucp() == null) ? 0 : getNucp().hashCode());
        result = prime * result + ((getSfxe() == null) ? 0 : getSfxe().hashCode());
        result = prime * result + ((getGre() == null) ? 0 : getGre().hashCode());
        result = prime * result + ((getAppc() == null) ? 0 : getAppc().hashCode());
        result = prime * result + ((getRop() == null) ? 0 : getRop().hashCode());
        result = prime * result + ((getSema() == null) ? 0 : getSema().hashCode());
        result = prime * result + ((getSesa() == null) ? 0 : getSesa().hashCode());
        result = prime * result + ((getSexa() == null) ? 0 : getSexa().hashCode());
        result = prime * result + ((getWrm() == null) ? 0 : getWrm().hashCode());
        result = prime * result + ((getScrd() == null) ? 0 : getScrd().hashCode());
        result = prime * result + ((getHtem() == null) ? 0 : getHtem().hashCode());
        result = prime * result + ((getRxo() == null) ? 0 : getRxo().hashCode());
        result = prime * result + ((getRt() == null) ? 0 : getRt().hashCode());
        result = prime * result + ((getRm() == null) ? 0 : getRm().hashCode());
        result = prime * result + ((getRla5() == null) ? 0 : getRla5().hashCode());
        result = prime * result + ((getRla4() == null) ? 0 : getRla4().hashCode());
        result = prime * result + ((getRla3() == null) ? 0 : getRla3().hashCode());
        result = prime * result + ((getRla2() == null) ? 0 : getRla2().hashCode());
        result = prime * result + ((getRla1() == null) ? 0 : getRla1().hashCode());
        result = prime * result + ((getPr() == null) ? 0 : getPr().hashCode());
        result = prime * result + ((getDt1() == null) ? 0 : getDt1().hashCode());
        result = prime * result + ((getCnl() == null) ? 0 : getCnl().hashCode());
        result = prime * result + ((getPor() == null) ? 0 : getPor().hashCode());
        result = prime * result + ((getRtHrlt() == null) ? 0 : getRtHrlt().hashCode());
        result = prime * result + ((getRxoHrlt() == null) ? 0 : getRxoHrlt().hashCode());
        result = prime * result + ((getRmHrlt() == null) ? 0 : getRmHrlt().hashCode());
        result = prime * result + ((getCali() == null) ? 0 : getCali().hashCode());
        result = prime * result + ((getTten() == null) ? 0 : getTten().hashCode());
        result = prime * result + ((getCnce() == null) ? 0 : getCnce().hashCode());
        result = prime * result + ((getSw4() == null) ? 0 : getSw4().hashCode());
        result = prime * result + ((getSwdz() == null) ? 0 : getSwdz().hashCode());
        result = prime * result + ((getRla0() == null) ? 0 : getRla0().hashCode());
        result = prime * result + ((getHdra() == null) ? 0 : getHdra().hashCode());
        result = prime * result + ((getSw7() == null) ? 0 : getSw7().hashCode());
        result = prime * result + ((getHdar() == null) ? 0 : getHdar().hashCode());
        result = prime * result + ((getRxoz() == null) ? 0 : getRxoz().hashCode());
        result = prime * result + ((getAcbz() == null) ? 0 : getAcbz().hashCode());
        result = prime * result + ((getCncb() == null) ? 0 : getCncb().hashCode());
        result = prime * result + ((getDenb() == null) ? 0 : getDenb().hashCode());
        result = prime * result + ((getGrc() == null) ? 0 : getGrc().hashCode());
        result = prime * result + ((getKcs() == null) ? 0 : getKcs().hashCode());
        result = prime * result + ((getPcf() == null) ? 0 : getPcf().hashCode());
        result = prime * result + ((getPcs() == null) ? 0 : getPcs().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", curveInfoId=").append(curveInfoId);
        sb.append(", lasInfoId=").append(lasInfoId);
        sb.append(", dept=").append(dept);
        sb.append(", ao10=").append(ao10);
        sb.append(", ao20=").append(ao20);
        sb.append(", ao60=").append(ao60);
        sb.append(", ao90=").append(ao90);
        sb.append(", aplc=").append(aplc);
        sb.append(", bs=").append(bs);
        sb.append(", cals=").append(cals);
        sb.append(", dt=").append(dt);
        sb.append(", dts=").append(dts);
        sb.append(", dt4p=").append(dt4p);
        sb.append(", dtc=").append(dtc);
        sb.append(", gr=").append(gr);
        sb.append(", pefl=").append(pefl);
        sb.append(", rhom=").append(rhom);
        sb.append(", vpvs=").append(vpvs);
        sb.append(", sigf=").append(sigf);
        sb.append(", a16h=").append(a16h);
        sb.append(", a22h=").append(a22h);
        sb.append(", a28h=").append(a28h);
        sb.append(", a34h=").append(a34h);
        sb.append(", a40h=").append(a40h);
        sb.append(", cal=").append(cal);
        sb.append(", cncf=").append(cncf);
        sb.append(", k=").append(k);
        sb.append(", kth=").append(kth);
        sb.append(", m2r1=").append(m2r1);
        sb.append(", m2r2=").append(m2r2);
        sb.append(", m2r3=").append(m2r3);
        sb.append(", m2r6=").append(m2r6);
        sb.append(", m2r9=").append(m2r9);
        sb.append(", m2rx=").append(m2rx);
        sb.append(", pe=").append(pe);
        sb.append(", rop5Rm=").append(rop5Rm);
        sb.append(", sp=").append(sp);
        sb.append(", th=").append(th);
        sb.append(", u=").append(u);
        sb.append(", zcor=").append(zcor);
        sb.append(", zden=").append(zden);
        sb.append(", bit=").append(bit);
        sb.append(", phit=").append(phit);
        sb.append(", pign=").append(pign);
        sb.append(", rhgf=").append(rhgf);
        sb.append(", suwi=").append(suwi);
        sb.append(", sxwi=").append(sxwi);
        sb.append(", vcl=").append(vcl);
        sb.append(", spsbdh=").append(spsbdh);
        sb.append(", bfv=").append(bfv);
        sb.append(", cmff=").append(cmff);
        sb.append(", drho=").append(drho);
        sb.append(", dtco=").append(dtco);
        sb.append(", dtsm=").append(dtsm);
        sb.append(", hcal=").append(hcal);
        sb.append(", ksdr=").append(ksdr);
        sb.append(", ktim=").append(ktim);
        sb.append(", p16h=").append(p16h);
        sb.append(", p22h=").append(p22h);
        sb.append(", p28h=").append(p28h);
        sb.append(", p34h=").append(p34h);
        sb.append(", p40h=").append(p40h);
        sb.append(", pefz=").append(pefz);
        sb.append(", rhoz=").append(rhoz);
        sb.append(", rop5=").append(rop5);
        sb.append(", tcmr=").append(tcmr);
        sb.append(", tnph=").append(tnph);
        sb.append(", cmrp3ms=").append(cmrp3ms);
        //sb.append(", grarc=").append(grarc);
        sb.append(", swirr=").append(swirr);
        sb.append(", spdh=").append(spdh);
        sb.append(", dzod=").append(dzod);
        sb.append(", dvod=").append(dvod);
        sb.append(", ten=").append(ten);
        sb.append(", ac=").append(ac);
        sb.append(", cnc=").append(cnc);
        sb.append(", den=").append(den);
        sb.append(", rfoc=").append(rfoc);
        sb.append(", rild=").append(rild);
        sb.append(", rilm=").append(rilm);
        sb.append(", cgr=").append(cgr);
        sb.append(", ild=").append(ild);
        sb.append(", ilm=").append(ilm);
        sb.append(", msfl=").append(msfl);
        sb.append(", nphi=").append(nphi);
        sb.append(", pef=").append(pef);
        sb.append(", pota=").append(pota);
        sb.append(", rhob=").append(rhob);
        sb.append(", thor=").append(thor);
        sb.append(", uran=").append(uran);
        sb.append(", sgr=").append(sgr);
        sb.append(", abgt=").append(abgt);
        sb.append(", acal=").append(acal);
        sb.append(", batc=").append(batc);
        sb.append(", pore=").append(pore);
        sb.append(", sbd2=").append(sbd2);
        sb.append(", seda=").append(seda);
        sb.append(", sedc=").append(sedc);
        sb.append(", sedp=").append(sedp);
        sb.append(", semc=").append(semc);
        sb.append(", semp=").append(semp);
        sb.append(", sesc=").append(sesc);
        sb.append(", sesp=").append(sesp);
        sb.append(", sexc=").append(sexc);
        sb.append(", sexp=").append(sexp);
        sb.append(", sgrc=").append(sgrc);
        sb.append(", splf=").append(splf);
        sb.append(", sw=").append(sw);
        sb.append(", srop=").append(srop);
        sb.append(", dtcp=").append(dtcp);
        sb.append(", dtsd=").append(dtsd);
        sb.append(", dtsp=").append(dtsp);
        sb.append(", port=").append(port);
        sb.append(", shsi=").append(shsi);
        sb.append(", tvd=").append(tvd);
        sb.append(", drhb=").append(drhb);
        sb.append(", drhl=").append(drhl);
        sb.append(", drhr=").append(drhr);
        sb.append(", drhu=").append(drhu);
        sb.append(", robb=").append(robb);
        sb.append(", robl=").append(robl);
        sb.append(", robr=").append(robr);
        sb.append(", robu=").append(robu);
        sb.append(", tnpb=").append(tnpb);
        sb.append(", tvdRc=").append(tvdRc);
        sb.append(", grma=").append(grma);
        sb.append(", crpm=").append(crpm);
        sb.append(", dcav=").append(dcav);
        sb.append(", dcho=").append(dcho);
        sb.append(", dcve=").append(dcve);
        sb.append(", p16l=").append(p16l);
        sb.append(", p22l=").append(p22l);
        sb.append(", p28l=").append(p28l);
        sb.append(", p40l=").append(p40l);
        sb.append(", a16l=").append(a16l);
        sb.append(", a22l=").append(a22l);
        sb.append(", a28l=").append(a28l);
        sb.append(", a34l=").append(a34l);
        sb.append(", a40l=").append(a40l);
        sb.append(", peb=").append(peb);
        sb.append(", pel=").append(pel);
        sb.append(", per=").append(per);
        sb.append(", peu=").append(peu);
        sb.append(", sifa=").append(sifa);
        sb.append(", tabArcRes=").append(tabArcRes);
        sb.append(", tabDen=").append(tabDen);
        sb.append(", tabGr=").append(tabGr);
        sb.append(", tabNeu=").append(tabNeu);
        sb.append(", sbdc=").append(sbdc);
        sb.append(", sco2=").append(sco2);
        sb.append(", scor=").append(scor);
        sb.append(", sdde=").append(sdde);
        sb.append(", sfb2=").append(sfb2);
        sb.append(", sgra=").append(sgra);
        sb.append(", sgrb=").append(sgrb);
        sb.append(", snb2=").append(snb2);
        sb.append(", snfa=").append(snfa);
        sb.append(", snna=").append(snna);
        sb.append(", snp2=").append(snp2);
        sb.append(", snpe=").append(snpe);
        sb.append(", stem=").append(stem);
        sb.append(", calp=").append(calp);
        sb.append(", dtcr=").append(dtcr);
        sb.append(", dtdr=").append(dtdr);
        sb.append(", dtpc=").append(dtpc);
        sb.append(", grpcl=").append(grpcl);
        sb.append(", poredt=").append(poredt);
        sb.append(", atmp=").append(atmp);
        sb.append(", hord=").append(hord);
        sb.append(", verd=").append(verd);
        sb.append(", vw=").append(vw);
        sb.append(", vxo=").append(vxo);
        sb.append(", grbz=").append(grbz);
        sb.append(", sdea=").append(sdea);
        sb.append(", abga=").append(abga);
        sb.append(", abgb=").append(abgb);
        sb.append(", abgc=").append(abgc);
        sb.append(", tvde=").append(tvde);
        sb.append(", grArc=").append(grArc);
        sb.append(", pdGravBhc=").append(pdGravBhc);
        sb.append(", p34l=").append(p34l);
        sb.append(", tabArc=").append(tabArc);
        sb.append(", rpmAdn=").append(rpmAdn);
        sb.append(", aco=").append(aco);
        sb.append(", acq=").append(acq);
        sb.append(", cht=").append(cht);
        sb.append(", cn=").append(cn);
        sb.append(", cnlo=").append(cnlo);
        sb.append(", corr=").append(corr);
        sb.append(", deno=").append(deno);
        sb.append(", lsd=").append(lsd);
        sb.append(", lsn=").append(lsn);
        sb.append(", perm=").append(perm);
        sb.append(", rto=").append(rto);
        sb.append(", ssd=").append(ssd);
        sb.append(", ssn=").append(ssn);
        sb.append(", swb=").append(swb);
        sb.append(", dgr=").append(dgr);
        sb.append(", nucp=").append(nucp);
        sb.append(", sfxe=").append(sfxe);
        sb.append(", gre=").append(gre);
        sb.append(", appc=").append(appc);
        sb.append(", rop=").append(rop);
        sb.append(", sema=").append(sema);
        sb.append(", sesa=").append(sesa);
        sb.append(", sexa=").append(sexa);
        sb.append(", wrm=").append(wrm);
        sb.append(", scrd=").append(scrd);
        sb.append(", htem=").append(htem);
        sb.append(", rxo=").append(rxo);
        sb.append(", rt=").append(rt);
        sb.append(", rm=").append(rm);
        sb.append(", rla5=").append(rla5);
        sb.append(", rla4=").append(rla4);
        sb.append(", rla3=").append(rla3);
        sb.append(", rla2=").append(rla2);
        sb.append(", rla1=").append(rla1);
        sb.append(", pr=").append(pr);
        sb.append(", dt1=").append(dt1);
        sb.append(", cnl=").append(cnl);
        sb.append(", por=").append(por);
        sb.append(", rtHrlt=").append(rtHrlt);
        sb.append(", rxoHrlt=").append(rxoHrlt);
        sb.append(", rmHrlt=").append(rmHrlt);
        sb.append(", cali=").append(cali);
        sb.append(", tten=").append(tten);
        sb.append(", cnce=").append(cnce);
        sb.append(", sw4=").append(sw4);
        sb.append(", swdz=").append(swdz);
        sb.append(", rla0=").append(rla0);
        sb.append(", hdra=").append(hdra);
        sb.append(", sw7=").append(sw7);
        sb.append(", hdar=").append(hdar);
        sb.append(", rxoz=").append(rxoz);
        sb.append(", acbz=").append(acbz);
        sb.append(", cncb=").append(cncb);
        sb.append(", denb=").append(denb);
        sb.append(", grc=").append(grc);
        sb.append(", kcs=").append(kcs);
        sb.append(", pcf=").append(pcf);
        sb.append(", pcs=").append(pcs);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}