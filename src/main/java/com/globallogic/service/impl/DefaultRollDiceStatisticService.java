package com.globallogic.service.impl;

import com.globallogic.dto.RollDiceRateReportDto;
import com.globallogic.dto.RollDiceRateRequestDto;
import com.globallogic.dto.RollDiceReportDto;
import com.globallogic.repository.DiceRollRequestRepository;
import com.globallogic.service.RollDiceStatisticService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultRollDiceStatisticService implements RollDiceStatisticService {

  @Autowired
  private DiceRollRequestRepository diceRollRepository;

  public List<RollDiceReportDto> getRollDiceData() {
    return diceRollRepository.getRollDiceReports();
  }

  public List<RollDiceRateReportDto> getRollDiceRateData(RollDiceRateRequestDto requestDto) {
    return diceRollRepository.getRollDiceRateReports(requestDto.getDicePieces(), requestDto.getDiceSides());
  }

}
