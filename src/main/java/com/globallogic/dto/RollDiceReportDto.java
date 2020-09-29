package com.globallogic.dto;

import lombok.Data;

@Data
public class RollDiceReportDto {

  private Long totalRolls;
  private Long simulationsAmount;
  private Integer dicePieces;
  private Integer diceSides;

  public RollDiceReportDto(Long totalRolls, Long simulationsAmount, Integer dicePieces, Integer diceSides) {
    this.totalRolls = totalRolls;
    this.simulationsAmount = simulationsAmount;
    this.dicePieces = dicePieces;
    this.diceSides = diceSides;
  }
}
