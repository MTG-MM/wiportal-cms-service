package com.wiinvent.gami.domain.response;

import com.wiinvent.gami.domain.entities.type.PaymentMethodType;
import lombok.Data;

import java.util.UUID;

@Data
public class PackageHistoryResponse {
  private UUID id;
  private String packageCode;
  private String packageInfo;
  private Integer price;
  private PaymentMethodType paymentMethod;;
  private Long createdAt;
}
