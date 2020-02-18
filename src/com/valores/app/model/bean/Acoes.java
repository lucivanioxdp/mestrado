package com.valores.app.model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="acao_consulta")
public class Acoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String data_pregao_ini_M;
    private String data_pregao_fim_M;
    private String data_per_ini_M;
    private String data_per_fim_M;
    private float preult_ini_M;
    private float preult_fim_M;
    private float calc_rend_M;
    private String venc_perd;
    private float calc_rend_R;
    private String cod_neg_papel;
    private String data_pregao_ini;
    private String data_pregao_fim;
    private String data_per_ini_R;
    private String data_per_fim_R;
    private float preult_ini;
    private float preult_fim;
    private int qtd_fatcot_ini;
    private int qtd_quatot_ini;
    private int qtd_papel_ini;
    private int qtd_ano_ini;
    private String tipo_registro_ini;
    private String cod_bdi_ini;
    private String tipo_mercado_ini;
    private String nome_resumido_ini;
    private String especi_ini;
    private String prazot_ini;
    private String modref_ini;
    private int preabe_ini;
    private int premax_ini;
    private int premin_ini;
    private int premed_ini;
    private int preofc_ini;
    private int preofv_ini;
    private String totneg_ini;
    private String quatot_ini;
    private String voltot_ini;
    private String preexe_ini;
    private String indopc_ini;
    private String datven_ini;
    private String fatcot_ini;
    private String ptoexe_ini;
    private String codisi_ini;
    private String dismes_ini;
    private int qtd_fatcot_fim;
    private int qtd_quatot_fim;
    private int qtd_papel_fim;
    private int qtd_ano_fim;
    private String tipo_registro_fim;
    private String cod_bdi_fim;
    private String tipo_mercado_fim;
    private String nome_resumido_fim;
    private String especi_fim;
    private String prazot_fim;
    private String modref_fim;
    private int preabe_fim;
    private int premax_fim;
    private int premin_fim;
    private int premed_fim;
    private int preofc_fim;
    private int preofv_fim;
    private String totneg_fim;
    private String quatot_fim;
    private String voltot_fim;
    private String preexe_fim;
    private String indopc_fim;
    private String datven_fim;
    private String fatcot_fim;
    private String ptoexe_fim;
    private String codisi_fim;
    private String dismes_fim;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData_pregao_ini_M() {
        return data_pregao_ini_M;
    }

    public void setData_pregao_ini_M(String data_pregao_ini_M) {
        this.data_pregao_ini_M = data_pregao_ini_M;
    }

    public String getData_pregao_fim_M() {
        return data_pregao_fim_M;
    }

    public void setData_pregao_fim_M(String data_pregao_fim_M) {
        this.data_pregao_fim_M = data_pregao_fim_M;
    }

    public String getData_per_ini_M() {
        return data_per_ini_M;
    }

    public void setData_per_ini_M(String data_per_ini_M) {
        this.data_per_ini_M = data_per_ini_M;
    }

    public String getData_per_fim_M() {
        return data_per_fim_M;
    }

    public void setData_per_fim_M(String data_per_fim_M) {
        this.data_per_fim_M = data_per_fim_M;
    }

    public float getPreult_ini_M() {
        return preult_ini_M;
    }

    public void setPreult_ini_M(float preult_ini_M) {
        this.preult_ini_M = preult_ini_M;
    }

    public float getPreult_fim_M() {
        return preult_fim_M;
    }

    public void setPreult_fim_M(float preult_fim_M) {
        this.preult_fim_M = preult_fim_M;
    }

    public float getCalc_rend_M() {
        return calc_rend_M;
    }

    public void setCalc_rend_M(float calc_rend_M) {
        this.calc_rend_M = calc_rend_M;
    }

    public String getVenc_perd() {
        return venc_perd;
    }

    public void setVenc_perd(String venc_perd) {
        this.venc_perd = venc_perd;
    }

    public float getCalc_rend_R() {
        return calc_rend_R;
    }

    public void setCalc_rend_R(float calc_rend_R) {
        this.calc_rend_R = calc_rend_R;
    }

    public String getCod_neg_papel() {
        return cod_neg_papel;
    }

    public void setCod_neg_papel(String cod_neg_papel) {
        this.cod_neg_papel = cod_neg_papel;
    }

    public String getData_pregao_ini() {
        return data_pregao_ini;
    }

    public void setData_pregao_ini(String data_pregao_ini) {
        this.data_pregao_ini = data_pregao_ini;
    }

    public String getData_pregao_fim() {
        return data_pregao_fim;
    }

    public void setData_pregao_fim(String data_pregao_fim) {
        this.data_pregao_fim = data_pregao_fim;
    }

    public String getData_per_ini_R() {
        return data_per_ini_R;
    }

    public void setData_per_ini_R(String data_per_ini_R) {
        this.data_per_ini_R = data_per_ini_R;
    }

    public String getData_per_fim_R() {
        return data_per_fim_R;
    }

    public void setData_per_fim_R(String data_per_fim_R) {
        this.data_per_fim_R = data_per_fim_R;
    }

    public float getPreult_ini() {
        return preult_ini;
    }

    public void setPreult_ini(float preult_ini) {
        this.preult_ini = preult_ini;
    }

    public float getPreult_fim() {
        return preult_fim;
    }

    public void setPreult_fim(float preult_fim) {
        this.preult_fim = preult_fim;
    }

    public int getQtd_fatcot_ini() {
        return qtd_fatcot_ini;
    }

    public void setQtd_fatcot_ini(int qtd_fatcot_ini) {
        this.qtd_fatcot_ini = qtd_fatcot_ini;
    }

    public int getQtd_quatot_ini() {
        return qtd_quatot_ini;
    }

    public void setQtd_quatot_ini(int qtd_quatot_ini) {
        this.qtd_quatot_ini = qtd_quatot_ini;
    }

    public int getQtd_papel_ini() {
        return qtd_papel_ini;
    }

    public void setQtd_papel_ini(int qtd_papel_ini) {
        this.qtd_papel_ini = qtd_papel_ini;
    }

    public int getQtd_ano_ini() {
        return qtd_ano_ini;
    }

    public void setQtd_ano_ini(int qtd_ano_ini) {
        this.qtd_ano_ini = qtd_ano_ini;
    }

    public String getTipo_registro_ini() {
        return tipo_registro_ini;
    }

    public void setTipo_registro_ini(String tipo_registro_ini) {
        this.tipo_registro_ini = tipo_registro_ini;
    }

    public String getCod_bdi_ini() {
        return cod_bdi_ini;
    }

    public void setCod_bdi_ini(String cod_bdi_ini) {
        this.cod_bdi_ini = cod_bdi_ini;
    }

    public String getTipo_mercado_ini() {
        return tipo_mercado_ini;
    }

    public void setTipo_mercado_ini(String tipo_mercado_ini) {
        this.tipo_mercado_ini = tipo_mercado_ini;
    }

    public String getNome_resumido_ini() {
        return nome_resumido_ini;
    }

    public void setNome_resumido_ini(String nome_resumido_ini) {
        this.nome_resumido_ini = nome_resumido_ini;
    }

    public String getEspeci_ini() {
        return especi_ini;
    }

    public void setEspeci_ini(String especi_ini) {
        this.especi_ini = especi_ini;
    }

    public String getPrazot_ini() {
        return prazot_ini;
    }

    public void setPrazot_ini(String prazot_ini) {
        this.prazot_ini = prazot_ini;
    }

    public String getModref_ini() {
        return modref_ini;
    }

    public void setModref_ini(String modref_ini) {
        this.modref_ini = modref_ini;
    }

    public int getPreabe_ini() {
        return preabe_ini;
    }

    public void setPreabe_ini(int preabe_ini) {
        this.preabe_ini = preabe_ini;
    }

    public int getPremax_ini() {
        return premax_ini;
    }

    public void setPremax_ini(int premax_ini) {
        this.premax_ini = premax_ini;
    }

    public int getPremin_ini() {
        return premin_ini;
    }

    public void setPremin_ini(int premin_ini) {
        this.premin_ini = premin_ini;
    }

    public int getPremed_ini() {
        return premed_ini;
    }

    public void setPremed_ini(int premed_ini) {
        this.premed_ini = premed_ini;
    }

    public int getPreofc_ini() {
        return preofc_ini;
    }

    public void setPreofc_ini(int preofc_ini) {
        this.preofc_ini = preofc_ini;
    }

    public int getPreofv_ini() {
        return preofv_ini;
    }

    public void setPreofv_ini(int preofv_ini) {
        this.preofv_ini = preofv_ini;
    }

    public String getTotneg_ini() {
        return totneg_ini;
    }

    public void setTotneg_ini(String totneg_ini) {
        this.totneg_ini = totneg_ini;
    }

    public String getQuatot_ini() {
        return quatot_ini;
    }

    public void setQuatot_ini(String quatot_ini) {
        this.quatot_ini = quatot_ini;
    }

    public String getVoltot_ini() {
        return voltot_ini;
    }

    public void setVoltot_ini(String voltot_ini) {
        this.voltot_ini = voltot_ini;
    }

    public String getPreexe_ini() {
        return preexe_ini;
    }

    public void setPreexe_ini(String preexe_ini) {
        this.preexe_ini = preexe_ini;
    }

    public String getIndopc_ini() {
        return indopc_ini;
    }

    public void setIndopc_ini(String indopc_ini) {
        this.indopc_ini = indopc_ini;
    }

    public String getDatven_ini() {
        return datven_ini;
    }

    public void setDatven_ini(String datven_ini) {
        this.datven_ini = datven_ini;
    }

    public String getFatcot_ini() {
        return fatcot_ini;
    }

    public void setFatcot_ini(String fatcot_ini) {
        this.fatcot_ini = fatcot_ini;
    }

    public String getPtoexe_ini() {
        return ptoexe_ini;
    }

    public void setPtoexe_ini(String ptoexe_ini) {
        this.ptoexe_ini = ptoexe_ini;
    }

    public String getCodisi_ini() {
        return codisi_ini;
    }

    public void setCodisi_ini(String codisi_ini) {
        this.codisi_ini = codisi_ini;
    }

    public String getDismes_ini() {
        return dismes_ini;
    }

    public void setDismes_ini(String dismes_ini) {
        this.dismes_ini = dismes_ini;
    }

    public int getQtd_fatcot_fim() {
        return qtd_fatcot_fim;
    }

    public void setQtd_fatcot_fim(int qtd_fatcot_fim) {
        this.qtd_fatcot_fim = qtd_fatcot_fim;
    }

    public int getQtd_quatot_fim() {
        return qtd_quatot_fim;
    }

    public void setQtd_quatot_fim(int qtd_quatot_fim) {
        this.qtd_quatot_fim = qtd_quatot_fim;
    }

    public int getQtd_papel_fim() {
        return qtd_papel_fim;
    }

    public void setQtd_papel_fim(int qtd_papel_fim) {
        this.qtd_papel_fim = qtd_papel_fim;
    }

    public int getQtd_ano_fim() {
        return qtd_ano_fim;
    }

    public void setQtd_ano_fim(int qtd_ano_fim) {
        this.qtd_ano_fim = qtd_ano_fim;
    }

    public String getTipo_registro_fim() {
        return tipo_registro_fim;
    }

    public void setTipo_registro_fim(String tipo_registro_fim) {
        this.tipo_registro_fim = tipo_registro_fim;
    }

    public String getCod_bdi_fim() {
        return cod_bdi_fim;
    }

    public void setCod_bdi_fim(String cod_bdi_fim) {
        this.cod_bdi_fim = cod_bdi_fim;
    }

    public String getTipo_mercado_fim() {
        return tipo_mercado_fim;
    }

    public void setTipo_mercado_fim(String tipo_mercado_fim) {
        this.tipo_mercado_fim = tipo_mercado_fim;
    }

    public String getNome_resumido_fim() {
        return nome_resumido_fim;
    }

    public void setNome_resumido_fim(String nome_resumido_fim) {
        this.nome_resumido_fim = nome_resumido_fim;
    }

    public String getEspeci_fim() {
        return especi_fim;
    }

    public void setEspeci_fim(String especi_fim) {
        this.especi_fim = especi_fim;
    }

    public String getPrazot_fim() {
        return prazot_fim;
    }

    public void setPrazot_fim(String prazot_fim) {
        this.prazot_fim = prazot_fim;
    }

    public String getModref_fim() {
        return modref_fim;
    }

    public void setModref_fim(String modref_fim) {
        this.modref_fim = modref_fim;
    }

    public int getPreabe_fim() {
        return preabe_fim;
    }

    public void setPreabe_fim(int preabe_fim) {
        this.preabe_fim = preabe_fim;
    }

    public int getPremax_fim() {
        return premax_fim;
    }

    public void setPremax_fim(int premax_fim) {
        this.premax_fim = premax_fim;
    }

    public int getPremin_fim() {
        return premin_fim;
    }

    public void setPremin_fim(int premin_fim) {
        this.premin_fim = premin_fim;
    }

    public int getPremed_fim() {
        return premed_fim;
    }

    public void setPremed_fim(int premed_fim) {
        this.premed_fim = premed_fim;
    }

    public int getPreofc_fim() {
        return preofc_fim;
    }

    public void setPreofc_fim(int preofc_fim) {
        this.preofc_fim = preofc_fim;
    }

    public int getPreofv_fim() {
        return preofv_fim;
    }

    public void setPreofv_fim(int preofv_fim) {
        this.preofv_fim = preofv_fim;
    }

    public String getTotneg_fim() {
        return totneg_fim;
    }

    public void setTotneg_fim(String totneg_fim) {
        this.totneg_fim = totneg_fim;
    }

    public String getQuatot_fim() {
        return quatot_fim;
    }

    public void setQuatot_fim(String quatot_fim) {
        this.quatot_fim = quatot_fim;
    }

    public String getVoltot_fim() {
        return voltot_fim;
    }

    public void setVoltot_fim(String voltot_fim) {
        this.voltot_fim = voltot_fim;
    }

    public String getPreexe_fim() {
        return preexe_fim;
    }

    public void setPreexe_fim(String preexe_fim) {
        this.preexe_fim = preexe_fim;
    }

    public String getIndopc_fim() {
        return indopc_fim;
    }

    public void setIndopc_fim(String indopc_fim) {
        this.indopc_fim = indopc_fim;
    }

    public String getDatven_fim() {
        return datven_fim;
    }

    public void setDatven_fim(String datven_fim) {
        this.datven_fim = datven_fim;
    }

    public String getFatcot_fim() {
        return fatcot_fim;
    }

    public void setFatcot_fim(String fatcot_fim) {
        this.fatcot_fim = fatcot_fim;
    }

    public String getPtoexe_fim() {
        return ptoexe_fim;
    }

    public void setPtoexe_fim(String ptoexe_fim) {
        this.ptoexe_fim = ptoexe_fim;
    }

    public String getCodisi_fim() {
        return codisi_fim;
    }

    public void setCodisi_fim(String codisi_fim) {
        this.codisi_fim = codisi_fim;
    }

    public String getDismes_fim() {
        return dismes_fim;
    }

    public void setDismes_fim(String dismes_fim) {
        this.dismes_fim = dismes_fim;
    }
    
    

}