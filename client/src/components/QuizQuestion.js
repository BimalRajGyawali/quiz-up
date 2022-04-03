import React, {useState} from "react";
import { Card, Radio } from "antd";

const QuizQuestion = ({ question, index, initialValue, updateSolution }) => {
    const [value, setValue] = useState(initialValue || 0);

    const options = {
      1 : "a",  
      2 : "b",
      3 : "c",
      4 : "d"
    }

    const onChange = (id, e) => {
        if(!updateSolution) return;
        setValue(e.target.value);
        const solution = {questionId : id, optionChosen : options[e.target.value]};
        console.log(solution);
        updateSolution(solution)
      };

  return (
    <Card style={{marginTop: "20px"}}>
      <p >{index}. {question.title}</p>

      <p style={{float:"right", position:"relative", top:"-35px"}}>{question.weight} points</p>
  
      <Radio.Group onChange={(e) => onChange(question.id, e)} value={value}>
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
