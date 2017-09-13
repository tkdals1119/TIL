# Git 명령어 모음
## 가장 기본이 되는 순서

<pre>
<code>
git init // 해당 폴더에서 git 을 사용할 준비를 한다는 뜻
git remote add origin 주소 // 원격 저장소와 연결 ( 이름을 꼭 origin 으로 안해도 됌)
git checkout -b 브랜치이름 // 브랜치를 생성하고 위치도 그 브랜치로 이동
git push origin 브랜치이름 // 생성한 브랜치를 원격저장소에도 push 한다

> 파일 수정 후
git add . // 수정 된 파일 뿐만 아니라 모든 파일을 포함 (.점이 그 표시)
git commit -m "Message" // 커밋메세지와 함께 커밋
git push origin branch(혹은 마스터) // 원격저장소에 push 할 위치를 정하고 push
</code>
</pre>
