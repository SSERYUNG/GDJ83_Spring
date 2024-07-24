/**
 * 
 */
 
const btn = document.getElementById("btn");

const id = document.getElementById("inputId");
const pw = document.getElementById("inputPassword");
const name = document.getElementById("inputName");
const phone = document.getElementById("inputPhone");
const mail = document.getElementById("inputMail");

const pwerror1=document.getElementById("pwerror1");
const pwerror2=document.getElementById("pwerror2");

const frm = document.getElementById("frm");

const pwcheck = document.getElementById("passwordCheck");

const iderror = document.getElementById("iderror");

id.value=""
iderror.innerHTML=""

id.addEventListener("blur",()=>{
    fetch("./search?member_id="+id.value,{
        method:"GET"
    }).then((r)=>{return r.text()})
    .then((r)=>{
        r=r.trim();
        if(r>0){
            id.value=""
            iderror.innerHTML="이미 있는 ID입니다"
        }else{
            iderror.innerHTML=""
        }
      })
})


btn.addEventListener("click",function(){
    let finish =0;
    pwerror1.innerText="";
    let idv=id.value;
    let pwv=pw.value;
    let namev= name.value;
    let phonev=phone.value;
    let mailv=mail.value;

    if(idv==""||pwv==""||namev==""||phonev==""||mailv==""){
        alert('모든 항목을 입력해주세요');
    }else{
        frm.submit();
    }

})

pw.addEventListener("blur",function(){
    pwerror1.innerHTML=""
    pwerror2.innerHTML=""
    if(pw.value.length<8){
        pw.value="";
        pwerror1.innerHTML="비밀번호를 8글자 이상 입력하세요"
    }else{
        if(pw.value!=pwcheck.value){
            pwcheck.value="";
            pwerror2.innerHTML="비밀번호가 일치하지 않습니다. 다시 입력하세요"
        }  
    }
})

pwcheck.addEventListener("blur",function(){
    pwerror1.innerHTML=""
    pwerror2.innerHTML=""
    if(pw.value!=pwcheck.value){
        pwcheck.value="";
        pwerror2.innerHTML="비밀번호가 일치하지 않습니다. 다시 입력하세요"
    }
})