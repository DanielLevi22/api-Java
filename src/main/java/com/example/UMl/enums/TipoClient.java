package com.example.UMl.enums;

public enum TipoClient {
  PESSOAFISICA(1, "Pessoa Fisica"),
  PESSOAJURIDICA(2, "Pessoa Juridica");

  private int cod;
  private String descricao;

  private TipoClient(int cod, String descricao) {
    this.cod = cod;
    this.descricao = descricao;
  }
  public int getCod() {
    return cod;
  }
  public String getDescricao() {
    return descricao;
  }

  public static TipoClient toEnum(Integer cod) {
    if(cod == null) return null;
    for(TipoClient x: TipoClient.values()) {
      if(cod.equals(x.getCod())) {
          return x;
      }
    }
    throw new IllegalArgumentException("Id invalido" + cod);
  }

 
}
