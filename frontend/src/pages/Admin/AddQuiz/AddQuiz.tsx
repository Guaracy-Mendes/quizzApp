import QuizForm from "../../../components/QuizForm/QuizForm";
import PageTitle from "../../../components/PageTitle/PageTitle";
import { CREATE_QUIZ_PAGE_TITLE } from "../../../constants/Constants";
import { Quiz } from "../../../models/Quiz";
import { useNavigate } from "react-router-dom";
import HttpClient from "../../../services/HttpClient";
import ToastService from "../../../services/ToastService";

const AddQuiz = () => {

    const navigate = useNavigate();

    const handleSubmit = (quiz: Quiz) => {
        HttpClient.post('/quizzes', quiz).then(() => {
            ToastService.success('Quiz added successfully');
            navigate('/admin/quiz');
        });
    }

    return (
        <>
            <PageTitle value={CREATE_QUIZ_PAGE_TITLE} />
            <QuizForm onSubmit={handleSubmit} />
        </>
    );
};

export default AddQuiz;