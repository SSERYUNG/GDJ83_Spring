const commentButton = document.getElementById("commentButton");
const commentContents = document.getElementById("commentContents");
const commentClose = document.getElementById("commentClose");
const commentList = document.getElementById("commentList");

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

    if(e.target.classList.contains("updatecommentbtn")){
        alert("수정버튼이라네")
    }
})

commentButton.addEventListener("click",()=>{
    commentClose.click();
    let contents = commentContents.value
    let itemid = commentButton.getAttribute("data-item-id")
    fetch("./commentAdd",{
        method:"POST",
        headers : {"Content-type":"application/x-www-form-urlencoded"},
        body:"boardContents="+contents+"&item_id="+itemid
    }).then((r)=>{return r.text()})
      .then((r)=>{
        r=r.trim()
        if(r>0){
            alert("댓글 추가 성공")
            getList(1);
        }
      })

    commentContents.value=""
})