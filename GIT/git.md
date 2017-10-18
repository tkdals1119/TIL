# Git 명령어 모음
## 가장 기본이 되는 순서

```
>초기 설정
$ git init // 해당 폴더에서 git 을 사용할 준비를 한다는 뜻

$ git config --global user.email "you@example.com"
or
$ git config --global user.name "Your Name" // 초기에 bash에서 사용자 이메일 혹은 사용자 이름 지정

$ git remote add origin 주소 // 원격 저장소와 연결 ( 이름을 꼭 origin 으로 안해도 됨)
$ git checkout -b 브랜치이름 // 브랜치를 생성하고 위치도 그 브랜치로 이동
$ git push origin 브랜치이름 // 생성한 브랜치를 원격저장소에도 push 한다


> 파일 수정 후
$ git add . // 수정 된 파일 뿐만 아니라 모든 파일을 포함 (.점이 그 표시)
$ git commit -m "Message" // 커밋메세지와 함께 커밋
$ git push origin branch(혹은 마스터) // 원격저장소에 push 할 위치를 정하고 push


> 뭔가 변경될 떄마다 변경되는 사이클
 - pull -> commit -> push
```


## 오류
```
> ! [rejected]        master -> master (non-fast forward) // 원격저장소로 push했을 때 간혹 이런 오류 발생

  - 원격저장소에 있는 코드와 로컬저장소에 있는 코드의 버전이 맞지 않아서 발생
  - 원격저장소에 있는 코드를 pull 받아와서 로컬저장소에 있는 코드를 갱신시킨 뒤 push 해야함

  - $ `git pull origin<원격저장소 연결할 당시 생성한 url이름> 브랜치이름` // 로컬 저장소 코드 갱신
  - $ `git push origin 브랜치이름` // 코드를 갱신한 뒤 push 하면 정상적으로 push 된다.
```

```
$ git checkout -t origin/myprofile
> fatal: Cannot update paths and switch to branch 'myprofile' at the same time.
Did you intend to checkout 'origin/myprofile' which can not be resolved as commit ? // 원격저장소에 있는 'myprofile' 브랜치를 받으려고 할 때 오류 발생

  - $ git branch -r // 원격저장소에 있는 브랜치 목록을 확인했을 때 갱신이 안된 것을 확인할 수 있다.
  - $ git remote update // 원격저장소를 갱신시킨다.
  - $ git branch -r // 다시 원격저장소에 있는 브랜치 목록을 확인해보면 갱신이 된 것을 볼 수 있다.
  - $ git checkout -t origin/myprofile // 정상적으로 브랜치가 받아와지는 것을 볼 수 있다.
```
## TIP
```
> fetch 와 pull 의 차이
 - fetch는 원격저장소의 최신 이력을 확인할 수 있다
   - 현재 작업중인 소스들을 변경하는 merge 작업은 하지 않는다.

 - pull은 원격저장소의 내용을 가져와 자동으로 merge 작업을 한다.
    - pull = fetch + merge
```


## 명령어
- #### 원격저장소에서 내려받기
  - `git clone 내려받을곳의주소`

- #### 원격저장소로부터 업데이트 받고 push 하기
  - `git push -u 원격저장소이름(ex:origin) 원격저장소에있는브랜치이름`

- #### 연결 되어 있는 원격저장소 확인
  - `git remote -v`

- #### 연결 되어 있는 원격저장소 삭제
  - `git remote rm 원격저장소이름(ex:origin)`

- #### 브랜치목록
  - `git branch -r` 원격저장소에 있는 브랜치 목록(r=remote)
  - `git branch -a` 로컬저장소에 있는 브랜치 목록

- #### 브랜치 삭제
  - `git branch -d 브랜치이름` 로컬저장소에 있는 브랜치 삭제 ( -D 강제삭제)
  - `git push origin --delete 브랜치 이름` 원격저장소에 있는 브랜치 삭제

- #### 브랜치 이름 변경
  - `git branch -m 기존브랜치이름 새로운브랜치이름`
    - 원격저장소에 새 브랜치를 추가시키려면 위 명령어로 작업하던 브랜치의 이름을 바꾸고 push 하면 된다.

- #### 원격저장소에 있는 브랜치 받기
  - `git checkout -b 로컬에새로만들브랜치이름 원격저장소이름(ex:origin)/원격저장소에있는브랜치이름`

- #### 원격저장소에 있는 브랜치 받기(원격저장소 브랜치 이름과 동일하게 생성)
  - `git checkout -t 원격저장소이름(ex:origin)/원격저장소에있는브랜치이름`

- #### 추가 된 이력 조회
  - `git log --all`

- #### 원격 저장소에 있는 코드로 로컬 저장소에 있는 코드 갱신
  - `git pull`

- #### 원격저장소에 있는 특정 브랜치를 pull 받을 때
  - `git pull 원격저장소이름(ex:origin) 브랜치이름`
    - pull 이나 merge 할 때 메세지 적으라고 unix 화면 나올 때가 있는데 그냥 :wq! 하고 나가면됨

- #### 다른 브랜치에 있는 변경 내용을 현재 브랜치와 병합
  - `git merge 가져올브랜치`

- #### merge 되돌리기
  - `git reset --merge ORIG_HEAD`

- #### 변경 내용을 병합하기 전에 어떻게 변했는지 확인
  - `git diff <현재브랜치> <비교 대상 브랜치>`

- #### 현재 코드 상태 & 어떤 파일이 수정 되어 있는지
  - `git status`

- #### 커밋 관리하기
  - `git reset HEAD^` 마지막 커밋 삭제
  - `git reset --hard HEAD` 마지막 커밋 상태로 되돌림
  - `git commit --ammend` 커밋 수정하기
  - `git checkout HEAD~1` working directory 와 staging area를 모두 1단계 전 커밋으로 돌려줌

- #### 파일명 수정
  - `git mv FILE_FROM FILE_TO`
