package com.bytesizehealth.server.service;

import com.bytesizehealth.server.model.ByteSizePiece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bytesizehealth.server.controller.ResourceNotFoundException;
import com.bytesizehealth.server.repository.ByteSizePieceRepository;


import java.util.List;
import java.util.Optional;

@Service
public class ByteSizePieceServiceImpl implements ByteSizePieceService {

    @Autowired
    private ByteSizePieceRepository tipOfTheMonthRepository;


    @Override
    public ByteSizePiece createByteSizePiece(ByteSizePiece byteSizePiece) {
        return tipOfTheMonthRepository.save(byteSizePiece);
    }

    @Override
    public ByteSizePiece updateByteSizePiece(ByteSizePiece byteSizePiece) {
        Optional<ByteSizePiece> tipOfTheMonthDb = this.tipOfTheMonthRepository.findById(byteSizePiece.getId());

        if (tipOfTheMonthDb.isPresent()) {
            ByteSizePiece byteSizePieceUpdate = tipOfTheMonthDb.get();
            byteSizePieceUpdate.setId(byteSizePiece.getId());
            byteSizePieceUpdate.setName(byteSizePiece.getName());
            byteSizePieceUpdate.setDescription(byteSizePiece.getDescription());
            tipOfTheMonthRepository.save(byteSizePieceUpdate);
            return byteSizePieceUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + byteSizePiece.getId());
        }
        //return null;
    }

    @Override
    public List<ByteSizePiece> getAllByteSizePiece() {

        return this.tipOfTheMonthRepository.findAll();
    }

    @Override
    public ByteSizePiece getBiteSizePieceById(long tipOfTheMonthId) {

        Optional<ByteSizePiece>tipOfTheMonthDb = this.tipOfTheMonthRepository.findById(tipOfTheMonthId);

        if (tipOfTheMonthDb.isPresent()) {
            return tipOfTheMonthDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + tipOfTheMonthId);
        }
    }

    @Override
    public void deleteBiteSizePiece(long tipOfTheMonthId) {
        Optional <ByteSizePiece> tipOfTheMonthDb = this.tipOfTheMonthRepository.findById(tipOfTheMonthId);

        if (tipOfTheMonthDb.isPresent()) {
            this.tipOfTheMonthRepository.delete(tipOfTheMonthDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + tipOfTheMonthId);
        }

    }
}
