package xyz.ibudai.service;

import xyz.ibudai.entity.Files;

import java.util.List;

public interface FilesService {

    List<Files> list();

    Files get(String ID);

    int add(Files file);

    int delete(String ID);
}
