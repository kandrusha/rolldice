package com.globallogic.controller;

import com.globallogic.dto.RollDiceRateReportDto;
import com.globallogic.dto.RollDiceRateRequestDto;
import com.globallogic.dto.RollDiceReportDto;
import com.globallogic.dto.RollDiceDto;
import com.globallogic.dto.RollDiceRequestDto;
import com.globallogic.service.RollDiceStatisticService;
import com.globallogic.service.RollDiceService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rolldice")
public class DiceController {

  @Autowired
  private RollDiceService diceService;
  @Autowired
  private RollDiceStatisticService diceStatisticService;

  @PostMapping()
  public List<RollDiceDto> rollDice(@Valid RollDiceRequestDto requestDto) {
    return diceService.rollDice(requestDto);
  }

  @GetMapping("/report")
  public List<RollDiceReportDto> getRollDiceData() {
    return diceStatisticService.getRollDiceData();
  }

  @GetMapping("/report/rate")
  public List<RollDiceRateReportDto> getRollDiceRateData(@Valid RollDiceRateRequestDto requestDto) {
    return diceStatisticService.getRollDiceRateData(requestDto);

  }

}
