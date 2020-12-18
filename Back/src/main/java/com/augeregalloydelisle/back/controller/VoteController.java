package com.augeregalloydelisle.back.controller;

import com.augeregalloydelisle.back.entity.Proposition;
import com.augeregalloydelisle.back.entity.User;
import com.augeregalloydelisle.back.exception.BadRequestException;
import com.augeregalloydelisle.back.service.PropositionService;
import com.augeregalloydelisle.back.service.SondageService;
import com.augeregalloydelisle.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/vote")
public class VoteController {
    @Autowired
    private SondageService sondageService;

    @Autowired
    private UserService userService;

    @Autowired
    private PropositionService propositionService;

    @PatchMapping("/{id}/voteYes")
    public ResponseEntity<?> voteYes(@PathVariable(name = "id") String idProposition, HttpServletRequest httpRequest) {
        try {
            Integer id = Integer.parseInt(idProposition);
            String userName = (String) httpRequest.getAttribute("userName");
            User user = userService.findByUserName(userName);
            propositionService.voteYes(id, user);
            return ResponseEntity.ok().build();
        } catch (NumberFormatException e) {
            throw new BadRequestException("invalid id");
        }
    }

    @PatchMapping("/{id}/voteNo")
    public ResponseEntity<?> voteNo(@PathVariable(name = "id") String idProposition, HttpServletRequest httpRequest) {
        try {
            Integer id = Integer.parseInt(idProposition);
            String userName = (String) httpRequest.getAttribute("userName");
            User user = userService.findByUserName(userName);
            propositionService.voteNon(id, user);
            return ResponseEntity.ok().build();
        } catch (NumberFormatException e) {
            throw new BadRequestException("invalid id");
        }
    }

    @PatchMapping("/{id}/voteDelete")
    public ResponseEntity<?> voteDelete(@PathVariable(name = "id") String idProposition, HttpServletRequest httpRequest) {
        try {
            Integer id = Integer.parseInt(idProposition);
            String userName = (String) httpRequest.getAttribute("userName");
            User user = userService.findByUserName(userName);
            propositionService.voteDelete(id, user);
            return ResponseEntity.ok().build();
        } catch (NumberFormatException e) {
            throw new BadRequestException("invalid id");
        }
    }
}
