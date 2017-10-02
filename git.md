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


## 오류
<pre>
<code>
- ####  ! [rejected]        master -> master (non-fast forward) // 원격저장소로 push했을 때 간혹 이런 오류 발생
  - 원격저장소에 있는 코드와 로컬저장소에 있는 코드의 버전이 맞지 않아서 발생
  - 원격저장소에 있는 코드를 pull 받아와서 로컬저장소에 있는 코드를 갱신시킨 뒤 push 해야함
   - `git pull origin<원격저장소 연결할 당시 생성한 url이름> 브랜치이름` // 로컬 저장소 코드 갱신
   - `git push origin 브랜치이름` // 코드를 갱신한 뒤 push 하면 정상적으로 push 된다.
</pre>


## 명령어
- #### 원격저장소에서 내려받기
  - `git clone 내려받을곳의주소`

- #### 연결 되어 있는 원격저장소 확인
  - `git remote -v`

- #### 연결 되어 있는 원격저장소 삭제
  - `git remote rm 원격저장소이름(ex:origin)`

- #### 브랜치목록
  - `git branch -r` 원격 저장소에 있는 브랜치 목록(r=remote)
  - `git branch -a` 로컬 저장소에 있는 브랜치 목록

- #### 브랜치 삭제
  - `git branch -d 브랜치이름` 로컬 저장소에 있는 브랜치 삭제 ( -D 강제삭제)
  - `git push origin --delete 브랜치 이름` 원격 저장소에 있는 브랜치 삭제

- #### 브랜치 이름 변경
  - `git branch -m 기존브랜치이름 새로운브랜치이름`

- #### 원격 저장소에 있는 브랜치 받기
  - `git branch -b 로컬에새로만들브랜치이름 origin(리모트할때생성한url이름)/원격저장소에있는브랜치이름`

- #### 원격 저장소에 있는 브랜치 받기(원격 저장소 브랜치 이름과 동일하게 생성)
  - `git branch -t origin(리모트할때생성한url이름)/원격저장소에있는브랜치이름`

- #### 추가 된 이력 조회
  - `git log --all`

- #### 현재 코드 상태 & 어떤 파일이 수정 되어 있는지
  - `git status`
