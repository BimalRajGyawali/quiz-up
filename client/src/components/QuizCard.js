import React from "react";
import { Card, Button } from "antd";

import "antd/dist/antd.css";
import { Link, useNavigate } from "react-router-dom";

const quizCard = {
  marginLeft: 20,
  marginTop: 20,
};

const QuizCard = ({ quiz }) => {
  const navigate = useNavigate();

  const handleTakeQuiz = () => {
    navigate(`/quiz/${quiz.id}`, { state: quiz });
  };

  return (
    <div className="site-card-border-less-wrapper" style={quizCard}>
      <Card title={quiz.title} bordered={false} style={{ width: 300 }}>
        <p>Duration : {quiz.durationInMinute} mins</p>
        <p>Max Attempt : {quiz.maxAttempt} </p>

        <div style={{ marginTop: 30 }}>
          <Button style={{ marginRight: 30 }}>View</Button>
          <Button type="primary" onClick={handleTakeQuiz}>
            Take Quiz
          </Button>
        </div>
      </Card>
    </div>
  );
};

export default QuizCard;
