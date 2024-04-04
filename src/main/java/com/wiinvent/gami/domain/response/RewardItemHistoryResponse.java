package com.wiinvent.gami.domain.response;

import com.wiinvent.gami.domain.entities.type.RewardItemType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
public class RewardItemHistoryResponse {

  private UUID id;

  private String name;

  private RewardItemType type;

  private UUID userId;

  private Long rewardItemId; // id reward item

  private UUID rewardItemDetailId; // id qua trung thuong, (voucher <=> voucherDetailId, product <=> productDetailId)

  private Long rewardSegmentId;

  private String imageUrl;

  private String note;

  private String rewardInfo;
}