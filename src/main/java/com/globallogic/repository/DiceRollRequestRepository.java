package com.globallogic.repository;

import com.globallogic.dto.RollDiceRateReportDto;
import com.globallogic.dto.RollDiceReportDto;
import com.globallogic.entity.DiceRollRequest;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DiceRollRequestRepository extends CrudRepository<DiceRollRequest, Long> {

  @Query("SELECT new com.globallogic.dto.RollDiceReportDto(sum(d.rolls) as totalRolls, count(d.id) as simulationsAmount, " +
    "d.dicePieces, d.diceSides) FROM DiceRollRequest AS d GROUP BY d.dicePieces, d.diceSides")
  List<RollDiceReportDto> getRollDiceReports();

  @Query("SELECT new com.globallogic.dto.RollDiceRateReportDto(di.rollSum, " +
    "round((cast(sum(di.rollSumAmount) AS double)*100/sum(d.rolls)),2) AS dropRate) " +
    "FROM DiceRollRequest d JOIN d.diceRolls di WHERE d.dicePieces=:dicePieces " +
    "AND d.diceSides=:diceSides GROUP BY d.dicePieces, d.diceSides, di.rollSum")
  List<RollDiceRateReportDto> getRollDiceRateReports(@Param("dicePieces")Integer dicePieces,
                                                     @Param("diceSides") Integer diceSides);
}
