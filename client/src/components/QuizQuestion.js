import React, {useState} from "react";
import { Card, Radio } from "antd";

const QuizQuestion = ({ question, index }) => {
    const [value, setValue] = useState(0);

    const onChange = e => {
        setValue(e.target.value);
      };

  return (
    <Card style={{marginTop: "20px"}}>
      <p>{index}. {question.title}</p>

      <Radio.Group onChange={onChange} value={value}>
      <p><Radio value={1}>{question.option1}</Radio></p>
      <div style={{height:"10px"}}></div>
     <p><Radio value={2}>{question.option2}</Radio></p>
     <div style={{height:"10px"}}></div>
     <p> <Radio value={3}>{question.option3}</Radio></p>
     <div style={{height:"10px"}}></div>
      <p><Radio value={4}>{question.option4}</Radio></p>
      <div style={{height:"10px"}}></div>
    </Radio.Group>
    </Card>
  );
};

export default QuizQuestion;
