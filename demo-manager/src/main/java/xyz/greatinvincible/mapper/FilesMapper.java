package xyz.greatinvincible.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.greatinvincible.entity.Files;

@Mapper
public interface FilesMapper {

    int add(Files file);
}
