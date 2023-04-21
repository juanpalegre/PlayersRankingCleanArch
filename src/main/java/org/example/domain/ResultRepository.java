package org.example.domain;

import org.example.model.Result;

import java.util.List;

public interface ResultRepository {

    void loadResult(Result result);

    List<Result> getAllResults();
}
