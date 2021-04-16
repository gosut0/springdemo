package com.koiwaLearning.api.mapper;

import com.koiwaLearning.api.domain.ScoresInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoresMapper {
    // 查询
    List<ScoresInfo> getScoresInfo();

    // 追加
    int insertScores(ScoresInfo scores);

    // 更新
    int updateScores(ScoresInfo scores);

    // 削除
    int deleteScores(String cid);
}
