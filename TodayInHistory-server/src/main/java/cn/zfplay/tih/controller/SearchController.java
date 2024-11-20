package cn.zfplay.tih.controller;

import cn.zfplay.tih.pojo.Result;
import cn.zfplay.tih.pojo.History;
import cn.zfplay.tih.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
@CrossOrigin(origins = "*")
public class SearchController {
    @Autowired
    private SearchService searchService;
    @GetMapping("/today_in_history")
    public Result<List<History>> today_in_history(String month, String day) {
        List<History> hs = searchService.search(month, day);
        return Result.success(hs);
    }
}
