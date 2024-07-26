const commentButton = document.getElementById("commentButton");
const commentContents = document.getElementById("commentContents");
const commentClose = document.getElementById("commentClose");
const commentList = document.getElementById("commentList");
const openModal = document.getElementById("openModal");

getList(1);

function getList(page){
    fetch("commentList?item_id="+commentButton.getAttribute("data-item-id")+"&page="+page,{
        method:"GET"
    }).then(r=>r.text())
      .then(r=>commentList.innerHTML=r)
}

commentList.addEventListener("click",function(e){
    if(e.target.classList.contains('pn')){
        let p = e.target.getAttribute("data-page-num")
        getList(p);
    }
    if(e.target.classList.contains('deletecommentbtn')){
       let n = e.target.getAttribute("data-comment-num")

        fetch("deleteComment?boardNum="+n,{
            method:"GET"
        }).then(r=>r.text())
          .then(r=>{
            r=r.trim()
            if(r>0){
                alert("댓글 삭제 성공")
                getList(1);
            }
          })

    }

    if(e.target.classList.contains("ups")){
        flag=false;
        comnum = e.target.getAttribute("data-comment-num")
        let c = e.target.getAttribute("data-comment-content")
        c= document.getElementById(c).innerHTML;
        commentContents.value=c
        commentButton.innerHTML="댓글수정"
    }
})

commentButton.addEventListener("click",()=>{

    let contents = commentContents.value

    if(contents==null || contents==""){
        alert("댓글을 입력하세요")
        return;
    }

    let itemid = commentButton.getAttribute("data-item-id")

    let url="commentAdd"
    
    const form = new FormData();
    form.append("boardContents",contents);
    form.append("item_id",itemid);
    form.append("boardNum",comnum);

    
    let msg ="댓글추가 성공"

    if(!flag){
        url="commentUpdate";
        msg ="댓글수정 성공"
    }

    commentClose.click();

    fetch(url,{
        method:"POST",
        body:form
    }).then((r)=>{return r.text()})
      .then((r)=>{
        r=r.trim()
        if(r>0){
            alert(msg)
            getList(1);
        }
      })

    commentContents.value=""
})

let flag = true;
let comnum=0;

openModal.addEventListener("click",()=>{
    flag=true;
    commentButton.innerHTML="댓글등록"
    commentContents.value="";
})