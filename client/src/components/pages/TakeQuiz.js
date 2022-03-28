import React, {useEffect} from "react";
import axios from 'axios';
import { useLocation, useParams } from "react-router-dom";
import QuizQuestion from "../QuizQuestion";
import Timer from "../Timer";


const fixed = {
    position:"fixed",
    top:"40%",
    left:"86%"
}


const TakeQuiz = () => {
    const {id} = useParams();
    const {state:quiz} = useLocation();

    const [questions, setQuestions] = React.useState([]);
  
      useEffect(() => {
        axios.get(`http://localhost:8080/quizzes/${id}`)
        .then(res => {
          console.log("Getting data");
          console.log(`Quiz ${res.data}`);
          setQuestions(res.data.questions)
        })
        .catch(err => console.log("Error", err))
      }, []);


    return (
        <div>
            <div style={{ width: "60%", margin:"40px auto"}}>
            <div>
            <p>{quiz.title}</p>
            <p>Duration : {quiz.durationInMinute} mins</p>
            </div>
        {questions.map((question, index) => <QuizQuestion key={index} question={question} index={index+1}/>)}
        <div style={{height:"30px"}}></div>
        </div>

        <div style={fixed}>
            <Timer limit={quiz.durationInMinute} handleTimeOut={() => console.log("Time's up submitting")}/>
        
        </div>


        </div>
    
    )

}

export default TakeQuiz;