package com.globallogic.service;

import com.globallogic.dto.RollDiceRateReportDto;
import com.globallogic.dto.RollDiceRateRequestDto;
import com.globallogic.dto.RollDiceReportDto;
import java.util.List;

public interface RollDiceStatisticService {

  List<RollDiceReportDto> getRollDiceData();

  List<RollDiceRateReportDto> getRollDiceRateData(RollDiceRateRequestDto requestDto);
}
