<script setup></script>

<template>
  <section class="quiz-instructions">
    <h4>퀴즈 앱 사용 방법</h4>
    <div class="content-block">
      <h3>1. 퀴즈 목록 확인하기</h3>
      <p>퀴즈 목록 페이지에서 다양한 퀴즈를 확인하세요.</p>
      <div class="quiz-question">
        <h5>
          5번 문제. 웹 애플리케이션을 개발할 때, 사용자의 브라우저에 보여지는 부분을 랜더링하는
          언어는 무엇인가요?
        </h5>
        <label for="p5">정답 입력</label>
        <input type="text" id="p5" />
      </div>

      <div class="quiz-question">
        <h5>
          4번 문제. Python의 가상 환경을 만들어 프로젝트 별로 라이브러리 의존성을 격리시키는
          명령어는?
        </h5>
        <label for="p4">정답 입력</label>
        <input type="text" id="p4" />
      </div>

      <div class="quiz-question">
        <h5>
          3번 문제. 웹 애플리케이션에서 클라이언트의 데이터를 서버로 전송할 때 주로 사용되는 HTTP
          메서드는?
        </h5>
        <label for="p3">정답 입력</label>
        <input type="text" id="p3" />
      </div>

      <div class="quiz-question">
        <h5>2번 문제. HTML에서 텍스트 입력란을 만드는 데 사용되는 요소는?</h5>
        <label for="p2">정답 입력</label>
        <input type="text" id="p2" />
      </div>
    </div>
    <div class="content-block">
      <h3>2. 퀴즈 생성하기</h3>
      <p>퀴즈는 직접 생성 할 수도 있어요.</p>
      <div class="quiz-question">
        <h5>퀴즈 생성</h5>
        <label for="problem">문제</label>
        <input type="text" id="problem" />
        <label for="answer">답안</label>
        <input type="text" id="answer" />
        <button type="button" class="btn btn-primary">퀴즈 생성</button>
      </div>
    </div>
    <div class="content-block">
      <h3>3. 정답 페이지</h3>
      <p>작성한 답안이 정답인지 확인하세요</p>
      <div class="quiz-question">
        <h5>정답 확인</h5>
        <div>
          <span>정답입니다!</span>
          <span>나의 제출 답안: html</span>
          <span>정답: html</span>
        </div>
      </div>
    </div>
  </section>
</template>

<style scoped>
.quiz-instructions h4,
.content-block h3 {
  color: #333;
  margin-top: 20px;
}

.content-block {
  border-top: 2px solid #ccc;
  padding-top: 20px;
}

.quiz-question {
  margin-top: 20px;
}

.quiz-question h5 {
  margin-bottom: 5px;
}

.quiz-question label {
  margin-right: 10px;
}

.quiz-question input[type="text"] {
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
}
</style>
