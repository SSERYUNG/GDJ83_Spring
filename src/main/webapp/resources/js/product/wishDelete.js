const wishDelete = document.getElementsByClassName("wishDelete");
const allbox  = document.getElementById("allbox");
const wishcheck = document.getElementsByClassName("wishcheck");
const checkdelete = document.getElementById("checkdelete");


for(let w of wishDelete){

    w.addEventListener("click",()=>{
        let id =w.getAttribute("data-wish-delete");
        console.log(id)
        //Server로 해당 위시리스트 삭제를 요청
        // fetch 문법이 fetch("URL",)
        fetch("./deleteWishList?item_id="+id,{
            method:"GET"
        }).then((r)=>{return r.text()})
          .then((r)=>{
            r=r.trim();
            if(r>0){
                w.parentNode.parentNode.remove();
            }else{
                alert("삭제 실패")
            }
          }).catch(()=>{alert("삭제 실패")})


    })
}

allbox.addEventListener("click",()=>{
    for(let w of wishcheck){
        w.checked=allbox.checked
        }
})


for(let w of wishcheck){
    
    w.addEventListener("click",()=>{
    let flag = true;
        for(let check of wishcheck){
            if(!check.checked){
                flag=false;
                break;
            }
        }
    allbox.checked=flag;
  })
}

checkdelete.addEventListener("click",()=>{
    const e = [];
    let url ="deleteWishList?"
    for(let c of wishcheck){
        if(c.checked){
          let id = c.getAttribute("data-check-delete");
          url=url+"item_id="+id+"&";
          e.push(c.getAttribute("data-wish-delete"));
        }
    }

    url = url.substring(0,url.length-1);

    fetch(url,{
     method:"GET"
    })
    .then((r)=>{return r.text()})
    .then((r)=>{
      r=r.trim();
      if(r>0){
        for(let ele of e){
            document.getElementById(ele).remove();
            }
      }else{
        alert("삭제 실패")
      }
    }).catch(()=>{alert("삭제 실패")})
})