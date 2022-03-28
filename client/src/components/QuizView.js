import React, { useEffect } from 'react';
import 'antd/dist/antd.css';
import axios from 'axios';
import Question from './Question';

const QuizView = () => {
    const [quiz, setQuiz] = React.useState({});
  
      useEffect(() => {
        axios.get("http://localhost:8080/quizzes/7c2f63c6-ce15-4c5f-95a1-eb1a289da59a")
        .then(res => {
          console.log("Getting data");
          console.log(`Quiz ${res.data}`);
          setQuiz(res.data)
        })
        .catch(err => console.log("Error"))
      }, []);
    
    
      return (
        <>
        <p>{quiz.title}</p>
        <p>
          <span>Fullmarks : {quiz.fullMarks}</span>
          <span style={{marginLeft: '30px'}}>Passmarks : {quiz.passMarks}</span>
        </p>
        
        {
          quiz.questions?.map((que, index) => <Question que={que} i={index+1} key={index}/>)
        }

        </>
      );

}

export default QuizView;