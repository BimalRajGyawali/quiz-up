import axios from "axios";
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import QuizAnswerDetail from "../../QuizAnswerDetail";

const SubmissionDetail = () => {
  const [submissionDetail, setSubmissionDetail] = useState({});
  const { id } = useParams();

  useEffect(() => {
    axios
      .get(`http://localhost:8080/submissions/${id}`)
      .then((res) => {
        console.log(res.data);
        setSubmissionDetail(res.data);
      })
      .catch((err) => console.log("Error", err));
  }, []);

  return (
    <div style={{ width: "60%", margin: "40px auto" }}>
      <div>
        <p>{submissionDetail.quizTitle}</p>
        <p>FullMarks : {submissionDetail.fullMarks}</p>
        <p >Your grade : <span style={{fontWeight: "bold"}}>{submissionDetail.grade}</span></p>
      </div>

        {submissionDetail.answers && submissionDetail.answers.map((answer, index) => (
          <QuizAnswerDetail
            key={index}
            question={answer.questionData}
            index={index + 1}
            optionChosen = {answer.optionChosen}
          />
        ))}

      <div style={{ height: "30px" }}></div>

    </div>
  );
};

export default SubmissionDetail;
