package controllers;

import algorithm.AlgorithmType;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.Result;
import dto.CalculateResult;
import services.CalculateService;

import static play.mvc.Http.Context.Implicit.request;
import static play.mvc.Results.*;

public class CalculateController {

    public Result index() {
        return ok("Test test");
    }

    public Result calculate() {
        JsonNode requestBody = request().body().asJson();
        String numberString = requestBody.get("number").asText();
        AlgorithmType t = AlgorithmType.CLASSIC;
        return ok(Json.toJson(CalculateService.calculate(numberString, t)));
    }

}
