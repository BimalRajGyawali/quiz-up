import React, {useEffect} from "react";
import axios from 'axios';
import { useLocation, useParams } from "react-router-dom";
import QuizQuestion from "../QuizQuestion";
import Timer from "../Timer";
import { Button } from "antd";


const fixed = {
    position:"fixed",
    top:"40%",
    left:"86%"
}


const TakeQuiz = () => {
    const {id} = useParams();
    const {state:quiz} = useLocation();

    const [questions, setQuestions] = React.useState([]);
    const [solutions, setSolutions] = React.useState([]);
    const [distributionId, setDistributionId] = React.useState("");
  
      useEffect(() => {
        axios.get(`http://localhost:8080/quizzes/${id}`)
        .then(res => {
          console.log("Getting data");
          console.log(res.data);
          setQuestions(res.data.quizData.questions);
          setDistributionId(res.data.distributionId);
        })
        .catch(err => console.log("Error", err))
      }, []);

      const updateSolution = ({questionId, optionChosen}) => {
        let alreadyExists = false;
         let copy = [...solutions];

        for(let c of copy){
            if(c.questionId === questionId){
              c.optionChosen = optionChosen;
              alreadyExists = true;
            }

        }
        if(!alreadyExists){
          copy.push({questionId, optionChosen})
        }

          setSolutions(copy);
      }

      const submitQuiz = () => {
        console.log("Submitting quiz....");
        const submission = {
          distributionId,
          quizId : id,
          solutions
        }
        console.log(submission);

        axios
        .post("http://localhost:8080/submissions/",submission )
        .then((response) => console.log(response.data.id))
        .catch((err) => console.log(err));
  
      }

    return (
        <div>
            <div style={{ width: "60%", margin:"40px auto"}}>
            <div>
            <p>{quiz.title}</p>
            <p>Duration : {quiz.durationInMinute} mins</p>
            </div>
        {
        questions.map((question, index) => 
        <QuizQuestion key={index} question={question} index={index+1} updateSolution={updateSolution}/>
        
        )
        }
        
        <Button style={{marginTop:"30px"}} type="primary" onClick={submitQuiz}>Submit</Button>
        <div style={{height:"30px"}}></div>
        </div>

        <div style={fixed}>
            <Timer limit={quiz.durationInMinute} handleTimeOut={submitQuiz}/>
        
        </div>


        </div>
    
    )

}

export default TakeQuiz;