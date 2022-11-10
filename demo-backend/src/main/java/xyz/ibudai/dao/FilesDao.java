package xyz.ibudai.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.ibudai.entity.Files;

import java.util.List;

@Mapper
public interface FilesDao {

    List<Files> list();

    Files get(String ID);

    int add(Files file);

    int delete(String ID);
}
