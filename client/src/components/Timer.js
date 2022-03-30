import React, { useEffect, useState } from "react";

const Timer = ({ limit , handleTimeOut}) => {
  const [minute, setMinute] = useState(limit-1);
  const [second, setSecond] = useState(60);
  const [timeUp, setTimeUp] = useState(false);

  useEffect(() => {
    const interval = setInterval(() => {
      let sec = second - 1;
      if(sec <= 0){
          const min = minute - 1;
          if(min <= 0){ 
            setTimeUp(true);
            handleTimeOut();
            clearInterval(interval);
            return ;
          }
          setMinute(min);
          
          sec = 60;
      }
      setSecond(sec);
    }, 10);

    return () => {
      clearInterval(interval);
    };
  }, [second, minute]);

  return (
    <h2>
      {timeUp ? <p style={{color:"red"}}>Time's up</p> :  `${minute} min : ${second} sec` }
     
    </h2>
  );
};

export default Timer;
