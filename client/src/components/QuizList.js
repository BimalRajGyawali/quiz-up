import { Card } from 'antd';

const QuizList = () => {
  return (
    <div  style={{ display: "flex" }}>
      <Card
        title="Card title"
        bordered={false}
        style={{ width: 300, margin: "2px" }}
      >
        <p>Card content</p>
        <p>Card content</p>
        <p>Card content</p>
      </Card>

      <Card title="Card title" bordered={false} style={{ width: 300 }}>
        <p>Card content</p>
        <p>Card content</p>
        <p>Card content</p>
      </Card>
    </div>
  );
};

export default QuizList;