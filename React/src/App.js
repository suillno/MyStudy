import React, { useState } from "react";

/**
 * 해더를 따로 function으로 지정 파라미터 값을 h1에 대입
 * props 값을받아 hearder에 설정한 title 값을 출력
 * Object Destructuring : 구조분해
 * click 이벤트시 function 가져오기
 */
function Header({ title, logintext, onChangeMode }) {
  console.log(title);
  return (
    <header>
      <h1>
        <button
          type="button"
          onClick={function (e) {
            e.preventDefault();
            onChangeMode();
          }}
        >
          {title}
        </button>
        <br></br>
        <a href="">{logintext}</a>
      </h1>
    </header>
  );
}

/**
 * 배열을 값으로 넣기
 */
const navList = [
  { id: 1, title: "html", link: "/html" },
  { id: 2, title: "css", link: "/css" },
  { id: 3, title: "js", link: "/js" },
];

/**
 * 배열을 루프를돌아 값을 넣기
 * key 랜더링 최적화하기위해 지정(유일해야함)
 * @param {*} param0
 * @returns
 */
function Nav({ navList, onChangeMode }) {
  console.log(navList);
  return (
    <nav>
      <ol>
        {navList.map((item) => (
          <li key={item.id}>
            <button
              type="button"
              onClick={(e) => {
                e.preventDefault();
                onChangeMode(item.id);
              }}
            >
              {item.title}
            </button>
          </li>
        ))}
      </ol>
    </nav>
  );
}

function Article({ title, body }) {
  return (
    <article>
      <h2>{title}</h2>
      <p>{body}</p>
    </article>
  );
}

function App() {
  // useState는 배열로 리턴되는데
  // 0번째는 값을 읽는 용도로 사용한다.
  // 1번째는 값을 쓰는 용도로 사용한다.
  const [mode, setMode] = useState("WELCOME");
  console.log(mode);
  const [id, setId] = useState(null);

  let content = null;

  if (mode === "WELCOME") {
    content = <Article title="WELCOME" body="Hello, Web" />;
  } else if (mode === "READ") {
    const selected = navList.find((item) => item.id === id); // ✅ 해당 항목 찾기
    if (selected) {
      content = <Article title={selected.title} body={selected.link} />;
    }
  }

  /**
   * return : 하나의 값만 리턴할수 있음 따라서 여러개의 요소를 하나의 그룹으로 묶어야함
   * <></> 프라그먼트 :  여러 요소를 그룹화할 수 있게 해주는 기능입니다.
   * <React.Fragment>와 동일 다만 react 임포트 구문이 필요함
   */
  return (
    // 프라그먼트
    // state
    <React.Fragment>
      {/* html에서 function 불러오기 */}
      <Header
        title="제목"
        logintext="로그인"
        onChangeMode={function () {
          setMode("WELCOME");
        }}
      />
      <Nav
        navList={navList}
        onChangeMode={(id, link) => {
          setMode("READ");
          setId(id);
        }}
      />
      {content}
    </React.Fragment>
  );
}

export default App;
