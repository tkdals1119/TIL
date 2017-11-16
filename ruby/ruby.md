# RUBY

- json 형식의 데이터 리턴
  - `rendor json: @변수명`

- DB에 데이터 중복 여부 확인
  - `User.exist?(id: 변수, name: 변수)`
    - return 은 true || false

- boolean value -> json
  - `{'변수명'=>'true or false'}.to_json`

- rails/db 에서 loginid 로 유저 name 찾기
  - `@id = params[:loginid]`
  - `@name = Loginusers.find_by(userid: @id)`
  - `rendor json: @name`

- rails 에서 보낸 json 객체를 레트로핏이 받을 때 모델의 각 변수의 시리얼라이즈 네임이 동일해야함

- 컨트롤러 생성
  - `rails g controller 이름`

- 모델 생성
  - `rails g model 이름`
    - migration 폴더에 속성 추가(ex: t.string :name)
      - `rake db:migrate`

- DB 갱신
  - `rake db:migrate`

- 이미 생성되어 있는 모델에 컬럼(속성)추가
  - `rails g migration AddNewoneToList newone:string`
  - 'Newone' = 추가할 속성이름, 'List' = 테이블이름
  - 새로운 파일이 하나 생기는데 거기서 추가하면 됨

- if 문
  - `else if` 가 아니라 `elsif` 이다
