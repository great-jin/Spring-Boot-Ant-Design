package xyz.greatinvincible.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.greatinvincible.entity.Files;
import xyz.greatinvincible.mapper.FilesMapper;
import xyz.greatinvincible.services.FilesService;

@Service
public class FilesServiceImpl implements FilesService {

    @Autowired
    private FilesMapper filesMapper;

    @Override
    public int add(Files file) {
        return filesMapper.add(file);
    }
}
