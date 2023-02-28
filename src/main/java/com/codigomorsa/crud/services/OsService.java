package com.codigomorsa.crud.services;

import com.codigomorsa.crud.model.Os;
import com.codigomorsa.crud.repositories.OsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OsService {

    private final OsRepository osRepository;

    public OsService(OsRepository osRepository) {
        this.osRepository = osRepository;
    }

    public List<Os> getAllOs() {
        return osRepository.getAllOs();
    }

    public long createOs(Os newOs) {
        return osRepository.createOs(newOs);
    }
}
