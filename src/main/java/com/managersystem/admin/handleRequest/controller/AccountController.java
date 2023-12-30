package com.managersystem.admin.handleRequest.controller;

import com.managersystem.admin.handleRequest.controller.base.BaseController;
import com.managersystem.admin.handleRequest.controller.dto.AccountDto;
import com.managersystem.admin.handleRequest.controller.dto.LoginDto;
import com.managersystem.admin.server.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/mos/cms/auth")
@CrossOrigin(origins = "*")
public class AccountController extends BaseController {

  @Autowired
  AccountService accountService;


  @PostMapping("init")
  public ResponseEntity<?> initAccount() {
    try {
      return ResponseEntity.ok(accountService.initAdminAccount());
    } catch (Exception ex) {
      return errorApi(ex);
    }
  }

  @PostMapping("sign-in")
  public ResponseEntity<?> createAccount(@RequestBody AccountDto dto) {
    try {
      return ResponseEntity.ok(accountService.createAccount(dto));
    } catch (Exception ex) {
      return errorApi(ex);
    }
  }

  @PostMapping("login")
  public ResponseEntity<?> login(@RequestBody LoginDto dto) {
    try {
      return ResponseEntity.ok(accountService.login(dto));
    } catch (Exception ex) {
      return errorApi(ex);
    }
  }
}
