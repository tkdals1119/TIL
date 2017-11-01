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
