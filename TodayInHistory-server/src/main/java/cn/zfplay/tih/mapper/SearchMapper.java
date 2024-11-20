package cn.zfplay.tih.mapper;

import cn.zfplay.tih.pojo.History;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SearchMapper {
    @Select("SELECT * FROM today_in_history WHERE month = #{month} and day = #{day};")
    List<History> search(String month, String day);
}
