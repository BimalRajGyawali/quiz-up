import React, { useState } from "react";
import { Card, Radio } from "antd";

const QuizAnswerDetail = ({ question, index, optionChosen }) => {
  const options = {
    a: 1,
    b: 2,
    c: 3,
    d: 4,
  };

  const getCorrectAnswer = (question) => {
      console.log(question);

    switch (question.correctOption) {
      case "a":
        return question.option1;

      case "b":
        return question.option2;

      case "c":
        return question.option3;

      case "d":
        return question.option4;
    }
  };

  return (
    <Card style={{ marginTop: "20px" }}>
      <p>
        {index}. {question.title}
      </p>
      <p style={{ float: "right", position: "relative", top: "-35px" }}>
        {question.correctOption === optionChosen ? (
          <p style={{ color: "green" }}>{question.weight} points</p>
        ) : (
          <p style={{ color: "red" }}> 0 points</p>
        )}
      </p>

      <Radio.Group value={options[optionChosen]}>
        <p>
          <Radio  value={1}>{question.option1}</Radio>
        </p>
        <div style={{ height: "10px" }}></div>
        <p>
          <Radio value={2}>{question.option2}</Radio>
        </p>
        <div style={{ height: "10px" }}></div>
        <p>
          <Radio value={3}>{question.option3}</Radio>
        </p>
        <div style={{ height: "10px" }}></div>
        <p>
          <Radio value={4}>{question.option4}</Radio>
        </p>
        <div style={{ height: "10px" }}></div>
      </Radio.Group>

      <p>Correct answer : {getCorrectAnswer(question)}</p>
    </Card>
  );
};

export default QuizAnswerDetail;
