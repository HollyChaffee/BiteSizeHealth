package com.bytesizehealth.server.service;

import com.bytesizehealth.server.model.ByteSizePiece;

import java.util.List;

public interface ByteSizePieceService {
    ByteSizePiece createByteSizePiece(ByteSizePiece byteSizePiece);

    ByteSizePiece updateByteSizePiece(ByteSizePiece byteSizePiece);

    List<ByteSizePiece> getAllByteSizePiece();

    ByteSizePiece getBiteSizePieceById(long tipOfTheMonthId);

    void deleteBiteSizePiece(long id);
}
