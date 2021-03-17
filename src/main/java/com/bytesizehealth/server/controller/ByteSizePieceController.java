package com.bytesizehealth.server.controller;

import com.bytesizehealth.server.model.ByteSizePiece;
import com.bytesizehealth.server.service.ByteSizePieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

    @RestController
    public class ByteSizePieceController {

        @Autowired
        private ByteSizePieceService byteSizePieceService;

        @GetMapping("/ByteSizePiece")
        public ResponseEntity<List<ByteSizePiece>> getAllByteSizePiece() {
            return ResponseEntity.ok().body(byteSizePieceService.getAllByteSizePiece());
        }

        @GetMapping("/ByteSizePiece/{id}")
        public ResponseEntity<ByteSizePiece> getByteSizePieceById(@PathVariable long id) {
            return ResponseEntity.ok().body(byteSizePieceService.getBiteSizePieceById(id));
        }

        @PostMapping("/ByteSizePiece")
        public ResponseEntity<ByteSizePiece> createByteSizePiece(@RequestBody ByteSizePiece byteSizePiece) {
            return ResponseEntity.ok().body(byteSizePieceService.createByteSizePiece(byteSizePiece));
        }

        @PutMapping("/ByteSizePiece/{id}")
        public ResponseEntity<ByteSizePiece> updateByteSizePiece(@PathVariable long id, @RequestBody ByteSizePiece byteSizePiece) {
            byteSizePiece.setId(id);
            return ResponseEntity.ok().body(byteSizePieceService.updateByteSizePiece(byteSizePiece));
        }

        @DeleteMapping("/ByteSizePiece/{id}")
        public HttpStatus deleteByteSizePiece(@PathVariable long id) {
            byteSizePieceService.deleteBiteSizePiece(id);
            return HttpStatus.OK;
        }
    }

