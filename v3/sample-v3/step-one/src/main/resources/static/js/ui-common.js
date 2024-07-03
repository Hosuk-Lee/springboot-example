/*!
    * Copyright hosuk.lee
    * ui common
    */
    //
// Scripts
//

function fnMenuSelector(path, el){
    console.log(path,el);
    console.log(axios);
    axios.get(path)
      .then(function (response) {
        // 성공 핸들링
        console.log(response);
        var element = document.getElementById("main_content");
        console.log(element);
        var contents = removeScriptTags(response.data);
        var scriptContents = removeScriptContent(response.data);
        console.log('debug',contents, scriptContents);

        var script = document.createElement("script");
        text = document.createTextNode(scriptContents);
        script.appendChild(text);

//        element.innerHTML = response.data;
        element.innerHTML = contents;
        element.appendChild(script);
      })
      .catch(function (error) {
        // 에러 핸들링
        console.log(error);
      })
      .finally(function () {
        // 항상 실행되는 영역
      });
}

function removeScriptContent(htmlContent) {
  const regex = /<script[^>]*>([\s\S]*?)<\/script>/g;
  const matches = htmlContent.match(regex);

  const scriptContents = [];
  if (matches) {
    for (const match of matches) {
      // 태그를 제거하고 내용만 추출합니다.
      const content = match.replace(/<script[^>]*>|\<\/script\>/g, '');
      scriptContents.push(content);
    }
  }
  return scriptContents;
}

function removeScriptTags(htmlContent) {
  // 정규 표현식을 사용하여 `<script>` 태그를 찾아 제거합니다.
  const regex = /<script[^>]*>([\s\S]*?)<\/script>/g;
  const cleanedHTML = htmlContent.replace(regex, '');
  return cleanedHTML;
}
//  var htmlString = '<p>안녕하세요!</p> <script'
//  htmlString = htmlString + '>alert("XSS 공격!");</'
//  htmlString = htmlString + 'script>';
//  const cleanedHTML = removeScriptTags(htmlString);
//  console.log(cleanedHTML);  // 출력: <p>안녕하세요!</p>
