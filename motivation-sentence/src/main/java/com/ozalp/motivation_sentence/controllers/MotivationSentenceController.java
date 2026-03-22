package com.ozalp.motivation_sentence.controllers;

import com.ozalp.core.utils.consts.ApiConst;
import com.ozalp.core.utils.consts.ApiParams;
import com.ozalp.motivation_sentence.business.dtos.CreateMotivationSentenceRequest;
import com.ozalp.motivation_sentence.business.services.MotivationSentenceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConst.ApiPath.MOTIVATION_SENTENCE)
@RequiredArgsConstructor
public class MotivationSentenceController {

    private final MotivationSentenceService motivationSentenceService;

    @PostMapping(ApiParams.Base.CREATE)
    ResponseEntity<?> create(@RequestBody @Valid CreateMotivationSentenceRequest request) {
        return ResponseEntity.ok(motivationSentenceService.create(request));
    }

    @GetMapping(ApiParams.Base.RANDOM)
    ResponseEntity<?> getRandom() {
        return ResponseEntity.ok(motivationSentenceService.getRandomSentence());
    }
}
