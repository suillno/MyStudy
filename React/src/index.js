import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";
import reportWebVitals from "./reportWebVitals";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals

/**
 * 웹바이탈 : 구글에서 정의한 사용자 경험 측정지표
 * 핵심 요소의 성능을 측정한다.
 * LCP (Largest Contentful Paint) : 페이지에서 가장큰 콘텐츠가 로딩되는데 걸린 시간 (2500ms 이하 추천)
 * FID (First Input Delay) : 사용자가 페이지에서 처음으로 상호작용을 할때까지 지연 시간 (100ms 이하 추천)
 * CLS (Cumulatvie layout Shift) : 페이지 레이아웃이 얼마나 안정적으로 유지 되는가? 화면 요소가 예기치 않게 이동하는 정도 (0.1이하)
 * TTFB (Time to First Byte) : 서버가 최초 응답을 보내기까지 걸린 시간 (참고용)
 * () 안에 console.log 추가시 동작
 */
reportWebVitals();
