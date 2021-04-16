package com.koiwaLearning.api.service;

import com.koiwaLearning.api.domain.ScoresInfo;
import com.koiwaLearning.api.mapper.ScoresMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoresService {

    @Autowired
    private ScoresMapper scoresMapper;

    public List<ScoresInfo> getScoresInfo() {
        return scoresMapper.getScoresInfo();
    }

    // 追加
    public int insertScores(ScoresInfo score) {
        return scoresMapper.insertScores(score);
    }

    // 更新
    public int updateScores(ScoresInfo score) {
        return scoresMapper.updateScores(score);
    }
    // 削除
//    public int deleteScores(String cid) {
//        return scoresMapper.deleteScores(cid);
//    }
}
