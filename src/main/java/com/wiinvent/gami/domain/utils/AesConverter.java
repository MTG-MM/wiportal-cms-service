package com.wiinvent.gami.domain.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Converter
@Component
public class AesConverter implements AttributeConverter<String, String> {

  @Autowired
  private AESUtils aesUtils;

  @Override
  public String convertToDatabaseColumn(String data) {
    return aesUtils.encrypt(data);
  }

  @Override
  public String convertToEntityAttribute(String dbData) {
    return aesUtils.decrypt(dbData);
  }
}