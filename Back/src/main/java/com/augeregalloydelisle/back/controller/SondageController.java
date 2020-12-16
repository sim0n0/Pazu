package com.augeregalloydelisle.back.controller;

import com.augeregalloydelisle.back.entity.Proposition;
import com.augeregalloydelisle.back.entity.Sondage;
import com.augeregalloydelisle.back.entity.User;
import com.augeregalloydelisle.back.exception.BadRequestException;
import com.augeregalloydelisle.back.service.SondageService;
import com.augeregalloydelisle.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BandCombineOp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/sondage")
public class SondageController {
    @Autowired
    private UserService userService;
    @Autowired
    private SondageService sondageService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Map<String, Object> request, HttpServletRequest httpRequest) {
        String userName = (String) httpRequest.getAttribute("userName");

        String title = (String) request.get("title");
        String place = (String) request.get("place");
        List<Map<String, Object>> propositions = (List<Map<String, Object>>) request.get("propositions");

        User user = userService.findByUserName(userName);

        if (propositions == null) {
            throw new BadRequestException("no proposition provided");

        }
        ArrayList<Proposition> propositionArrayList = new ArrayList<>();
        for (Map<String, Object> prop : propositions) {
            propositionArrayList.add(new Proposition((String) prop.get("date"), (String) prop.get("start"), (String) prop.get("finish")));
        }
        return ResponseEntity.ok(sondageService.create(title, place, propositionArrayList, user));

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSondage(@PathVariable(name = "id") String id) {
        try {
            Integer idInteger = Integer.parseInt(id);
            Sondage sondage = sondageService.findById(idInteger);
            return ResponseEntity.ok(sondage);

        } catch (NumberFormatException e) {
            throw new BadRequestException("invalid id");
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getSondages(HttpServletRequest httpRequest) {
        String userName = (String) httpRequest.getAttribute("userName");
        User user = userService.findByUserName(userName);
        return ResponseEntity.ok(sondageService.getAllSondageByOwner(user));
    }
}
