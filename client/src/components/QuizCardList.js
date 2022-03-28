import React, {useEffect} from "react";
import axios from 'axios';

import QuizCard from "./QuizCard";

const quizCardList = {
    background: "#f2f2f2",
    display: "flex",
    flexWrap: "wrap",
    padding:50
}

const QuizCardList = () => {

    const [quizzes, setQuizzes] = React.useState([]);
  
      useEffect(() => {
        axios.get("http://localhost:8080/quizzes/")
        .then(res => {
          console.log("Getting data");
          console.log(res.data[0]);
          setQuizzes(res.data)
        })
        .catch(err => console.log("Error", err))
      }, []);



    return (
        <div style={quizCardList}>
            {quizzes.map(quiz => <QuizCard quiz={quiz} key={quiz.id}/>)}
        </div>
    )

}

export default QuizCardList;