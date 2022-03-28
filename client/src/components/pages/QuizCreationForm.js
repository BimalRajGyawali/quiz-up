import "antd/dist/antd.css";
import { useState, useRef } from "react";
import { Form, Input, Button, Space } from "antd";
import { MinusCircleOutlined, PlusOutlined } from "@ant-design/icons";
import { Typography } from "antd";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const { Title } = Typography;

const QuizCreationForm = () => {
  const [title, setTitle] = useState("");
  const [durationInMinute, setDurationInMinute] = useState(0);
  const [maxAttempt, setMaxAttempt] = useState(0);
  const [draft, setDraft] = useState(false);

  const publishButton = useRef(null);
  const navigate = useNavigate();

  const postQuiz = (quiz) => {
    const URL = draft
      ? "http://localhost:8080/quizzes/draft"
      : "http://localhost:8080/quizzes/publish";

    console.log(`Posting ${JSON.stringify(quiz, null, 2)} draft = ${draft}`);

    axios
      .post(URL, quiz)
      .then((response) => console.log(response.data.id))
      .catch((err) => console.log(err));

    setDraft(false);
  };

  const onFinish = (values) => {
    const quiz = {
      title,
      durationInMinute,
      maxAttempt,
      ...values,
    };
    postQuiz(quiz);

    navigate("/");
  };

  const draftQuiz = () => {
    setDraft(true);
    publishButton.current.click();
  };

  const handleTitleChange = (event) => {
    setTitle(event.target.value);
  };

  const handleDurationInMinutesChange = (event) => {
    setDurationInMinute(event.target.value);
  };

  const handleMaxAttemptChange = (event) => {
    setMaxAttempt(event.target.value);
  };

  return (
    <div style={{ width: "60%", margin: "20px auto" }}>
      <Title level={3} style={{ marginBottom: "30px" }}>
        Create a Quiz
      </Title>

      <Input
        placeholder="Quiz Title"
        style={{ marginBottom: "40px" }}
        onChange={handleTitleChange}
      />

      <div style={{ display: "flex", flexWrap: "wrap" }}>
        <Input
          placeholder="Duration in minutes"
          style={{ marginBottom: "40px", width: "45%", marginRight: "10%" }}
          onChange={handleDurationInMinutesChange}
          type="number"
        />

        <Input
          placeholder="Max Attempt"
          style={{ marginBottom: "40px", width: "45%" }}
          onChange={handleMaxAttemptChange}
          type="number"
        />
      </div>

      <Form
        name="dynamic_form_nest_item"
        onFinish={onFinish}
        autoComplete="off"
      >
        <Form.List name="questions">
          {(fields, { add, remove }) => (
            <>
              {fields.map(({ key, name, ...restField }) => (
                <>
                  <Form.Item
                    {...restField}
                    name={[name, "title"]}
                    rules={[{ required: true, message: "Missing Question" }]}
                  >
                    <Input placeholder="Question" />
                  </Form.Item>

                  <Space
                    key={key}
                    style={{ display: "flex", marginBottom: 8 }}
                    align="baseline"
                  >
                    <Form.Item
                      {...restField}
                      name={[name, "option1"]}
                      rules={[{ required: true, message: "Missing option 1" }]}
                    >
                      <Input placeholder="Option1" />
                    </Form.Item>

                    <Form.Item
                      {...restField}
                      name={[name, "option2"]}
                      rules={[{ required: true, message: "Missing option 2" }]}
                    >
                      <Input placeholder="Option2" />
                    </Form.Item>

                    <Form.Item
                      {...restField}
                      name={[name, "option3"]}
                      rules={[{ required: true, message: "Missing option 3" }]}
                    >
                      <Input placeholder="Option3" />
                    </Form.Item>

                    <Form.Item
                      {...restField}
                      name={[name, "option4"]}
                      rules={[{ required: true, message: "Missing option 4" }]}
                    >
                      <Input placeholder="Option4" />
                    </Form.Item>

                    <Form.Item
                      {...restField}
                      name={[name, "correctOption"]}
                      rules={[
                        { required: true, message: "Missing right option" },
                      ]}
                    >
                      <Input placeholder="Right Option" />
                    </Form.Item>

                    <Form.Item
                      {...restField}
                      name={[name, "weight"]}
                      rules={[{ required: true, message: "Missing weight" }]}
                    >
                      <Input placeholder="Weight" />
                    </Form.Item>

                    <MinusCircleOutlined onClick={() => remove(name)} />
                  </Space>
                </>
              ))}
              <Form.Item>
                <Button
                  type="dashed"
                  onClick={() => add()}
                  block
                  icon={<PlusOutlined />}
                >
                  Add Question
                </Button>
              </Form.Item>
            </>
          )}
        </Form.List>
        <Form.Item>
          <div style={{ marginTop: "40px" }}>
            <Button type="primary" htmlType="submit" ref={publishButton}>
              Publish
            </Button>

            <Button style={{ marginLeft: "30px" }} onClick={draftQuiz}>
              Save as Draft
            </Button>
          </div>
        </Form.Item>
      </Form>
    </div>
  );
};

export default QuizCreationForm;
