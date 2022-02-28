package xyz.greatinvincible.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.greatinvincible.entity.Files;
import xyz.greatinvincible.mapper.FilesMapper;
import xyz.greatinvincible.services.FilesService;

import java.util.List;

@Service
public class FilesServiceImpl implements FilesService {

    @Autowired
    private FilesMapper filesMapper;

    @Override
    public List<Files> list() {
        return filesMapper.list();
    }

    @Override
    public Files get(String ID) {
        return filesMapper.get(ID);
    }

    @Override
    public int add(Files file) {
        return filesMapper.add(file);
    }

    @Override
    public int delete(String ID) {
        return filesMapper.delete(ID);
    }
}
