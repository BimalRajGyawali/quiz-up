import { Radio } from "antd";
import React from "react";

const Question = ({ que, i }) => {
  const [value, setValue] = React.useState(1);

  const onChange = (e) => {
    console.log("radio checked", e.target.value);
    setValue(e.target.value);
  };

  return (
    <div style={{marginBottom:'30px'}}>
      <p>
        <span>{i}.</span>
        <span style={{marginLeft: '10px'}}>{que.title}</span>
      </p>
      <p>
        <Radio.Group onChange={onChange} value={value}>
          <Radio value={1}>{que.option1}</Radio>
          <Radio value={2}>{que.option2}</Radio>
          <Radio value={3}>{que.option3}</Radio>
          <Radio value={4}>{que.option4}</Radio>
        </Radio.Group>
      </p>
    </div>
  );
};

export default Question;
