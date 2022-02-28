package xyz.greatinvincible.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.greatinvincible.entity.Files;

import java.util.List;

@Mapper
public interface FilesMapper {

    List<Files> list();

    Files get(String ID);

    int add(Files file);

    int delete(String ID);
}
