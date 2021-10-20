package com.misiontic.ciclo3.reto3.service;

import com.misiontic.ciclo3.reto3.model.Score;
import com.misiontic.ciclo3.reto3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id) {
        return scoreRepository.getScore(id);
    }

    public Score save(Score score) {
        if(score.getId()==null) {
            return scoreRepository.save(score);
        } else {
            Optional<Score> scoreAux = scoreRepository.getScore(score.getId());
            if(scoreAux.isEmpty()) {
                return scoreRepository.save(score);
            } else {
                return score;
            }
        }
    }
}
