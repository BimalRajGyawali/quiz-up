import 'antd/dist/antd.css';
import { useState } from 'react';
import { Form, Input, Button, Space } from 'antd';
import { MinusCircleOutlined, PlusOutlined } from '@ant-design/icons';
import { Typography } from 'antd';
import axios from 'axios';

const { Title } = Typography;


const QuizCreationForm = () => {

  const [title, setTitle] = useState('');

  const onFinish = values => {
   const quiz = {
        title,
        fullMarks: 50,
        passMarks: 20,
      ...values
   }
    console.log(`Posting ${JSON.stringify(quiz, null, 2)} `);

    axios.post('http://localhost:8080/quizzes/', quiz)
    .then(response => console.log(response.data.id))
    .catch(err => console.log(err))

  };

  const handleTitleChange = (event) =>{
      setTitle(event.target.value);
  }

  return (
    <div style={{width:'60%', margin:'0px auto'}}>

    <Title level={2}>Create a Quiz</Title>

    <Title level={4}>Title</Title> 
    <Input placeholder="Quiz Title" style={{marginBottom:'40px'}} value={title} 
    onChange={handleTitleChange}/>

    <Title level={4}>Add questions</Title>



    <Form name="dynamic_form_nest_item" onFinish={onFinish} autoComplete="off">
      <Form.List name="questions">
        {(fields, { add, remove }) => (
          <>
            {fields.map(({ key, name, ...restField }) => (
              <>

                <Form.Item
                  {...restField}
                  name={[name, 'title']}
                  rules={[{ required: true, message: 'Missing Question' }]}
                >
                  <Input placeholder="Question" />
                </Form.Item>

                <Space key={key} style={{ display: 'flex', marginBottom: 8 }} align="baseline">

                <Form.Item
                  {...restField}
                  name={[name, 'option1']}
                  rules={[{ required: true, message: 'Missing option 1' }]}
                >
                  <Input placeholder="Option1" />
                </Form.Item>

                <Form.Item
                  {...restField}
                  name={[name, 'option2']}
                  rules={[{ required: true, message: 'Missing option 2' }]}
                >
                  <Input placeholder="Option2" />
                </Form.Item>

                <Form.Item
                  {...restField}
                  name={[name, 'option3']}
                  rules={[{ required: true, message: 'Missing option 3' }]}
                >
                  <Input placeholder="Option3" />
                </Form.Item>

                <Form.Item
                  {...restField}
                  name={[name, 'option4']}
                  rules={[{ required: true, message: 'Missing option 4' }]}
                >
                  <Input placeholder="Option4" />
                </Form.Item>

                <Form.Item
                  {...restField}
                  name={[name, 'rightOption']}
                  rules={[{ required: true, message: 'Missing right option' }]}
                >
                  <Input placeholder="Right Option" />
                </Form.Item>

                <Form.Item
                  {...restField}
                  name={[name, 'weight']}
                  rules={[{ required: true, message: 'Missing weight' }]}
                >
                  <Input placeholder="Weight" />
                </Form.Item>

                <MinusCircleOutlined onClick={() => remove(name)}/>

                </Space>
              </>
            
            ))}
            <Form.Item>
              <Button type="dashed" onClick={() => add()} block icon={<PlusOutlined />}>
                Add Question
              </Button>
            </Form.Item>
          </>
        )}
      </Form.List>
      <Form.Item>
        <Button type="primary" htmlType="submit">
          Submit
        </Button>
      </Form.Item>
    </Form>
    </div>
  
  );
};

export default QuizCreationForm;