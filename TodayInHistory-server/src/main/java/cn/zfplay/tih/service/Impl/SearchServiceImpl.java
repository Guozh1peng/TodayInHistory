package cn.zfplay.tih.service.Impl;

import cn.zfplay.tih.mapper.SearchMapper;
import cn.zfplay.tih.pojo.History;
import cn.zfplay.tih.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private SearchMapper searchMapper;

    @Override
    public List<History> search(String month, String day) {
        return searchMapper.search(month, day);
    }
}
