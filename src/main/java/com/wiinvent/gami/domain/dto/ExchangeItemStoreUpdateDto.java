package com.wiinvent.gami.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wiinvent.gami.domain.entities.type.Status;
import com.wiinvent.gami.domain.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ExchangeItemStoreUpdateDto {
  private String name;
  @NotNull
  @Min(0)
  private Integer coinPrice;
  @NotNull
  @Min(0)
  private Integer pointPrice;
  @NotNull
  @Min(0)
  private Integer ticketPrice;
  @Getter(AccessLevel.NONE)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Schema(example = "2021-10-10 10:10:10")
  private LocalDateTime startAt;

  @Getter(AccessLevel.NONE)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Schema(example = "2021-10-10 10:10:10")
  private LocalDateTime endAt;
  @NotNull
  private Status status;
  @Min(0)
  private Long limitExchange;

  public Long getEndAt() {return DateUtils.timeToLongAtVn(endAt);}

  public Long getStartAt() {return DateUtils.timeToLongAtVn(startAt);}

}
