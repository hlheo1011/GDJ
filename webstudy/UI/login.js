
document.getElementById('btn_signin').onclick = function(event) {
    var pw = document.getElementById('pw');
    if(pw.value == '') {
        alert('비밀번호를 입력하세요.');
        event.preventDefault(); // 기본동작 막기 (페이지 넘어가는것을 막아줌. / 서브밋 하면 안 될때)
        return;
    }
}

document.getElementById('id').onkeyup = function(event) {
    var id = document.getElementById('id');
    var id_msg = document.getElementById('id_msg');
    if(id.value.length == 0){
        id_msg.textContent = '';
    } else if(id.value.length < 4) {
        id_msg.textContent = '아이디는 4자 이상입니다.'
    } else if(id.value.length >= 4) {
        id_msg.textContent = '정상적인 아이디입니다.'
    }
}
// onkeyup = 글자 하나하나 쓸 때 마다

// 서브밋 이벤트 처리 방법
// form = 서브밋 이벤트
// click = 서브밋 이벤트