package com.wiinvent.gami.domain.dto;

import lombok.Data;

@Data
public class CollectionCreateDto extends CollectionUpdateDto{
  private Long externalId;
}