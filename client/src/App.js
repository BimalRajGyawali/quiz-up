import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import Home from "./components/pages/Home";
import QuizCreationForm from "./components/pages/QuizCreationForm";
import SubmissionDetail from "./components/pages/SubmissionDetail";
import TakeQuiz from "./components/pages/TakeQuiz";
import QuizCardList from "./components/QuizCardList";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />}>
            <Route path="" element={<QuizCardList />} />
            <Route path="create" element={<QuizCreationForm />} />
            <Route path="quiz/:id" element={<TakeQuiz />}/>
            <Route path="submission-detail/:id" element={<SubmissionDetail />} />
        </Route>

      </Routes>
    </BrowserRouter>
  );
}

export default App;
