package cn.zfplay.tih.service;

import cn.zfplay.tih.pojo.History;

import java.util.List;

public interface SearchService {
    List<History> search(String month, String day);
}
