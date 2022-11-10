package xyz.ibudai.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ibudai.entity.Files;
import xyz.ibudai.dao.FilesDao;
import xyz.ibudai.service.FilesService;

import java.util.List;

@Service
public class FilesServiceImpl implements FilesService {

    @Autowired
    private FilesDao filesDao;

    @Override
    public List<Files> list() {
        return filesDao.list();
    }

    @Override
    public Files get(String ID) {
        return filesDao.get(ID);
    }

    @Override
    public int add(Files file) {
        return filesDao.add(file);
    }

    @Override
    public int delete(String ID) {
        return filesDao.delete(ID);
    }
}
