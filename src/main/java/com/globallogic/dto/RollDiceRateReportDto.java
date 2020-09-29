package com.globallogic.dto;

import lombok.Data;

@Data
public class RollDiceRateReportDto {

  private Integer rollSum;
  private Double dropRate;

  public RollDiceRateReportDto(Integer rollSum, Double dropRate) {
    this.rollSum = rollSum;
    this.dropRate = dropRate;
  }
}
