import {MailOutlined} from '@ant-design/icons';
import {Menu} from 'antd';
import React from 'react';
import {Link} from 'react-router-dom';
import {hero, menuItem, nav, navbar} from './Navbar.style';

class Navbar extends React.Component {

  state = {
    current: 'home',
  };

  handleClick = e => {
    console.log('click ', e);
    this.setState({ current: e.key });
  };

  render() {
    const { current } = this.state;
    return (
        <nav style={navbar}>
        
        <p style={hero}>

          <Link style={{color: "black"}} to="/" >Quiz Up</Link>

          </p>
      <Menu onClick={this.handleClick} selectedKeys={[current]} mode="horizontal" style={nav}>
        <Menu.Item key="home" icon={<MailOutlined />} style={menuItem}>
         <Link to="/">Quizzes</Link>
        </Menu.Item>
        <Menu.Item key="create" icon={<MailOutlined />} style={menuItem}>
         <Link to="/create">Create Quiz</Link>
        </Menu.Item>
      </Menu>
      </nav>
    );
  }
}


export default Navbar;