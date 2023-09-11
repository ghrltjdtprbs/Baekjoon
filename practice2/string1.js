// 1) 모음 위치
// "When I find myself in times of trouble Mother Mary comes to me Speaking words of wisdom, let it be."
// 위 문자열에서 모음(aeiou)들의 위치를 출력하는 코드를 구현하시오.
let inputString = "When I find myself in times of trouble Mother Mary comes to me Speaking words of wisdom, let it be.";
let vowelMatches = inputString.match(/[aeiou]/gi);

if (vowelMatches) {
  for (const vowel of vowelMatches) {
    const vowelIndex = inputString.indexOf(vowel);
    console.log(`모음 "${vowel}"의 위치: ${vowelIndex}`);
  }
} else {
  console.log("문자열에서 모음을 찾을 수 없습니다.");
}

// 2) 공백 제거
// 위 문제의 문자열에서 공백을 모두 제거한 새 문자열을 만들고,
// 그 문자열을 출력하시오.
let inputString1 = "When I find myself in times of trouble Mother Mary comes to me Speaking words of wisdom, let it be.";
let stringWithoutSpaces = inputString1.replace(/\s+/g, "");
console.log(stringWithoutSpaces);

// 3) 쪼개기
// 위 문제의 문자열에서 공백을 기준으로 문자열을 쪼개서, 문자열 배열을 만들고,
// 그 배열을 출력하시오.
let inputString2 = "When I find myself in times of trouble Mother Mary comes to me Speaking words of wisdom, let it be.";
let a = inputString2.split(" ");
for (let i = 0; i < a.length; ++i) 
console.log(a[i]);

// 4) 경로명
// let a = ["c:/temp/guide.hwp", "c:/pj/frontend/chap05/substring1.js", "homework.docx"]
// a 배열의 경로명들 각각에 대해서,
// 아래 부분들을 추출해서 출력하는 코드를 구현하시오.

let a1 = ["c:/temp/guide.hwp", "c:/pj/frontend/chap05/substring1.js", "homework.docx"];

// 파일 확장자 출력하기
for (let path of a1) {
  const extension = path.split('.').pop(); // 파일 확장자 추출
  console.log(`파일 확장자: .${extension}`);
}

// 파일명 출력하기
for (let path of a1) {
  const fileName = path.split('/').pop(); // 파일명 추출
  console.log(`파일명: ${fileName}`);
}

// 파일 이름 부분만 출력하기
for (let path of a1) {
  const fileName = path.split('/').pop(); // 파일명 추출
  const nameWithoutExtension = fileName.split('.').shift(); // 파일 이름 부분 추출
  console.log(`파일 이름 부분: ${nameWithoutExtension}`);
}
