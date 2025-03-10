import React, {useEffect, useState} from 'react';



const Ex = () => {

    const [count, setCount] = useState(0);
    const [isOnline, setIsOnline] =  useState(null);
    const [fruits, setFruits] = useState('banana');
    const [todos, setTodos] = useState([{text: 'Learn Hooks'}]);

    const [post,setPost] = useState(null);


    function  handleStatusChange(status) {
        setIsOnline(status.isInline);
    }

    useEffect(()=>{
       document.title = `your Clicked ${count} times`;

    });
    useEffect(() => {
        fetch('https://jsonplaceholder.typicode.com/posts/1')
            .then((respone)=>respone.json())
            .then((data)=>{
               setPost(data);
            })
            .catch((error) => {
                console.error('API 요청 실패:', error);
            });
    }, []);

    return (
        <div>
            <p>Click!! {count} times~~</p>
            <button onClick={()=> setCount(count + 1)}>
                Click!!!!
            </button>
            <p>I wanna eat {fruits}</p>
            {/*setFuits(fruits);*/}
            <div>
                <h2>API 호출 결과:</h2>
                {post ? (
                    <div>
                        <p>제목: {post.title}</p>
                        <p>내용: {post.body}</p>
                    </div>
                ) : (
                    <p>Loading...</p>
                )}
            </div>
        </div>
    );
};

export default Ex;