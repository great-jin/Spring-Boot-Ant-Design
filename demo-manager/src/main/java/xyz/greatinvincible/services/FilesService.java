package xyz.greatinvincible.services;

import xyz.greatinvincible.entity.Files;

import java.util.List;

public interface FilesService {

    List<Files> list();

    Files get(String ID);

    int add(Files file);

    int delete(String ID);

}
